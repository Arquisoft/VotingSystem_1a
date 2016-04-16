package es.uniovi.asw.ConfParser.Parser.places.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import es.uniovi.asw.ConfParser.Parser.places.ParserPlaces;

public class ParserPlacesXLS implements ParserPlaces {

	@Override
	public List<Map<String, String>> leerDatos(File fichero) {
		List<Map<String, String>> lugares = new ArrayList<>();

		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet hoja = wB.getSheet(0);
		for (int i = 1; i < hoja.getRows(); i++) {
			Map<String, String> lugar = new HashMap<>();
			lugar.put("id", hoja.getCell(0, i).getContents());
			lugar.put("nombre", hoja.getCell(1, i).getContents());
			lugar.put("contrasena", hoja.getCell(2, i).getContents());
			lugar.put("ciudad", hoja.getCell(3, i).getContents());
			lugar.put("pais", hoja.getCell(4, i).getContents());
			lugares.add(lugar);
		}

		return lugares;
	}

}
