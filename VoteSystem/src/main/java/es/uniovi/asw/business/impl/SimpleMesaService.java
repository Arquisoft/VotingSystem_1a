package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.MesaService;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.persistence.UserRepository;
import es.uniovi.asw.persistence.VotantesRepository;

@Component
public class SimpleMesaService implements MesaService {
	
	 @Autowired
	 private VotantesRepository votanteRep;
	 
	 @Autowired
	 private UserRepository userRep;
		
	@Override
	public boolean comprobarUsuario(String dni) {
		
		Votante votante = votanteRep.findByDni(dni);
		
		if(votante==null){
			return false;
		}

		return true;
	
	}

	public void marcarVotante(String dniUsuario) {
		
		Votante votante = new Votante(dniUsuario);
		votanteRep.save(votante);
		
	}
	
	public User getUsuario(String dni){
		User usuario = userRep.findBynif(dni);
		usuario.setPassword(null);
		return usuario;
	}

}
