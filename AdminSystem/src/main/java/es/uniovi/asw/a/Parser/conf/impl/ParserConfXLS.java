package es.uniovi.asw.a.Parser.conf.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.a.Parser.conf.ParserConf;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParserConfXLS implements ParserConf{

	@Override
	public Map<String, String> leerDatos(File fichero) {
		Map<String, String> configuracion = new HashMap<>();
		
		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);
			
		} catch (BiffException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet censos = wB.getSheet(0);

		configuracion.put("fecha", censos.getCell(0, 1).getContents());
		configuracion.put("inicio", censos.getCell(1, 1).getContents());
		configuracion.put("fin", censos.getCell(2, 1).getContents());
		
		return configuracion;
	}

	
}
