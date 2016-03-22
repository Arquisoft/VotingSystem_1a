package es.uniovi.asw.util;

import java.util.Random;

public class GeneradorPasswords {
	
	
	private static GeneradorPasswords generador;
	
	private GeneradorPasswords(){
		
	}
	
	public String generarContraseña() {
		  char[] caracteres;
		  String password = "";
	        caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8'
	        		, '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
	        		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	        		'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
	        		'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
	        		'u', 'v', 'w', 'x', 'y', 'z'};
	        try {
	            int repet = 10;
	            for (int i = 0; i < repet; i++) {
	            	password += caracteres[new Random().nextInt(62)];
	            }
	            
	        } catch (NumberFormatException ex) {
	            ex.printStackTrace(System.out);
	        }
	        
	       return password; 
	        
	}
	
	public static GeneradorPasswords getGeneradorPasswords(){
		if(generador==null){
			generador=new GeneradorPasswords();
		}
		
		return generador;
	}
	
	
	

}
