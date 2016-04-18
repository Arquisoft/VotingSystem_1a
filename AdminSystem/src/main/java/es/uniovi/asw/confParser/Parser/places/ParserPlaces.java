package es.uniovi.asw.confParser.Parser.places;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.util.AdminException;

public interface ParserPlaces {

	/**
	 * Devuelve una lista de mapas. Cada mapa contiene la informacion de cada
	 * lugar donde se realiza la votacion
	 * 
	 * @param fichero
	 *            con los lugares
	 * @return Lista de mapas con informacion de los lugares
	 * @throws AdminException
	 */
	List<Map<String, String>> leerDatos(File fichero) throws AdminException;
}
