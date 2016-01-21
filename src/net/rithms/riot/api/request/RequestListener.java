package net.rithms.riot.api.request;

public interface RequestListener {
	public void onRequestSucceeded(Request request);

	public void onRequestFailed(Exception e);

	public void onRequestTimeout(Request request);
}