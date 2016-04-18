package es.uniovi.asw.confParser.Parser.options;

import java.io.File;
import java.util.List;

import es.uniovi.asw.util.AdminException;

public interface ParserOpt {

	/**
	 * Devuelve una lista con las opciones de voto
	 * 
	 * @param fichero
	 *            con las opciones de voto
	 * @return Lista de String con las opciones de voto
	 * @throws AdminException
	 */
	List<String> leerDatos(File fichero) throws AdminException;
}
