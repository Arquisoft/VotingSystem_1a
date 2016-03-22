package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.ParserXLS;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

public class BDExcelCompletoTest {

	List<User> excel = null;
	List<User> db = null;
	ConexionBDD c=null;


	@Before
	public void inicializar() throws SQLException {
				
		c=ConexionBDD.getConexion();
		c.eliminarDB();
		ReadCensus readCensus = new RCensus("Censos.xls",
				new GeneradorCartasTXT(), new ParserXLS());
		readCensus.readCensus();
		excel = readCensus.getUsuarios();
		db = c.obtenerUsuarios();

	}

	

	@Test
	public void testNumeroDatos() {
		// Esto significa que la BD esta encendida
		assertEquals(excel.size(), db.size());

	}

	@Test
	public void coincidenciaDatosExcelDB() {
		//comprueba que exista los mismos datos en el excel que en la base de datos
		for (int i = 0; i < excel.size(); i++) {
			assertTrue(db.contains(excel.get(i)));
		}

	}

	@Test
	public void testContraseña() throws IOException {
			for(int i=0;i<db.size();i++)
				assertEquals(10,db.get(i).getContraseña().length());
	
		
	}
	
	@Test
	public void todosCamposRellenos()
	{
		//comprueba que todos los campos de la DB esten rellenos
		for(User u:db)
		{
			assertTrue(!u.getName().equals(null));
			assertTrue(!u.getNIF().equals(null));
			assertTrue(!u.getEmail().equals(null));
			assertTrue(u.getCodigoMesa()!=0);
			assertTrue(!u.getContraseña().equals(null));
		}
	}
	
	@After
	public void eliminarDB()
	{
		c.eliminarDB();
	}
	
	
}
