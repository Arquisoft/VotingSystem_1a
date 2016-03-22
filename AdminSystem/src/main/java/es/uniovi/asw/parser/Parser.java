package es.uniovi.asw.parser;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface Parser {
	
	/**
	 * Lee los datos del fichero y devuelve una lista de map con los 
	 * datos de los usuarios
	 * @param fichero
	 * @return
	 */
	List<Map<String,String>> leerDatos(File fichero);

}
