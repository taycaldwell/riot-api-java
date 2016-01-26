package net.rithms.riot.api;

import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.request.Request;

public class EndpointManager {

	private final ApiConfig config;

	public EndpointManager(ApiConfig config) {
		this.config = config;
	}

	// INTERNAL

	void callMethod(ApiMethod method) throws RateLimitException, RiotApiException {
		new Request(config, method);
	}

	public <T> T callMethodAndReturnDto(ApiMethod method) throws RateLimitException, RiotApiException {
		Request request = new Request(config, method);
		return request.getDto();
	}
}