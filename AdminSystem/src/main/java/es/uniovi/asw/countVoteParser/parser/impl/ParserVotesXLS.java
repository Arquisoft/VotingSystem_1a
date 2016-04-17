package es.uniovi.asw.countVoteParser.parser.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import es.uniovi.asw.countVoteParser.parser.ParserVotes;
import es.uniovi.asw.util.AdminException;

public class ParserVotesXLS implements ParserVotes {

	@Override
	public List<Map<String, String>> leerDatos(File fichero) throws AdminException {
		List<Map<String, String>> recuentos = new ArrayList<>();

		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);
		} catch (BiffException e) {
			throw new AdminException("El fichero no tiene la extension especificada ");
		} catch (IOException e) {
			throw new AdminException("El fichero no existe");
		}

		Sheet censos = wB.getSheet(0);
		for (int i = 1; i < censos.getRows(); i++) {
			Map<String, String> recuento = new HashMap<>();
			if (censos.getCell(0, i).getContents() == "" && censos.getCell(1, i).getContents() == ""
					&& censos.getCell(2, i).getContents() == "") {
				break;
			} else {
				recuento.put("lugar", censos.getCell(0, i).getContents());
				recuento.put("opcion", censos.getCell(1, i).getContents());
				recuento.put("numero", censos.getCell(2, i).getContents());
				recuentos.add(recuento);
			}
		}

		return recuentos;
	}

}
