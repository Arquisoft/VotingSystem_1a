package es.uniovi.asw.presentation;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.business.impl.SimpleOptionVoteService;
import es.uniovi.asw.business.impl.SimpleVoteService;
import es.uniovi.asw.model.OpcionVoto;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.UserLogin;
import es.uniovi.asw.model.Voto;

@ManagedBean(name = "voto")
@SessionScoped
public class BeanVoto implements Serializable {

	private static final long serialVersionUID = 1L;

	public BeanVoto() {
		System.out.println("BeanVoto - No existia");
	}

	@PostConstruct
	public void init() {
		System.out.println("BeanVoto PostConstruct");

	}

	public String votar(OpcionVoto opcion) {
		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleVoteService vote = ctx.getBean(SimpleVoteService.class);
		Voto v = vote.getVoteBy(opcion.getNombre());
		
			if (v != null)
				vote.updateVote(opcion.getNombre());
			else
				vote.insertVote(opcion.getNombre());
		

		return "principal";
	}

	public void opcionesVoto() {
		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleOptionVoteService vote = ctx.getBean(SimpleOptionVoteService.class);

		votos = (OpcionVoto[]) vote.getAllVoteOptions().toArray(new OpcionVoto[0]);
	}

	public OpcionVoto[] getVotos() {
		return votos;
	}

	public void setVotos(OpcionVoto[] votos) {
		this.votos = votos;
	}

	private OpcionVoto[] votos;
}
