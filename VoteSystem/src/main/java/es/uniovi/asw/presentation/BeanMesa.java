package es.uniovi.asw.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.business.impl.SimpleMesaService;

@ManagedBean(name="mesa")
public class BeanMesa {
	
	private String dniUsuario;

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	
	public String verifyUser(){
		
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleMesaService mesa = ctx.getBean(SimpleMesaService.class);
		
		boolean yaVoto = mesa.comprobarUsuario(dniUsuario);
		
		if(!yaVoto){
			mesa.marcarVotante(dniUsuario);
			FacesContext context = FacesContext.getCurrentInstance();	     
	        context.addMessage(null, new FacesMessage("Éxito",  "Se ha registrado el votante con éxito") );
		}	
		
		else{
			FacesContext context = FacesContext.getCurrentInstance();	     
	        context.addMessage(null, new FacesMessage("Fallo",  "Este usuario ya ha votado") );
			
		}
		
		dniUsuario=null;
		
		return null;
	}
	

}
