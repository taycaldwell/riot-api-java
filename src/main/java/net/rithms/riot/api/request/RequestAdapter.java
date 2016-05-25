package net.rithms.riot.api.request;

import net.rithms.riot.api.RiotApiException;

/**
 * A template class implementing {@link RequestListener} similar to Swing's event adapters.
 * <p>
 * All method in this class do nothing, so the user only has to override the interface methods for the events they want to take action on.
 * </p>
 * 
 * @author Daniel 'Linnun' Figge
 */
public abstract class RequestAdapter implements RequestListener {

	@Override
	public void onRequestFailed(RiotApiException e) {
	}

	@Override
	public void onRequestSucceeded(AsyncRequest request) {
	}

	@Override
	public void onRequestTimeout(AsyncRequest request) {
	}
}