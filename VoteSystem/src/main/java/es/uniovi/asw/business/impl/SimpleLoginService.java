package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.business.impl.classes.LoginVerify;
import es.uniovi.asw.model.UserLogin;

public class SimpleLoginService implements LoginService {
	@Override
	public UserLogin verify(String login, String password) {
		if (!validLogin(login, password))
			return null;
		return getUserLogin(login);
	}

	private UserLogin getUserLogin(String login){
		return new LoginVerify().getUserLogin(login);
	}
	
	private boolean validLogin(String login, String password) {
		return new LoginVerify().verifyPassword(login, password);
	}
}