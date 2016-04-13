package es.uniovi.asw.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.business.impl.SimpleLoginMesaService;
import es.uniovi.asw.model.LugarVoto;

@ManagedBean(name="loginMesa")
@RequestScoped
public class BeanLoginMesa implements Serializable {
	private static final long serialVersionUID = 6L;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String password = "";
	private String result;

	public BeanLoginMesa() {
		System.out.println("BeanLoginMesa - No existia");
		id=null;
		result="";
	}
	
	 @PostConstruct
	    public void init(){
	        System.out.println("BeanLoginMesa PostConstruct");        
	        this.result="";
	    }

	public String verify() {		
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleLoginMesaService login = ctx.getBean(SimpleLoginMesaService.class);
		
		LugarVoto mesa = login.verify(id, password);
		if (mesa != null) {
			putMesaInSession(mesa);
			return "principalMesa";
		}
		setResult("Contraseña o identificador incorrecto");
		return null;
	}

	public String closeSession(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "loginMesa";
	}
	
	private void putMesaInSession(LugarVoto mesa) {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		session.put("LOGGEDIN_MESA", mesa);
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