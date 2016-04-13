package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.OptionVoteService;
import es.uniovi.asw.model.OpcionVoto;
import es.uniovi.asw.persistence.OptionsRepository;

@Component
public class SimpleOptionVoteService implements OptionVoteService {

	@Autowired
	private OptionsRepository option;
	
	@Override
	public List<OpcionVoto> getAllVoteOptions() {
		List<OpcionVoto> lista = option.findAll();
		return lista;
	}

}
