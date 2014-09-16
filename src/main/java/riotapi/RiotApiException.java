package main.java.riotapi;

/**
 *
 * @author Jasper
 */
public class RiotApiException extends Exception {

    public static enum Type {

        BAD_REQUEST, DATA_NOT_FOUND, PARSE_FAILURE, RATE_LIMITED, SERVER_ERROR, UNAUTHORIZED, UNAVAILABLE, UNKNOWN;
    }

    public final Type type;

    public RiotApiException(final Type type) {
        super(getMessage(type));
        this.type = type;
    }

    private static String getMessage(final Type type) {
        switch (type) {
            case BAD_REQUEST:
                return "Bad request";
            case DATA_NOT_FOUND:
                return "Requested data not found";
            case PARSE_FAILURE:
                return "Failed to parse Riot's JSON response";
            case RATE_LIMITED:
                return "Rate limit exceeded";
            case SERVER_ERROR:
                return "Internal server error";
            case UNAUTHORIZED:
                return "Unauthorized";
            case UNAVAILABLE:
                return "Service unavailable";
            case UNKNOWN:
                return "An unknown API error occured";
            default:
                return "An unknown API error occured";
        }
    }
}
