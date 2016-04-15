package es.uniovi.asw.ConfParser;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import es.uniovi.asw.ConfParser.Parser.conf.ParserConf;
import es.uniovi.asw.DBVote.impl.InsertConfP;
import es.uniovi.asw.model.Configuracion;

public class RConf {

	File fichero;
	ParserConf parser;

	public RConf(String ruta, ParserConf parser) {
		fichero = new File(ruta);

		this.parser = parser;
	}

	public void leerDatos() {
		Configuracion conf = new Configuracion();
		// Recibe una lista o un map de strings
		Map<String, String> configuracion = parser.leerDatos(fichero);
		Date fecha = null;
		int inicio = 0, fin = 0;
		// Los formatea correctamente
		if (!configuracion.isEmpty()) {
			System.out.println(configuracion.get("fecha"));
			System.out.println(configuracion.get("inicio"));
			System.out.println(configuracion.get("fin"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			try {
				fecha = format.parse(configuracion.get("fecha"));

				inicio = Integer.parseInt(configuracion.get("inicio"));
				fin = Integer.parseInt(configuracion.get("fin"));

				conf = new Configuracion(fecha, inicio, fin);
			} catch (ParseException e) {
				System.out.println("Error con la fecha: '" + configuracion.get("fecha") + "'");
			} catch (NumberFormatException e) {
				System.out.println("Error en la hora de inicio o fin");
			}
		} else {
			System.out.println("El fichero de configuracion esta vacio");
		}
		// Lo guarda en la BD a traves de InsertConfP

		InsertConfP.setConf(conf);
	}

}
