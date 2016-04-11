package es.uniovi.asw.ConfParser;

import java.io.File;
import java.util.List;

import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;



public class ROptions {

	File fichero;
	ParserOpt parser;
	
	public ROptions(String ruta, ParserOpt parser) {
		fichero = new File(ruta);
		
		this.parser = parser;
	}
	
	public void leerDatos(){
		//Recibe una lista o un map de strings
		List<String> opciones = parser.leerDatos(fichero);
		//Los formatea correctamente
		if(!opciones.isEmpty()){
			for (int i = 0; i < opciones.size(); i++) {
				System.out.println(opciones.get(i));
			}
		}
		else{
			System.out.println("Las opciones estan vacias");
		}
		//Lo guarda en la BD a traves de InsertConfP
	}
	
}
