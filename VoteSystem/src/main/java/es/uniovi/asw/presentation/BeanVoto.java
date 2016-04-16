package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.business.impl.SimpleConfiguracionService;
import es.uniovi.asw.business.impl.SimpleOptionVoteService;
import es.uniovi.asw.business.impl.SimpleVoteService;
import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.model.OpcionVoto;
import es.uniovi.asw.model.Voto;

@ManagedBean(name = "voto")
@RequestScoped
public class BeanVoto implements Serializable {

	private static final long serialVersionUID = 1L;

	public BeanVoto() {
		System.out.println("BeanVoto - No existia");
	}

	@PostConstruct
	public void init() {
		System.out.println("BeanVoto PostConstruct");

	}

	@SuppressWarnings("deprecation")
	public String votar(OpcionVoto opcion) {
	WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleVoteService vote = ctx.getBean(SimpleVoteService.class);

		WebApplicationContext ctx1 = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleConfiguracionService config = ctx1.getBean(SimpleConfiguracionService.class);

		Configuracion c = config.getConf();
		String s = getFecha(c.getFecha().toString());
		Voto v = vote.getVoteBy(opcion.getNombre());
		Timestamp actual = new Timestamp(new Date().getTime());
		String act = getFecha(actual.toString());

		if (act.contains(s) && actual.getHours() >= c.getHoraInicio() && actual.getHours() <= c.getHoraFin()) {
			if (v != null)
				vote.updateVote(opcion.getNombre());
			else
				vote.insertVote(opcion.getNombre());
			setResult("Ya ha votado, no puede realizar mas votos");
			setVotado(true);
		}else {
			setVotado(true);
			setResult("Esta fuera de plazo de votacion");
		}

		return null;
	}

	public void opcionesVoto() {
		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleOptionVoteService vote = ctx.getBean(SimpleOptionVoteService.class);

		votos = (OpcionVoto[]) vote.getAllVoteOptions().toArray(new OpcionVoto[0]);
	}

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public OpcionVoto[] getVotos() {
		return votos;
	}

	public void setVotos(OpcionVoto[] votos) {
		this.votos = votos;
	}

	public boolean isVotado() {
		return votado;
	}

	public void setVotado(boolean votado) {
		this.votado = votado;
	}

	private boolean votado;

	private String getFecha(String date) {
		String[] trozos = date.split(" ");// divido el timestamp en la fecha y
											// la hora
		date = trozos[0];// cojo la fecha que necesito
		return date;

	}

	private OpcionVoto[] votos;
}
