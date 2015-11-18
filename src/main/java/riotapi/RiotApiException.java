package main.java.riotapi;

/**
 * 
 * @author Jasper
 */
public class RiotApiException extends Exception {

	private static final long serialVersionUID = 2658256159686373725L;
	public static final int BAD_REQUEST = 400;
	public static final int FORBIDDEN = 403;
	public static final int DATA_NOT_FOUND = 404;
	public static final int UNAUTHORIZED = 401;
	public static final int UNPROCESSABLE_ENTITY = 422;
	public static final int RATE_LIMITED = 429;
	public static final int SERVER_ERROR = 500;
	public static final int UNAVAILABLE = 503;
	public static final int PARSE_FAILURE = 600;
	public static final int IOEXCEPTION = 601;

	private final int errorCode;
	private final int retryAfter;
	private final String rateLimitType;

	public RiotApiException(final int errorCode) {
		super(getMessage(errorCode));
		this.errorCode = errorCode;
		this.retryAfter = 0;
		this.rateLimitType = null;
	}
	
	public RiotApiException(final int errorCode, final int retryAfter, final String rateLimitType) {
		super(getMessage(errorCode));
		this.errorCode = errorCode;
		this.retryAfter = retryAfter;
		this.rateLimitType = rateLimitType;
	}

	public static String getMessage(final int errorCode) {
		switch (errorCode) {
		case BAD_REQUEST:
			return "Bad request";
		case FORBIDDEN:
			return "Forbidden";
		case DATA_NOT_FOUND:
			return "Requested data not found";
		case IOEXCEPTION:
			return "I/O Exception thrown";
		case PARSE_FAILURE:
			return "Failed to parse Riot's JSON response";
		case UNPROCESSABLE_ENTITY:
			return "Summoner has an entry, but hasn't played since the start of 2013";
		case RATE_LIMITED:
			return "Rate limit exceeded";
		case SERVER_ERROR:
			return "Internal server error";
		case UNAUTHORIZED:
			return "Unauthorized";
		case UNAVAILABLE:
			return "Service unavailable";
		default:
			return "An unknown API error occured";
		}
	}

	public int getErrorCode() {
		return this.errorCode;
	}
	
	public int getRetryAfter() {
		return this.retryAfter;
	}
	
	public String getRateLimitType() {
		return this.rateLimitType;
	}
}