package com.github.rithms.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.Properties;

import com.github.rithms.riotapi.Request;

public class PropertiesLoader {

	protected static final String HTTP_PROXY_URL = "http.proxy.url";
	protected static final String HTTP_PROXY_PORT = "http.proxy.port";
	protected static final String HTTP_PROXY_USERNAME = "http.proxy.username";
	protected static final String HTTP_PROXY_PASSWORD = "http.proxy.password";

	public static Properties getRiotApiProperties() {
		final Properties properties = new Properties();
		final InputStream stream = Request.class.getResourceAsStream("/riotApi.properties");
		if (stream != null) {
			try {
				properties.load(stream);
				stream.close();
			} catch (IOException e) {
			}
		}
		return properties;
	}

	public static Proxy getProxy() {
		final Properties properties = PropertiesLoader.getRiotApiProperties();
		String proxyAddr = properties.getProperty(HTTP_PROXY_URL);
		Integer proxyPort = properties.getProperty(HTTP_PROXY_PORT) != null ? Integer.valueOf(properties.getProperty(HTTP_PROXY_PORT)) : null;

		if (properties.getProperty(HTTP_PROXY_USERNAME) != null && properties.getProperty(HTTP_PROXY_PASSWORD) != null) {
			Authenticator authenticator = new Authenticator() {

				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return (new PasswordAuthentication(properties.getProperty(HTTP_PROXY_USERNAME),
							properties.getProperty(HTTP_PROXY_PASSWORD).toCharArray()));
				}
			};
			Authenticator.setDefault(authenticator);
		}

		if (proxyAddr != null && proxyPort != null) {
			return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddr, proxyPort));
		}
		return null;
	}
}
