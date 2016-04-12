package es.uniovi.asw.countVoteParser;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.countVoteParser.parser.ParserVotes;

public class RVotes {

	File fichero;
	
	ParserVotes parser;
	
	public RVotes(String ruta, ParserVotes parser){
		fichero = new File(ruta);
		this.parser = parser;
	}
	
	public void leerDatos(){
		//Recibe lista de mapas con los recuentos
		List<Map<String, String>> recuentos = parser.leerDatos(fichero);
		
		//Se formatean correctamente
		for (int i = 0; i < recuentos.size(); i++) {
			Map<String, String> recuento = recuentos.get(i);
			System.out.println(recuento.get("lugar") + " " + recuento.get("opcion") + " " + recuento.get("numero"));
			
		}
		//Lo guarda en la BD a traves de InsertConfP
		
	}
}
