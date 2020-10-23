package nl.greenhighway.obp.exception;

public class JsonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6638935097136583348L;

	public JsonException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonException(String message) {
		super(message);
	}

}
