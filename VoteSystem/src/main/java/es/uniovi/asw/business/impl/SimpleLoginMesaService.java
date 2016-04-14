package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.LoginMesaService;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.persistence.MesaRepository;

@Component
public class SimpleLoginMesaService implements LoginMesaService {
	
	 @Autowired
	 private MesaRepository mesaRep;
	 
	public LugarVoto verify(Long id, String password) {
		if (!validLogin(id, password))
			return null;
		return getLugarVoto(id);
	}

	private LugarVoto getLugarVoto(Long id){
		//	UserWired dao = Factories.persistence.createUserWired();
		LugarVoto lugar = mesaRep.findByid(id);
		
		return lugar;
	}
	
	private boolean validLogin(Long id, String password) {
		LugarVoto lugar = mesaRep.findByid(id);
		
		if(lugar==null)
			return false;
		if(lugar.getContraseña().compareTo(password)==0){
			//Ocultamos la contraseña
			lugar.setContraseña("null");
			return true;
			
		}
		
		return false;
	}

	

		
}