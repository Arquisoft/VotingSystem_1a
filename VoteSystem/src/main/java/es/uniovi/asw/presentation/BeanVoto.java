package es.uniovi.asw.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.uniovi.asw.model.OpcionVoto;

@ManagedBean(name="voto")
@SessionScoped
public class BeanVoto {

	
	
	public String votar(OpcionVoto opcion) {
		
		return "principal";
	}
	
	public void opcionesVoto() {
		
	}
	
	
	
	public List<OpcionVoto> getVotos() {
		return votos;
	}

	public void setVotos(List<OpcionVoto> votos) {
		this.votos = votos;
	}



	private List<OpcionVoto> votos;
}
