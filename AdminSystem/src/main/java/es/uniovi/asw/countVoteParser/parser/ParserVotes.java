package es.uniovi.asw.countVoteParser.parser;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ParserVotes {

	/**
	 * Devuelve una lista de mapas. Cada mapa contiene el 'lugar', la 'opcion',
	 * y el 'numero' del recuento
	 * 
	 * @param fichero
	 * @return
	 */
	public List<Map<String, String>> leerDatos(File fichero);

}
