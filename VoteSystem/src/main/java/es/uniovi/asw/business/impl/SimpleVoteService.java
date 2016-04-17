package es.uniovi.asw.business.impl;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.UserLogin;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.UserRepository;
import es.uniovi.asw.persistence.VotantesRepository;
import es.uniovi.asw.persistence.VoteRepository;

@Component
public class SimpleVoteService implements VoteService {

	@Autowired
	private VoteRepository vote;

	@Autowired
	private VotantesRepository votante;

	@Autowired
	private UserRepository user;

	@Override
	public Voto getVoteBy(String opcion) {
		Voto v = vote.findByOptPlace(opcion, 0);
		return v;
	}

	@Override
	public void updateVote(String opcion) {
		User u = this.user.findOne(getUser());
		Voto v = vote.findByOptPlace(opcion, 0);
		v.setNumero(v.getNumero() + 1);
		vote.save(v);
		votante.save(new Votante(u.getNIF()));
	}

	@Override
	public void insertVote(String opcion) {
		vote.save(new Voto(opcion, 0, 1));
		User u = this.user.findOne(getUser());
		votante.save(new Votante(u.getNIF()));
	}

	private Long getUser() {
		ExternalContext contexto = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) contexto.getRequest();
		HttpSession session = request.getSession();
		UserLogin user = (UserLogin) session.getAttribute("LOGGEDIN_USER");
		return user.getId();
	}

}
