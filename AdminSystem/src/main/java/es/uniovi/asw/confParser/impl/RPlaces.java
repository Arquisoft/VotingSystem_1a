package es.uniovi.asw.confParser.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.confParser.Places;
import es.uniovi.asw.confParser.Parser.places.ParserPlaces;
import es.uniovi.asw.dbVote.impl.InsertConfP;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.util.AdminException;

public class RPlaces implements Places{

	File fichero;
	ParserPlaces parser;

	public RPlaces(String ruta, ParserPlaces parser) {
		fichero = new File(ruta);
		this.parser = parser;
	}

	public void leerDatos() throws AdminException {
		long id = 0;
		String nombre = "";
		String contraseña = "";
		String ciudad = "";
		String pais = "";

		List<LugarVoto> lugaresVotos = new ArrayList<LugarVoto>();

		// Recibe una lista o un map de strings
		List<Map<String, String>> lugares = parser.leerDatos(fichero);

		// Los formatea correctamente
		for (int i = 0; i < lugares.size(); i++) {
			Map<String, String> lugar = lugares.get(i);
			try {
				id = Long.parseLong(lugar.get("id"));
			} catch (Exception e) {
				throw new AdminException("Error en el id: '" + lugar.get("id") + "'");
			}
			nombre = lugar.get("nombre").toUpperCase();
			contraseña = lugar.get("contrasena").toUpperCase();
			ciudad = lugar.get("ciudad").toUpperCase();
			pais = lugar.get("pais").toUpperCase();
			lugaresVotos.add(new LugarVoto(id, nombre, contraseña, ciudad, pais));

		}
		// Lo guarda en la BD a traves de InsertConfP
		InsertConfP.setLugares(lugaresVotos);
	}
}
