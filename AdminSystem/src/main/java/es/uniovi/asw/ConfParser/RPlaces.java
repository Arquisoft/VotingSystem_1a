package es.uniovi.asw.ConfParser;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.ConfParser.Parser.places.ParserPlaces;


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
			System.out.println(lugar.get("id") + lugar.get("nombre") + lugar.get("contrasena") + lugar.get("ciudad") + lugar.get("pais"));
			
		}
		//Lo guarda en la BD
	}
}
