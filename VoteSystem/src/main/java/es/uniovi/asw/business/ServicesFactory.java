package es.uniovi.asw.business;

public interface ServicesFactory {
	
	LoginService createLoginService();
	
	OptionVoteService createVoteService();

}
