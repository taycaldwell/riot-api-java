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
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;

/**
 * This class is used to fire asynchronous call at the Riot Api. You should not construct these requests manually. To fire asynchronous
 * requests, use a {@link RiotApiAsync} object.
 * 
 * @author Daniel 'Linnun' Figge
 * @see RiotApiAsync
 */
public class AsyncRequest extends Request implements Runnable {

	protected final Object signal = new Object();

	protected List<RequestListener> listeners = new ArrayList<RequestListener>();
	protected Thread executionThread = null;
	private boolean sent = false;

	/**
	 * Constructs an asynchronous request
	 * 
	 * @param config
	 *            Configuration to use
	 * @param method
	 *            Api method to call
	 * @see ApiConfig
	 * @see ApiMethod
	 */
	public AsyncRequest(ApiConfig config, ApiMethod method) {
		super();
		init(config, method);
		setTimeout();
	}

	/**
	 * Adds a {@link RequestListener} to this request
	 * 
	 * @param listener
	 *            A request listener
	 * @see RequestListener
	 */
	public void addListener(RequestListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * Adds a given collection of {@link RequestListener} to this request
	 * 
	 * @param listeners
	 *            A collection of request listeners
	 * @see RequestListener
	 */
	public void addListeners(Collection<RequestListener> listeners) {
		for (RequestListener listener : listeners) {
			if (!this.listeners.contains(listener)) {
				this.listeners.add(listener);
			}
		}
	}

	/**
	 * Waits indefinitely until the request completes.
	 * <p>
	 * If the thread is interrupted while waiting for the request to complete, this method will throw an {@code InterruptedException} and
	 * the thread's interrupt flag will be cleared.
	 * </p>
	 * <p>
	 * <i>Please note that this method is blocking and thus negates the advantage of the asynchronous nature of this class. Consider using a
	 * {@link RequestListener} instead.</i>
	 * </p>
	 * 
	 * @throws InterruptedException
	 *             If the method is interrupted by calling {@link Thread#interrupt()}. The interrupt flag will be cleared
	 */
	public void await() throws InterruptedException {
		while (!isDone()) {
			synchronized (signal) {
				signal.wait();
			}
		}
	}

	/**
	 * Waits for at most the given time until the request completes.
	 * <p>
	 * If the thread is interrupted while waiting for the request to complete, this method will throw an {@code InterruptedException} and
	 * the thread's interrupt flag will be cleared.
	 * </p>
	 * <p>
	 * <i>Please note that this method is blocking and thus negates the advantage of the asynchronous nature of this class. Consider using a
	 * {@link RequestListener} instead.</i>
	 * </p>
	 *
	 * @param timeout
	 *            The maximum amount of the given time unit to wait
	 * @param unit
	 *            The time unit of the {@code timeout} argument
	 * @throws InterruptedException
	 *             If the method is interrupted by calling {@link Thread#interrupt()}. The interrupt flag will be cleared
	 * @throws TimeoutException
	 *             If the given time elapsed without the request completing
	 */
	public void await(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
		await(timeout, unit, false);
	}

	/**
	 * Waits for at most the given time until the request completes.
	 * <p>
	 * If the thread is interrupted while waiting for the request to complete, this method will throw an {@code InterruptedException} and
	 * the thread's interrupt flag will be cleared.
	 * </p>
	 * <p>
	 * <i>Please note that this method is blocking and thus negates the advantage of the asynchronous nature of this class. Consider using a
	 * {@link RequestListener} instead.</i>
	 * </p>
	 *
	 * @param timeout
	 *            The maximum amount of the given time unit to wait
	 * @param unit
	 *            The time unit of the {@code timeout} argument
	 * @param cancelOnTimeout
	 *            Whether or not the request should be cancelled, if the given {@code timeout} is elapsed without the request completing
	 * @throws InterruptedException
	 *             If the method is interrupted by calling {@link Thread#interrupt()}. The interrupt flag will be cleared
	 * @throws TimeoutException
	 *             If the given time elapsed without the request completing
	 */
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
	public boolean cancel() {
		boolean cancelled = super.cancel();
		if (!cancelled) {
			return false;
		}
		synchronized (signal) {
			signal.notifyAll();
		}
		// Try to force-quit the connection
		if (connection != null) {
			setTimeout(1);
			connection.disconnect();
		}
		return true;
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

	/**
	 * Waits if necessary for the request to complete, and then retrieves its result.
	 * 
	 * @return The object returned by the api call
	 */
	@Override
	public <T> T getDto() {
		try {
			await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			return super.getDto();
		} catch (RiotApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns {@code true} if this request has started execution
	 * 
	 * @return {@code true} if this request has started execution
	 */
	public boolean isSent() {
		return sent;
	}

	/**
	 * Removes all listeners from this request
	 * 
	 * @see RequestListener
	 */
	public void removeAllListeners() {
		listeners.clear();
	}

	/**
	 * Removes a listener from this request
	 * 
	 * @param listener
	 *            Listener to remove
	 * @see RequestListener
	 */
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