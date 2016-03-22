package es.uniovi.asw.dbUpdate;

import java.util.List;

import es.uniovi.asw.model.User;

public interface Insert {
	
	/**
	 * Recibe una lista de objetos User y lo inserta en la base de datos
	 * 
	 * @param usuarios
	 */
	boolean insertarUsuarios(List<User> usuarios);
	

}
