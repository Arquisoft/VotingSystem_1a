package es.uniovi.asw.countVoteParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.countVoteParser.parser.ParserVotes;
import es.uniovi.asw.dbVote.impl.InsertVoteP;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.util.AdminException;

public class RVotes {

	File fichero;

	ParserVotes parser;

	public RVotes(String ruta, ParserVotes parser) {
		fichero = new File(ruta);
		this.parser = parser;
	}

	public void leerDatos() throws AdminException {
		List<Voto> votos = new ArrayList<>();
		// Recibe lista de mapas con los recuentos
		List<Map<String, String>> recuentos = parser.leerDatos(fichero);

		// Se formatean correctamente
		for (int i = 0; i < recuentos.size(); i++) {
			Map<String, String> recuento = recuentos.get(i);
			String opcion = recuento.get("opcion").toUpperCase();
			long lugar = 0;
			try {
				lugar = Long.parseLong(recuento.get("lugar"));
			} catch (NumberFormatException e) {
				throw new AdminException("Error en el lugar '" + recuento.get("lugar") + "'");
			}
			int numero = 0;
			try {
				numero = Integer.parseInt(recuento.get("numero"));
			} catch (NumberFormatException e) {
				throw new AdminException("Error en el recuento '" + recuento.get("numero") + "'");
			}
			if (numero < 0) {
				throw new AdminException(
						"El recuento de la opcion '" + opcion + "' en '" + lugar + "' debe ser positivo");
			}
			if (!recuento.get("lugar").equals("")) {
				votos.add(new Voto(opcion, lugar, numero));
			}
		}
		// Lo guarda en la BD a traves de InsertVoteP
		InsertVoteP.setVotos(votos);
	}
}
