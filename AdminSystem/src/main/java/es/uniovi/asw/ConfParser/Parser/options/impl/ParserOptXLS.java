package es.uniovi.asw.ConfParser.Parser.options.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;
import es.uniovi.asw.util.AdminException;

public class ParserOptXLS implements ParserOpt {

	@Override
	public List<String> leerDatos(File fichero) throws AdminException {

		List<String> opciones = new ArrayList<>();
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
			if (hoja.getCell(0, i).getContents() == "")
				break;
			opciones.add(hoja.getCell(0, i).getContents());
		}

		return opciones;
	}

}
