package es.uniovi.asw.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.business.impl.SimpleMesaService;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.model.User;

@ManagedBean(name = "mesa")
public class BeanMesa {

	private String dniUsuario;

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String verifyUser() {

		WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleMesaService mesaService = ctx.getBean(SimpleMesaService.class);

		boolean yaVoto = mesaService.comprobarUsuario(dniUsuario);

		if (!yaVoto) {

			FacesContext context = FacesContext.getCurrentInstance();

			LugarVoto mesa = (LugarVoto) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("LOGGEDIN_MESA");

			User usuario = mesaService.getUsuario(dniUsuario);

			// Comprobamos que el usuario esté destinado en esa mesa
			if (usuario.getCodigoMesa() == mesa.getId()) {

				mesaService.marcarVotante(dniUsuario);
				context.addMessage(null, new FacesMessage("Éxito", "Se ha registrado el votante con éxito"));

			} else {

				context.addMessage(null, new FacesMessage("Fallo", "Este usuario no puede votar en esta mesa"));
			}
		}

		else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Fallo", "Este usuario ya ha votado"));

		}

		dniUsuario = null;

		return null;
	}

}
