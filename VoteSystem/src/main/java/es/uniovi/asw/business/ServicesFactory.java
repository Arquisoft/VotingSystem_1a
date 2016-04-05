package es.uniovi.asw.business;

public interface ServicesFactory {
	
	UsersService createUserService();

	LoginService createLoginService();

}
