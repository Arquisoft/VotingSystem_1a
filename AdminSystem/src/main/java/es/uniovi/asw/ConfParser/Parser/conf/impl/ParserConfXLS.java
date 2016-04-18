package es.uniovi.asw.confParser.Parser.conf.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.confParser.Parser.conf.ParserConf;
import es.uniovi.asw.util.AdminException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParserConfXLS implements ParserConf {

	@Override
	public Map<String, String> leerDatos(File fichero) throws AdminException {
		Map<String, String> configuracion = new HashMap<>();

		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);
		} catch (BiffException e) {
			throw new AdminException("El fichero no tiene la extension especificada ");
		} catch (IOException e) {
			throw new AdminException("El fichero no existe");
		}

		Sheet hoja = wB.getSheet(0);
		if (hoja.getCell(0, 1).getContents() == "" && hoja.getCell(1, 1).getContents() == ""
				&& hoja.getCell(2, 1).getContents() == "")
			throw new AdminException("El fichero de opciones esta vacio");
		configuracion.put("fecha", hoja.getCell(0, 1).getContents());
		configuracion.put("inicio", hoja.getCell(1, 1).getContents());
		configuracion.put("fin", hoja.getCell(2, 1).getContents());

		return configuracion;
	}

}
