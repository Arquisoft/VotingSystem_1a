package es.uniovi.asw.business;

public interface MesaService {
	
	public boolean comprobarUsuario(String dni);
	public void marcarVotante(String dniUsuario);

}
