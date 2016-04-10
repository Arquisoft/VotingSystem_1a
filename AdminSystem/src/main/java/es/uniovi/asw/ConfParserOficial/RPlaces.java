package es.uniovi.asw.ConfParserOficial;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.a.Parser.places.ParserPlaces;

public class RPlaces {

	File fichero;
	ParserPlaces parser;
	
	public RPlaces(String ruta, ParserPlaces parser) {
		fichero = new File(ruta);
		
		this.parser = parser;
	}
	
	public void leerDatos(){
		//Recibe una lista o un map de strings
		List<Map<String, String>> lugares = parser.leerDatos(fichero);
		//Los formatea correctamente
		for (int i = 0; i < lugares.size(); i++) {
			Map<String, String> lugar = lugares.get(i);
			System.out.println(lugar.get("id"));
			System.out.println(lugar.get("nombre"));
			System.out.println(lugar.get("contrasena"));
			System.out.println(lugar.get("ciudad"));
			System.out.println(lugar.get("pais"));
			
		}
		//Lo guarda en la BD
	}
}
