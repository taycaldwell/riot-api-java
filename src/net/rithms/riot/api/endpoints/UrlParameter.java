package net.rithms.riot.api.endpoints;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlParameter {

	private final String key;
	private final String value;

	public UrlParameter(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public UrlParameter(String key, int value) {
		this(key, String.valueOf(value));
	}

	public UrlParameter(String key, long value) {
		this(key, String.valueOf(value));
	}

	public UrlParameter(String key, boolean value) {
		this(key, value ? "1" : "0");
	}

	public UrlParameter(String key, Object value) {
		this(key, value.toString());
	}

	protected String getKey() {
		return key;
	}

	protected String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String parameter = null;
		try {
			parameter = URLEncoder.encode(getKey(), "UTF-8") + "=" + URLEncoder.encode(getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return parameter;
	}
}