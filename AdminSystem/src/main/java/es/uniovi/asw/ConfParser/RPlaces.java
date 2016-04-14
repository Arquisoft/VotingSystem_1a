package es.uniovi.asw.ConfParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.ConfParser.Parser.places.ParserPlaces;
import es.uniovi.asw.DBVote.impl.InsertConfP;
import es.uniovi.asw.model.LugarVoto;

public class RPlaces {

	File fichero;
	ParserPlaces parser;

	public RPlaces(String ruta, ParserPlaces parser) {
		fichero = new File(ruta);

		this.parser = parser;
	}

	public void leerDatos() {
		List<LugarVoto> lugaresVotos = new ArrayList<LugarVoto>();
		// Recibe una lista o un map de strings
		List<Map<String, String>> lugares = parser.leerDatos(fichero);
		// Los formatea correctamente
		for (int i = 0; i < lugares.size(); i++) {
			Map<String, String> lugar = lugares.get(i);
			System.out.println(lugar.get("id") + lugar.get("nombre") + lugar.get("contrasena") + lugar.get("ciudad")
					+ lugar.get("pais"));
			long id = Long.parseLong(lugar.get("id"));
			String nombre = lugar.get("nombre").toUpperCase();
			String contraseña = lugar.get("contrasena").toUpperCase();
			String ciudad = lugar.get("ciudad").toUpperCase();
			String pais = lugar.get("pais").toUpperCase();
			lugaresVotos.add(new LugarVoto(id, nombre, contraseña, ciudad, pais));

		}
		// Lo guarda en la BD a traves de InsertConfP
		InsertConfP.setLugares(lugaresVotos);
	}
}
