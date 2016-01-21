package net.rithms.riot.api.request;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncRequest extends Request implements Runnable {

	protected final Object signal = new Object();

	protected RequestListener listener = null;
	protected Thread executionThread = null;

	public AsyncRequest() {
		super();
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
	public void setTimeout(int timeout) {
		super.setTimeout(timeout);
		if (connection != null && timeout > 0) {
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
		}
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

	@Override
	public synchronized void execute() {
		if (state != RequestState.NotSent) {
			throw new IllegalStateException("The request has already been sent");
		}
		executionThread = new Thread(this);
		executionThread.start();
	}

	@Override
	public void run() {
		try {
			super.execute();
		} catch (Exception e) {
			exception = e;
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

	public void setListener(RequestListener listener) {
		this.listener = listener;
	}

	public RequestListener getListener() {
		return listener;
	}
}