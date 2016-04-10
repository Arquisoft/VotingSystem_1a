package es.uniovi.asw.a.Parser.places;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ParserPlaces {

	/**
	 * Devuelve una lista de mapas. Cada mapa contiene la informacion de cada
	 * lugar donde se realiza la votacion
	 * @param fichero con los lugares
	 * @return Lista de mapas con informacion de los lugares
	 */
	List<Map<String, String>> leerDatos(File fichero);
}
