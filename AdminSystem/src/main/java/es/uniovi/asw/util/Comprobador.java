package es.uniovi.asw.util;


import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.User;
import es.uniovi.asw.reportWriter.WreportP;
import es.uniovi.asw.reportWriter.WriteReport;

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
	
	public static List<User> comprobacionDatosDBUpdate(List<User> usuarios){
		
		//Pablo añade comprobación usuarios con mismo NIF. 
		//Los dos que tienen mismo NIF se van fuera
		List<User> usuariosValidos = usuarios;
		for(int i=0; i<usuarios.size();i++){
			for (int j = i; j < usuarios.size(); j++) {
				
				if(usuarios.get(i).getNIF().equalsIgnoreCase(usuarios.get(j).getNIF()))
						usuariosValidos.remove(i);
			}
		}
		
		
		return usuariosValidos;
		
	}

}
