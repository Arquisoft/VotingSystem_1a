package es.uniovi.asw.ConfParser;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.ReportWriterConf.WreportP;
import es.uniovi.asw.util.Comprobador;

public class RCensus implements ReadCensus {

	File fichero;
	InsertR insert;

	Parser parser;

	public RCensus(String ruta, Parser parser) {
		fichero = new File(ruta);
		insert = new InsertR();
		this.parser = parser;
	}

	@Override
	public void readCensus() {

		List<Map<String, String>> usuarios = parser.leerDatos(fichero);

		if (usuarios != null) {

			String nombre = "";
			String NIF = "";
			String email = "";
			String codigoMesa = "";

			for (Map<String, String> user : usuarios) {

				try {

					nombre = user.get("nombre");
					NIF = user.get("NIF");
					email = user.get("email");
					codigoMesa = user.get("codigoMesa");


				} catch (NumberFormatException e) {
					new WreportP().log("Campo no valido del excel");
				}

			}

			insert.enviarUsuarios();

		}

	}


}
