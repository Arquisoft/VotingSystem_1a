package es.uniovi.asw.business.impl.classes;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.UserLogin;
import es.uniovi.asw.persistence.UserDao;

public class LoginVerify {
	
	public boolean verifyPassword(String dni,String password){
		UserDao dao = Factories.persistence.createUserDao();
		User user = dao.findByDni(dni);
		
		if(user==null)
			return false;
		if(user.getPassword().compareTo(password)==0)
			return true;
		
		return false;
	}

	public static UserLogin getUserLogin(String login) {
		UserDao dao = Factories.persistence.createUserDao();
		User user = dao.findByDni(login);
		
		UserLogin userLogin = new UserLogin(login, user.getName(),user.getId());
		
		return userLogin;
	}
}