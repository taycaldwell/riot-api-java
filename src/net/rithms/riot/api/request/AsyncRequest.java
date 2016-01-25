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

/**
 * @author Daniel 'Linnun' Figge
 */
public class AsyncRequest extends Request implements Runnable {

	protected final Object signal = new Object();

	protected RequestListener listener = null;
	protected Thread executionThread = null;

	public AsyncRequest() {
		super();
	}

	public AsyncRequest(ApiConfig config) {
		super(config);
	}

	public void await() throws InterruptedException {
		while (!isDone()) {
			synchronized (signal) {
				signal.wait();
			}
		}
	}

	public void await(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		while (!isDone() && System.currentTimeMillis() < end) {
			synchronized (signal) {
				signal.wait(end - System.currentTimeMillis());
			}
		}
		if (!isDone()) {
			throw new TimeoutException();
		}
	}

	@Override
	public void cancel() {
		super.cancel();
		if (state != RequestState.Cancelled) {
			return;
		}
		synchronized (signal) {
			signal.notifyAll();
		}
		// Try to force-quit the connection
		setTimeout(1);
	}

	@Override
	public synchronized void execute() {
		if (state != RequestState.NotSent) {
			throw new IllegalStateException("The request has already been sent");
		}
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
			exception = e;
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
				listener.onRequestFailed(exception);
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
}