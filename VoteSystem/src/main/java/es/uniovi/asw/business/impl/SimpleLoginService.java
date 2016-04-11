package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.UserLogin;
import es.uniovi.asw.persistence.UserRepository;

@Component
public class SimpleLoginService implements LoginService {
	
	 @Autowired
	 private UserRepository userRep;
	 
	@Override
	public UserLogin verify(String login, String password) {
		if (!validLogin(login, password))
			return null;
		return getUserLogin(login);
	}

	private UserLogin getUserLogin(String login){
		//	UserWired dao = Factories.persistence.createUserWired();
		User user = userRep.findBynif(login);
		
		UserLogin userLogin = new UserLogin(login, user.getName(),user.getId());
		
		return userLogin;
	}
	
	private boolean validLogin(String dni, String password) {
		User user = userRep.findBynif(dni);
		
		if(user==null)
			return false;
		if(user.getPassword().compareTo(password)==0)
			return true;
		
		return false;
	}
	

		
}