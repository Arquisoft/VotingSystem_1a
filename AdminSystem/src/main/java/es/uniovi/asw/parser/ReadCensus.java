package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.model.User;

public interface ReadCensus {

	/**
	 * Lee los datos del censo del documento, comprueba que sean válidos
	 * y se los envía a un objeto Insert
	 */
	void readCensus();
	
	/**
	 * Obtiene los usuarios leidos y que sean válidos
	 * 
	 * @return
	 */
	List<User> getUsuarios();

}
