package es.uniovi.asw.util;


import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.ReportWriterConf.WreportP;
import es.uniovi.asw.ReportWriterConf.WriteReport;

public class Comprobador {
	
	static WriteReport report = new WreportP();
	
	public static boolean comprobacionDatosParser(String nombre,String NIF,String email,
			String codigoMesa){
		
		if(nombre.isEmpty() || NIF.isEmpty() || email.isEmpty() ||
				codigoMesa.isEmpty()){
			
			if(nombre.isEmpty()){
				report.log("Encontrado campo nombre vacio");	
			}
			
			if(NIF.isEmpty()){
				report.log("Encontrado campo NIF vacio");	
			}
			
			if(email.isEmpty()){
				report.log("Encontrado campo email vacio");	
			}
			
			if(codigoMesa.isEmpty()){
				report.log("Encontrado campo código mesa vacio");	
			}
			
			return false;
			
		}
		
		//Comprobación codigoMesa es númerico
		try{
			
			Integer.parseInt(codigoMesa);
		
		}catch(NumberFormatException e){
			
			report.log("El codigo de mesa debe ser numérico");
			
		}
		
		
		return true;
	}
	

}
