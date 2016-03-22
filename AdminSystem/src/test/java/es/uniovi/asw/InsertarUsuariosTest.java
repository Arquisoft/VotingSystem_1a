package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.ParserXLS;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;


public class InsertarUsuariosTest {
	
	List<User>usuarios=null;
	ConexionBDD c=null;
	
	@Before
	public void insertarUsuarios() throws IOException
	{
		c=ConexionBDD.getConexion();	
		c.eliminarDB();
		ReadCensus r=new RCensus("src/test/resources/Censos.xls",new GeneradorCartasTXT(),new ParserXLS());
		r.readCensus();
		
		//Obtiene los usuarios antes de ser insertados en BDD
		usuarios=r.getUsuarios();
		
		
	}
	
	@Test
	public void todoCamposRellenosExcel() {
		assertEquals(1,usuarios.size());
	}

	
	
	@Test
	public void testContraseña() throws IOException {
			for(int i=0;i<usuarios.size();i++)
				assertEquals(10, usuarios.get(i).getContraseña().length());
	
		
	}
	
	@After
	public void eliminarDB()
	{
		c.eliminarDB();
	}
}
