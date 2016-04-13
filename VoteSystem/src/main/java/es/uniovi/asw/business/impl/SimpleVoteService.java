package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.VoteRepository;

@Component
public class SimpleVoteService implements VoteService {

	@Autowired
	private VoteRepository vote;

	@Override
	public Voto getVoteBy(String opcion) {
		Voto v = vote.findByOptPlace(opcion,0);
		return v;
	}
	
	
	@Override
	public void updateVote(String opcion) {
		vote.updateVote(opcion, 0);
		
	}


	@Override
	public void insertVote(String opcion) {
		vote.insertVote(opcion,0);
		
	}

}
