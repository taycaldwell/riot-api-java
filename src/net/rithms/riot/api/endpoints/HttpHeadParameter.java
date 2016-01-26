package net.rithms.riot.api.endpoints;

public class HttpHeadParameter {

	private final String key;
	private final String value;

	public HttpHeadParameter(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}