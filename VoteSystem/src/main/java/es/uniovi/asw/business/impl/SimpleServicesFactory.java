package es.uniovi.asw.business.impl;

import es.uniovi.asw.business.ConfiguracionService;
import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.business.OptionVoteService;
import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.VoteService;

public class SimpleServicesFactory implements ServicesFactory {


	@Override
	public LoginService createLoginService() {
		return new SimpleLoginService();
	}

	@Override
	public OptionVoteService createOptionVoteService() {
		return new SimpleOptionVoteService();
	}

	@Override
	public VoteService createVoteService() {
		return new SimpleVoteService();
	}

	@Override
	public ConfiguracionService createConfService() {
		return new SimpleConfiguracionService();
	}


}
