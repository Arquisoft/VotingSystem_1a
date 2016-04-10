package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.model.UserLogin;

@ManagedBean(name="login")
@SessionScoped
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 6L;
	private String dni = "";
	private String password = "";
	private String result;

	public BeanLogin() {
		System.out.println("BeanLogin - No existia");
	}
	
	 @PostConstruct
	    public void init(){
	        System.out.println("Creación del BeanLogin");
	        
	        this.result="";
	    }

	public String verify() {
		LoginService login = Factories.services.createLoginService();
		UserLogin user = login.verify(dni, password);
		if (user != null) {
			putUserInSession(user);
			return "principal";
		}
		setResult("Contraseña o usuario incorrecto");
		return null;
	}

	public String closeSession(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "cerrarSesion";
	}
	
	private void putUserInSession(UserLogin user) {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
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
}