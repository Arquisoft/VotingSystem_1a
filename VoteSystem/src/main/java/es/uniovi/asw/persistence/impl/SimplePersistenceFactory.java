package es.uniovi.asw.persistence.impl;

import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.UserDao;

/**
 * Implementaci??????n de la factoria que devuelve implementaci??????n de la capa
 * de persistencia con Jdbc 
 * 
 * @author alb
 *
 */
public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UserDao createUserDao() {
		return new UserJdbcDAO();
	}



}
