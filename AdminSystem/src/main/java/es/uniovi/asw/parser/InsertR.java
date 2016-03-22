package es.uniovi.asw.parser;

import java.util.LinkedList;
import java.util.List;

import es.uniovi.asw.dbUpdate.Insert;
import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.model.User;
import es.uniovi.asw.util.Comprobador;

public class InsertR {
	
	List<User> usuarios = new LinkedList<User>();


	public void insertarUsuarios(String nombre, String NIF, String email, 
			String codigoMesa,String contraseña) {
		
		Comprobador.comprobacionDatosParser(nombre,NIF,email,codigoMesa);	
		usuarios.add(new User(nombre,NIF,email,Integer.parseInt(codigoMesa),
				contraseña));
		
		
	}
	
	public List<User> getUsuarios(){
		return usuarios;
	}


	public void enviarUsuarios() {
		boolean result=true;
		if(getUsuarios().size()>0 && result){
			Insert insert = new InsertP();	
			result=insert.insertarUsuarios(usuarios);
		}
		
	}
	




}
