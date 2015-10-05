package main.java.riotapi;

public class RiotStringNotFound extends Exception {

	private static final long serialVersionUID = 1401308670684857994L;
	
	public RiotStringNotFound(String msg) {
		super(msg);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}