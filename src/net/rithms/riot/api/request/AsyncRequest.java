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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;

/**
 * @author Daniel 'Linnun' Figge
 */
public class AsyncRequest extends Request implements Runnable {

	protected final Object signal = new Object();

	protected RequestListener listener = null;
	protected Thread executionThread = null;

	public AsyncRequest(ApiConfig config, ApiMethod method) {
		super();
		init(config, method);
		execute();
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
			// Force Quit
			setTimeout(1);
			connection.disconnect();
		}
	}

	@Override
	protected synchronized void execute() {
		executionThread = new Thread(this);
		executionThread.start();
	}

	public RequestListener getListener() {
		return listener;
	}

	@Override
	public void run() {
		try {
			super.execute();
		} catch (Exception e) {
			setException(e);
		}
	}

	public void setListener(RequestListener listener) {
		this.listener = listener;
	}

	@Override
	protected boolean setState(RequestState state) {
		boolean success = super.setState(state);
		if (!success) {
			return false;
		}
		if (listener != null) {
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