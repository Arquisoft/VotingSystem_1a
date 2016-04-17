package es.uniovi.asw.countVoteParser.parser;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.util.AdminException;

public interface ParserVotes {

	/**
	 * Devuelve una lista de mapas. Cada mapa contiene el 'lugar', la 'opcion',
	 * y el 'numero' del recuento
	 * 
	 * @param fichero
	 * @return
	 * @throws AdminException
	 */
	public List<Map<String, String>> leerDatos(File fichero) throws AdminException;

}
