package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.business.impl.SimpleConfiguracionService;
import es.uniovi.asw.business.impl.SimpleLoginService;
import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.model.UserLogin;

@ManagedBean(name = "login")
@RequestScoped
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 6L;
	private String dni = "";
	private String password = "";
	private String result;

	public BeanLogin() {
		System.out.println("BeanLogin - No existia");
	}

	@PostConstruct
	public void init() {
		System.out.println("BeanLogin PostConstruct");
		this.result = "";
	}

	@SuppressWarnings("deprecation")
	public String verify() {
		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleLoginService login = ctx.getBean(SimpleLoginService.class);

		WebApplicationContext ctx1 = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleConfiguracionService config = ctx1.getBean(SimpleConfiguracionService.class);

		Configuracion c = config.getConf();
		String s = getFecha(c.getFecha().toString());
		Timestamp actual = new Timestamp(new Date().getTime());
		String act = getFecha(actual.toString());

		if (act.contains(s) && actual.getHours() >= c.getHoraInicio() && actual.getHours() <= c.getHoraFin()) {
			boolean yaVoto = login.comprobarUsuario(dni);
			if (!yaVoto) {

				UserLogin user = login.verify(dni, password);
				if (user != null) {
					putUserInSession(user);
					return "principal";
				}

				setResult("Contraseña o usuario incorrecto");
			}

			else {
				setResult("Este usuario ya ha votado");
			}
		} else
			setResult("El periodo de votación a finalizado");

		return null;
	}

	public String closeSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login";
	}

	private void putUserInSession(UserLogin user) {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("LOGGEDIN_USER", user);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private String getFecha(String date) {
		String[] trozos = date.split(" ");// divido el timestamp en la fecha y
											// la hora
		date = trozos[0];// cojo la fecha que necesito
		return date;

	}
}