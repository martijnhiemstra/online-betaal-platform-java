package nl.greenhighway.obp.exception;

public class CallException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2175024939642913750L;

	public CallException(String message, Throwable cause) {
		super(message, cause);
	}

	public CallException(String message) {
		super(message);
	}

}
