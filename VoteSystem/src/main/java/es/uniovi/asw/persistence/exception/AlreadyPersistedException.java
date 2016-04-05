package es.uniovi.asw.persistence.exception;


/**
 * Thrown if an operation needs to save an entity and it already exists 
 * in the persistence system 
 */
public class AlreadyPersistedException extends Exception {

	public AlreadyPersistedException() {
	}

	public AlreadyPersistedException(String message) {
		super(message);
	}

	public AlreadyPersistedException(Throwable cause) {
		super(cause);
	}

	public AlreadyPersistedException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -869974233276021892L;
}
