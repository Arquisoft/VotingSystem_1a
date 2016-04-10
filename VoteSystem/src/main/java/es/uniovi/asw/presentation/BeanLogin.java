package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import es.uniovi.asw.business.LoginService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.model.UserLogin;

@ManagedBean(name = "login")
@SessionScoped
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 6L;
	private String name = "";
	private String password = "";
	private String result = "login_form_result_valid";

	public BeanLogin() {
		System.out.println("BeanLogin - No existia");
	}

	public String verify() {
		LoginService login = Factories.services.createLoginService();
		UserLogin user = login.verify(name, password);
		if (user != null) {
			putUserInSession(user);
			return "principal";
		}
		setResult("login_form_result_error");
		return "error";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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