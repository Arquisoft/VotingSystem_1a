package es.uniovi.asw.confParser.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.confParser.Options;
import es.uniovi.asw.confParser.Parser.options.ParserOpt;
import es.uniovi.asw.dbVote.impl.InsertConfP;
import es.uniovi.asw.model.OpcionVoto;
import es.uniovi.asw.util.AdminException;

public class ROptions implements Options{

	File fichero;
	ParserOpt parser;

	public ROptions(String ruta, ParserOpt parser) {
		fichero = new File(ruta);

		this.parser = parser;
	}

	public void leerDatos() throws AdminException {
		List<OpcionVoto> opcionesVoto = new ArrayList<OpcionVoto>();
		// Recibe una lista o un map de strings
		List<String> opciones = parser.leerDatos(fichero);
		// Los formatea correctamente

		for (int i = 0; i < opciones.size(); i++) {
			opcionesVoto.add(new OpcionVoto(opciones.get(i).toUpperCase()));
		}

		// Lo guarda en la BD a traves de InsertConfP

		InsertConfP.setOpciones(opcionesVoto);
	}

}
