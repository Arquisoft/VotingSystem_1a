package es.uniovi.asw.business.impl;



import es.uniovi.asw.business.UsersService;
import es.uniovi.asw.business.impl.classes.UsersBuscar;
import es.uniovi.asw.model.User;


/**
 * Clase de implementación (una de las posibles) del interfaz de la fachada de
 * servicios
 * 
 * @author Enrique
 * 
 */
public class SimpleUserService implements UsersService {

	@Override
	public User findById(Long id) {
		return new UsersBuscar().find(id);
	}

	@Override
	public User finByLogin(String login) {
		return new UsersBuscar().findByLogin(login);
	}
}
