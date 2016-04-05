package es.uniovi.asw.business;

import es.uniovi.asw.model.UserLogin;

public interface LoginService {
	UserLogin verify(String login, String password);
}
