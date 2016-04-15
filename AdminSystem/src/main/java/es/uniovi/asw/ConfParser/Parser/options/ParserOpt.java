package es.uniovi.asw.ConfParser.Parser.options;

import java.io.File;
import java.util.List;

public interface ParserOpt {

	/**
	 * Devuelve una lista con las opciones de voto
	 * 
	 * @param fichero
	 *            con las opciones de voto
	 * @return Lista de String con las opciones de voto
	 */
	List<String> leerDatos(File fichero);
}
