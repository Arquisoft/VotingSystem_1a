package es.uniovi.asw.persistence.exception;




/*
 * This is a generic exception used for notifying any infrastructure
 * problem that prevents to resolve a service call.
 * 
 *   By "infrastructure problem" we mean any technical problem that the client
 *   doesn't need to know details about and doesn't need to do anything 
 *   to resolve it. For example:
 *   	- A database connection is down.
 *   	- The SQL syntax is wrong.
 *   	- Data base connection is not properly configured.
 *   	- etc.
 *   
 */
public class PersistenceException extends RuntimeException {
	
	public PersistenceException() {
		super();
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -2093817605790994448L;
}
