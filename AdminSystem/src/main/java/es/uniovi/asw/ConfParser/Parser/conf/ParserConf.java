package es.uniovi.asw.confParser.Parser.conf;

import java.io.File;
import java.util.Map;

import es.uniovi.asw.util.AdminException;

public interface ParserConf {

	/**
	 * Devuelve un map con la informacion de la configuracion de la votacion
	 * 
	 * @param fichero
	 *            de configuracion
	 * @return Map con la informacion
	 * @throws AdminException
	 */
	Map<String, String> leerDatos(File fichero) throws AdminException;
}
