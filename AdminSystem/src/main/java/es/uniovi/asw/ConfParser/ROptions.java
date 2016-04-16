package es.uniovi.asw.ConfParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;
import es.uniovi.asw.DBVote.impl.InsertConfP;
import es.uniovi.asw.model.OpcionVoto;

public class ROptions {

	File fichero;
	ParserOpt parser;

	public ROptions(String ruta, ParserOpt parser) {
		fichero = new File(ruta);

		this.parser = parser;
	}

	public void leerDatos() {
		List<OpcionVoto> opcionesVoto = new ArrayList<OpcionVoto>();
		// Recibe una lista o un map de strings
		List<String> opciones = parser.leerDatos(fichero);
		// Los formatea correctamente
		if (!opciones.isEmpty()) {
			for (int i = 0; i < opciones.size(); i++) {
				System.out.println(opciones.get(i));
				opcionesVoto.add(new OpcionVoto(opciones.get(i).toUpperCase()));
			}
		} else {
			System.out.println("Las opciones estan vacias");
		}
		// Lo guarda en la BD a traves de InsertConfP

		InsertConfP.setOpciones(opcionesVoto);
	}

}
