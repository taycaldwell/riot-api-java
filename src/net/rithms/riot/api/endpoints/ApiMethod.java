package net.rithms.riot.api.endpoints;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.request.RequestMethod;

public class ApiMethod {

	protected final ApiConfig config;
	private String urlBase;
	private final List<UrlParameter> urlParameters = new LinkedList<UrlParameter>();
	private final List<HttpHeadParameter> httpHeadParameters = new LinkedList<HttpHeadParameter>();
	private RequestMethod method = RequestMethod.GET;
	private String body = null;
	private Class<?> dtoClass = null;
	private Type dtoType = null;

	protected ApiMethod(ApiConfig config) {
		this.config = config;
	}

	protected void add(HttpHeadParameter p) {
		httpHeadParameters.add(p);
	}

	protected void add(UrlParameter p) {
		urlParameters.add(p);
	}

	protected void addApiKeyParameter() {
		add(new UrlParameter("api_key", config.getKey()));
	}

	protected void addTournamentApiKeyHeadParameter() {
		add(new HttpHeadParameter("X-Riot-Token", config.getTournamentKey()));
	}

	protected void addTournamentApiKeyParameter() {
		add(new UrlParameter("api_key", config.getTournamentKey()));
	}

	public void buildJsonBody(Map<String, Object> map) {
		body = new Gson().toJson(map);
	}

	public String getBody() {
		return body;
	}

	public Class<?> getDtoClass() {
		return dtoClass;
	}

	public Type getDtoType() {
		return dtoType;
	}

	public List<HttpHeadParameter> getHttpHeadParameters() {
		return httpHeadParameters;
	}

	public RequestMethod getMethod() {
		return method;
	}

	public String getUrl() {
		StringBuilder url = new StringBuilder(urlBase);
		char connector = '?';
		for (UrlParameter p : urlParameters) {
			url.append(connector).append(p.toString());
			connector = '&';
		}
		return url.toString();
	}

	public void setDtoType(Class<?> dtoClass) {
		this.dtoClass = dtoClass;
	}

	public void setDtoType(Type dtoType) {
		this.dtoType = dtoType;
	}

	protected void setMethod(RequestMethod method) {
		this.method = method;
	}

	protected void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}
}