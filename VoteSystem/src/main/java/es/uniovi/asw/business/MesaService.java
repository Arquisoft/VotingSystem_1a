package es.uniovi.asw.business;

import es.uniovi.asw.model.User;

public interface MesaService {
	
	public boolean comprobarUsuario(String dni);
	public void marcarVotante(String dniUsuario);
	public User getUsuario(String dniUsuario);

}
