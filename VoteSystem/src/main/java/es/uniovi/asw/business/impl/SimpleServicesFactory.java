package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.business.ServicesFactory;

public class SimpleServicesFactory implements ServicesFactory {


	@Override
	public LoginService createLoginService() {
		return new SimpleLoginService();
	}


}
