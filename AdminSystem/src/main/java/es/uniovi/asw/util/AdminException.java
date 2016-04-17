package es.uniovi.asw.util;

public class AdminException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String error;

	public AdminException(String error) {
		this.error = error;
	}

	@Override
	public void printStackTrace() {
		System.out.println(error);
	}
}
