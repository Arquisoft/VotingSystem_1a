package es.uniovi.asw.ConfParser;

import java.io.File;
import java.util.Map;

import es.uniovi.asw.ConfParser.Parser.conf.ParserConf;


public class RConf {

	File fichero;
	ParserConf parser;
	
	public RConf(String ruta, ParserConf parser) {
		fichero = new File(ruta);
		
		this.parser = parser;
	}
	
	public void leerDatos(){
		//Recibe una lista o un map de strings
		Map<String, String> configuracion = parser.leerDatos(fichero);
		//Los formatea correctamente
		if(!configuracion.isEmpty()){
			System.out.println(configuracion.get("fecha"));
			System.out.println(configuracion.get("inicio"));
			System.out.println(configuracion.get("fin"));
		}
		else{
			System.out.println("El fichero de configuracion esta vacio");
		}
		//Lo guarda en la BD
	}
	
}
