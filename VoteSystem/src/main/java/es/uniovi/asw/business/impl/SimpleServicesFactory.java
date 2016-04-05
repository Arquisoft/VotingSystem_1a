package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.UsersService;

public class SimpleServicesFactory implements ServicesFactory {


	public UsersService createUserService() {
		return new SimpleUserService();
	}

	@Override
	public LoginService createLoginService() {
		return new SimpleLoginService();
	}


}
