package es.uniovi.asw.presentation;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;


import es.uniovi.asw.business.impl.SimpleOptionVoteService;
import es.uniovi.asw.model.OpcionVoto;

@ManagedBean(name="voto")
@SessionScoped
public class BeanVoto implements Serializable {

	private static final long serialVersionUID = 1L;

	public BeanVoto() {
		System.out.println("BeanVoto - No existia");
	}
	
	 @PostConstruct
	    public void init(){
	        System.out.println("BeanVoto PostConstruct");    
	      
	        
	    }


	public String votar(OpcionVoto opcion) {
		
		return "principal";
	}
	
	public  void opcionesVoto() {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleOptionVoteService vote = ctx.getBean(SimpleOptionVoteService.class);
		
		votos = (OpcionVoto[])vote.getAllVoteOptions().toArray(new OpcionVoto[0]);
	}
	
	
	
	public OpcionVoto[] getVotos() {
		return votos;
	}

	public void setVotos(OpcionVoto[] votos) {
		this.votos = votos;
	}



	private OpcionVoto[] votos;
}
