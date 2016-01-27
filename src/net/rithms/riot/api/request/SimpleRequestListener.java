package net.rithms.riot.api.request;

/**
 * This is a simple implementation of the RequestListener, implementing all required methods with an empty body. This way other classes can
 * extend this simple implementation and only need to override the methods they really care about.
 * 
 * @author Daniel 'Linnun' Figge
 */
public class SimpleRequestListener implements RequestListener {

	@Override
	public void onRequestFailed(Exception e) {
	}

	@Override
	public void onRequestSucceeded(AsyncRequest request) {
	}

	@Override
	public void onRequestTimeout(AsyncRequest request) {
	}
}