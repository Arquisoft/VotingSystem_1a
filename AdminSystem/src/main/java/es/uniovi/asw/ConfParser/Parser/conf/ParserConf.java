package es.uniovi.asw.ConfParser.Parser.conf;

import java.io.File;
import java.util.Map;

public interface ParserConf {

	/**
	 * Devuelve un map con la informacion de la configuracion de la votacion
	 * 
	 * @param fichero
	 *            de configuracion
	 * @return Map con la informacion
	 */
	Map<String, String> leerDatos(File fichero);
}
