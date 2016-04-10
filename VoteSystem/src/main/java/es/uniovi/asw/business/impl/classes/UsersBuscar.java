package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.UserDao;

public class UsersBuscar {

	public User find(Long id) {
		UserDao dao = Factories.persistence.createUserDao();
		User u = dao.findById(id);
		return u;
	}
	
	public User findByLogin(String login) {
		UserDao dao = Factories.persistence.createUserDao();
		User u = dao.findByEmail(login);
		return u;
	}

}
