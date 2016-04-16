package es.uniovi.asw.business;

import es.uniovi.asw.model.Voto;

public interface VoteService {

	Voto getVoteBy(String opcion);

	void updateVote(String opcion);

	void insertVote(String opcion);

}
