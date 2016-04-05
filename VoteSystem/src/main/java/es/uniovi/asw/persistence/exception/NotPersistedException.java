package es.uniovi.asw.persistence.exception;



/**
 * Thrown if an operation needs to load an entity and does't exist 
 * in the persistence system 
 */
public class NotPersistedException extends Exception {

	public NotPersistedException() {
	}

	public NotPersistedException(String message) {
		super(message);
	}

	public NotPersistedException(Throwable cause) {
		super(cause);
	}

	public NotPersistedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static final long serialVersionUID = -4201153961047491939L;
}
