package es.uniovi.asw.ConfParser.Parser.options.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;

public class ParserOptXLS implements ParserOpt{

	@Override
	public List<String> leerDatos(File fichero) {
		
		List<String> opciones = new ArrayList<>();
		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);
			
		} catch (BiffException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet censos = wB.getSheet(0);
	
				
		for(int i=1;i<censos.getRows();i++){
			opciones.add(censos.getCell(0,i).getContents());
		}
		
		return opciones;
	}

}
