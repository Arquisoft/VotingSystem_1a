package es.uniovi.asw.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import es.uniovi.asw.util.GeneradorPasswords;

public class GeneradorCartasTXT implements GeneradorCartas{

	
	@Override
	public String generarCarta(String nombre,String email) {
				
		String contraseña = GeneradorPasswords.getGeneradorPasswords().generarContraseña();
		
		File file = new File("cartas/"+email+".txt");
		BufferedWriter bW;
		
		try {
			bW = new BufferedWriter(new FileWriter(file));
			bW.write("Le comunicamos que ha sido añadido al censo electoral "
					+ "y puede entrar en su cuenta con la siguiente"
					+ " información:\n\tUsuario: "+email+"\n\tContraseña: "
					+contraseña);
			
			
			bW.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return contraseña;
	}
}
