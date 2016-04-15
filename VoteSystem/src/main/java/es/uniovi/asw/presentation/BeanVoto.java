package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	@SuppressWarnings( "deprecation" )
	public String votar(OpcionVoto opcion) {
		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleVoteService vote = ctx.getBean(SimpleVoteService.class);

		WebApplicationContext ctx1 = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleConfiguracionService config = ctx1.getBean(SimpleConfiguracionService.class);

		Configuracion c = config.getConf();
		String s = c.getFecha().toString();
		String[] trozos = s.split(" ");//divido el timestamp en la fecha y la hora
		s=trozos[0];//cojo la fecha que necesito
		Voto v = vote.getVoteBy(opcion.getNombre());
		Timestamp actual = new Timestamp(new Date().getTime());
		trozos=actual.toString().split(" ");
		String act  = trozos[0];

		if (act.contains(s) && actual.getHours() >= c.getHoraInicio() 
				&& actual.getHours() <= c.getHoraFin()) {
			if (v != null)
				vote.updateVote(opcion.getNombre());
			else
				vote.insertVote(opcion.getNombre());

		
		}
		
		setVotado(true);
			

		return null;
	}

	public void opcionesVoto() {
		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleOptionVoteService vote = ctx.getBean(SimpleOptionVoteService.class);

		votos = (OpcionVoto[]) vote.getAllVoteOptions().toArray(new OpcionVoto[0]);
	}

	private boolean votado;

	public boolean isVotado() {
		return votado;
	}

	public void setVotado(boolean votado) {
		this.votado = votado;
	}

	public OpcionVoto[] getVotos() {
		return votos;
	}

	public void setVotos(OpcionVoto[] votos) {
		this.votos = votos;
	}

	private Date getFecha(Date date) {
	
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date inicioFormateado = null;
		try {
			inicioFormateado = new Date(formato.parse(date.toString()).getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return inicioFormateado;
	}

	private OpcionVoto[] votos;
}
