package es.uniovi.asw.ConfParser.Parser.conf.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import es.uniovi.asw.ConfParser.Parser.conf.ParserConf;

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
		
		Sheet hoja = wB.getSheet(0);

		configuracion.put("fecha", hoja.getCell(0, 1).getContents());
		configuracion.put("inicio", hoja.getCell(1, 1).getContents());
		configuracion.put("fin", hoja.getCell(2, 1).getContents());
		
		return configuracion;
	}

	
}
