package es.uniovi.asw.confParserPrueba.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import es.uniovi.asw.confParserPrueba.Conf;
import es.uniovi.asw.confParserPrueba.Parser.conf.ParserConf;
import es.uniovi.asw.dbVote.impl.InsertConfP;
import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.util.AdminException;

public class RConf implements Conf{

	File fichero;
	ParserConf parser;

	public RConf(String ruta, ParserConf parser) {
		fichero = new File(ruta);

		this.parser = parser;
	}

	public void leerDatos() throws AdminException {
		Configuracion conf = new Configuracion();
		// Recibe una lista o un map de strings
		Map<String, String> configuracion = parser.leerDatos(fichero);
		Date fecha = null;
		int inicio = 0, fin = 0;
		// Los formatea correctamente

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			fecha = format.parse(configuracion.get("fecha"));

			inicio = Integer.parseInt(configuracion.get("inicio"));
			fin = Integer.parseInt(configuracion.get("fin"));

			if (fin <= inicio) {
				throw new AdminException("La hora de inicio debe ser anterior a la final");
			}
			conf = new Configuracion(fecha, inicio, fin);
		} catch (ParseException e) {
			throw new AdminException("Error con la fecha: '" + configuracion.get("fecha") + "'");
		} catch (NumberFormatException e) {
			throw new AdminException("Error en la hora de inicio o fin");
		}

		// Lo guarda en la BD a traves de InsertConfP

		InsertConfP.setConf(conf);
	}

}
