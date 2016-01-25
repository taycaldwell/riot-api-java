package net.rithms.riot.api;

public class ApiConfig {

	private String key = null;
	private String tournamentKey = null;
	private int timeout = 0;

	@Override
	public ApiConfig clone() {
		return new ApiConfig().setKey(getKey()).setTournamentKey(getTournamentKey()).setTimeout(getTimeout());
	}

	public String getKey() {
		return key;
	}

	public int getTimeout() {
		return timeout;
	}

	public String getTournamentKey() {
		return tournamentKey;
	}

	public ApiConfig setKey(String key) {
		this.key = key;
		return this;
	}

	public ApiConfig setTimeout(int timeout) {
		this.timeout = timeout;
		return this;
	}

	public ApiConfig setTournamentKey(String tournamentKey) {
		this.tournamentKey = tournamentKey;
		return this;
	}
}