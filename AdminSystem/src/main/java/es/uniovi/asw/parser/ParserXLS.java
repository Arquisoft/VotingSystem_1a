package es.uniovi.asw.parser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParserXLS implements Parser {
	
	public List<Map<String,String>> leerDatos(File fichero){
		
		List<Map<String,String>> usuarios = new LinkedList<Map<String,String>>();
		
		Workbook wB = null;

		try {
			wB = Workbook.getWorkbook(fichero);
			
		} catch (BiffException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet censos = wB.getSheet("Censos");
	
				
		for(int i=1;i<censos.getRows();i++){
			
			Map<String,String> datosUsuarios = new HashMap<String,String>();
			
			String nombre = censos.getCell(0,i).getContents();
			String NIF = censos.getCell(1,i).getContents();
			String email = censos.getCell(2,i).getContents();
			String codigoMesa = censos.getCell(3,i).getContents();
			
			datosUsuarios.put("nombre", nombre);
			datosUsuarios.put("NIF", NIF);
			datosUsuarios.put("email", email);
			datosUsuarios.put("codigoMesa", codigoMesa);
					
			usuarios.add(datosUsuarios);
					
		}
		
		return usuarios;
		
	}

}
