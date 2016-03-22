package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.ParserXLS;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = 
//{ "classpath:applicationContext.xml" })
//@Transactional
public class LecturaFicheroTest {
	ConexionBDD c=ConexionBDD.getConexion();
	
	@Test
	public void evalLectura() {
		
		//  Este metodo accede a la BD, asi que no subir descomentado, y que sino da error
		 
		c.eliminarDB();
		ReadCensus readCensus = new RCensus("Censos.xls",new GeneradorCartasTXT(),new ParserXLS());
		readCensus.readCensus();
		List<User> usuarios = readCensus.getUsuarios();
		
		//Existen 4 entradas de usuarios en el xls pero solo 2 tiene todos
		//los campos obligatorios
		assertEquals(usuarios.size(), 10);
		
		User usuario1 = usuarios.get(0);
		User usuario2 = usuarios.get(1);
		
		assertEquals(usuario1.getName(), "Jorge");
		assertEquals(usuario2.getName(), "Miguel");
		
		assertEquals(usuario1.getNIF(), "45443827R");
		assertEquals(usuario2.getNIF(), "54313432L");
	
		assertEquals(usuario1.getEmail(), "jorge@gmail.com");
		assertEquals(usuario2.getEmail(), "miguel@gmail.com");
		
		assertEquals(usuario1.getCodigoMesa(), 1);
		assertEquals(usuario2.getCodigoMesa(), 2);


	}
	
	
	@After
	public void eliminarDB()
	{
		c.eliminarDB();
	}


}
