package rent.property.RentIt.exception;

public class DuplicateOwnerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateOwnerException(String exception) {
		super(exception);
	}
	
	public DuplicateOwnerException() {
		super();
	}

	public DuplicateOwnerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateOwnerException(String message, Throwable cause) {
		super(message, cause);
	}

	
	public DuplicateOwnerException(Throwable cause) {
		super(cause);
	}
	
}
