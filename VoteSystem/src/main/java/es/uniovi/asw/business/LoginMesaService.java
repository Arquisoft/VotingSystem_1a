package es.uniovi.asw.business;

import es.uniovi.asw.model.LugarVoto;

public interface LoginMesaService {
	LugarVoto verify(Long id, String password);
}
