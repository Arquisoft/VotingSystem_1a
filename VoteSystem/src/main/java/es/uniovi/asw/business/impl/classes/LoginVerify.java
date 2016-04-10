package es.uniovi.asw.business.impl.classes;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.UserLogin;
import es.uniovi.asw.persistence.UserWired;

@Service
@Transactional
public class LoginVerify {
	
	 @Autowired
	 UserWired dao;
	 
	public boolean verifyPassword(String dni,String password){	
		User user = dao.findBynif(dni);
		
		if(user==null)
			return false;
		if(user.getPassword().compareTo(password)==0)
			return true;
		
		return false;
	}

	public UserLogin getUserLogin(String login) {
	//	UserWired dao = Factories.persistence.createUserWired();
		User user = dao.findBynif(login);
		
		UserLogin userLogin = new UserLogin(login, user.getName(),user.getId());
		
		return userLogin;
	}
	
}