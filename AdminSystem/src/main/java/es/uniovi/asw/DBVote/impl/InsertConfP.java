package es.uniovi.asw.DBVote.impl;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.model.OpcionVoto;

public class InsertConfP {
	
	static Configuracion conf = null;
	static List<LugarVoto> lugares = new ArrayList<>();
	static List<OpcionVoto> opciones = new ArrayList<>();
	
	
	public static Configuracion getConf() {
		return conf;
	}


	public static void setConf(Configuracion conf) {
		InsertConfP.conf = conf;
	}


	public static List<LugarVoto> getLugares() {
		return lugares;
	}


	public static void setLugares(List<LugarVoto> lugares) {
		InsertConfP.lugares = lugares;
	}


	public static List<OpcionVoto> getOpciones() {
		return opciones;
	}


	public static void setOpciones(List<OpcionVoto> opciones) {
		InsertConfP.opciones = opciones;
	}


	public static void insertConfR(){
		//Esto almacena TODO en la BD
		
		
	}

}
