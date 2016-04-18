package es.uniovi.asw.confParserPrueba.Parser.places.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.confParserPrueba.Parser.places.ParserPlaces;
import es.uniovi.asw.util.AdminException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParserPlacesXLS implements ParserPlaces {

	@Override
	public List<Map<String, String>> leerDatos(File fichero) throws AdminException {
		List<Map<String, String>> lugares = new ArrayList<>();

		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);
		} catch (BiffException e) {
			throw new AdminException("El fichero no tiene la extension especificada ");
		} catch (IOException e) {
			throw new AdminException("El fichero no existe");
		}

		Sheet hoja = wB.getSheet(0);
		for (int i = 1; i < hoja.getRows(); i++) {
			if (hoja.getCell(0, i).getContents() == "" && hoja.getCell(1, i).getContents() == ""
					&& hoja.getCell(2, i).getContents() == "" && hoja.getCell(3, i).getContents() == ""
					&& hoja.getCell(4, i).getContents() == "") {
				break;
			} else {
				Map<String, String> lugar = new HashMap<>();
				lugar.put("id", hoja.getCell(0, i).getContents());
				lugar.put("nombre", hoja.getCell(1, i).getContents());
				lugar.put("contrasena", hoja.getCell(2, i).getContents());
				lugar.put("ciudad", hoja.getCell(3, i).getContents());
				lugar.put("pais", hoja.getCell(4, i).getContents());
				lugares.add(lugar);
			}
		}

		return lugares;
	}

}
