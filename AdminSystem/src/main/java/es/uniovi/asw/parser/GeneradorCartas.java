package es.uniovi.asw.parser;

public interface GeneradorCartas {
	
	/**
	 * 
	 * Recibe los datos de un usuario y emite una carta comunicándole que ha 
	 * sido añadido al Censo Electoral, su usuario y su clave de acceso que es 
	 * generada por este método
	 * 
	 * Devuelve la clave generada
	 * 
	 * @param nombre
	 * @param email
	 * @return
	 */
	public String generarCarta(String nombre,String email);

}
