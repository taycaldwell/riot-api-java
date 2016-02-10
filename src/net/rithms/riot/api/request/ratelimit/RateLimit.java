package net.rithms.riot.api.request.ratelimit;

public class RateLimit {

	private final String type;
	private final int retryAfter;
	private final long retryTime;

	public RateLimit(String type, int retryAfter) {
		this.type = type;
		this.retryAfter = retryAfter;
		this.retryTime = System.currentTimeMillis() + (retryAfter * 1000);
	}

	public int getRetryAfter() {
		return retryAfter;
	}

	public long getRetryTime() {
		return retryTime;
	}

	public String getType() {
		return type;
	}

	public boolean isLimitExceeded() {
		return (retryTime > System.currentTimeMillis());
	}
}