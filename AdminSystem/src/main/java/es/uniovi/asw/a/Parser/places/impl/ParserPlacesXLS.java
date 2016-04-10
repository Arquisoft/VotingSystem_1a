package es.uniovi.asw.a.Parser.places.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.a.Parser.places.ParserPlaces;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParserPlacesXLS implements ParserPlaces{

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
		
		Sheet censos = wB.getSheet(0);
		for (int i = 1; i < censos.getRows(); i++) {
			Map<String, String> lugar = new HashMap<>();
			lugar.put("id", censos.getCell(0, i).getContents());
			lugar.put("nombre", censos.getCell(1, i).getContents());
			lugar.put("contrasena", censos.getCell(2, i).getContents());
			lugar.put("ciudad", censos.getCell(3, i).getContents());
			lugar.put("pais", censos.getCell(4, i).getContents());
			lugares.add(lugar);
		}
		
		return lugares;
	}

}
