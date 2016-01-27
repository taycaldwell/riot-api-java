/*
 * Copyright 2016 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.RateLimitException;
import net.rithms.riot.api.RiotApiException;

/**
 * @author Daniel 'Linnun' Figge
 */
public class AsyncRequest extends Request implements Runnable {

	protected final Object signal = new Object();

	protected List<RequestListener> listeners = new ArrayList<RequestListener>();
	protected Thread executionThread = null;
	private boolean sent = false;

	public AsyncRequest(ApiConfig config, ApiMethod method) {
		super();
		init(config, method);
		setTimeout();
	}

	public void addListener(RequestListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void addListeners(List<RequestListener> listeners) {
		for (RequestListener listener : listeners) {
			if (!this.listeners.contains(listener)) {
				this.listeners.add(listener);
			}
		}
	}

	public void await() throws InterruptedException {
		while (!isDone()) {
			synchronized (signal) {
				signal.wait();
			}
		}
	}

	public void await(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		await(timeout, unit, false);
	}

	public void await(long timeout, TimeUnit unit, boolean cancelOnTimeout) throws InterruptedException, TimeoutException {
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		while (!isDone() && System.currentTimeMillis() < end) {
			synchronized (signal) {
				signal.wait(end - System.currentTimeMillis());
			}
		}
		if (!isDone()) {
			if (cancelOnTimeout) {
				cancel();
			}
			throw new TimeoutException();
		}
	}

	@Override
	public void cancel() {
		super.cancel();
		if (!isCancelled()) {
			// If this request was already done before cancelling it, don't do anything anymore
			return;
		}
		synchronized (signal) {
			signal.notifyAll();
		}
		// Try to force-quit the connection
		if (connection != null) {
			setTimeout(1);
			connection.disconnect();
		}
	}

	@Override
	public synchronized void execute() {
		if (isSent()) {
			return;
		}
		sent = true;
		executionThread = new Thread(this);
		executionThread.start();
	}

	@Override
	public <T> T getDto() throws RiotApiException, RateLimitException {
		if (isFailed()) {
			throw getException();
		}
		if (isTimeOut()) {
			throw new RiotApiException(RiotApiException.TIMEOUT_EXCEPTION);
		}
		return super.getDto();
	}

	public boolean isSent() {
		return sent;
	}

	public void removeAllListeners() {
		listeners.clear();
	}

	public void removeListener(RequestListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void run() {
		try {
			super.execute();
		} catch (RiotApiException e) {
			setException(e);
		}
	}

	@Override
	protected boolean setState(RequestState state) {
		boolean success = super.setState(state);
		if (!success) {
			return false;
		}
		for (RequestListener listener : listeners) {
			if (state == RequestState.Succeeded) {
				listener.onRequestSucceeded(this);
			} else if (state == RequestState.Failed) {
				listener.onRequestFailed(getException());
			} else if (state == RequestState.TimeOut) {
				listener.onRequestTimeout(this);
			}
		}
		if (state == RequestState.Succeeded || state == RequestState.Failed || state == RequestState.TimeOut) {
			synchronized (signal) {
				signal.notifyAll();
			}
		}
		return true;
	}

	@Override
	protected void setTimeout() {
		setTimeout(config.getAsyncRequestTimeout());
	}
}