package es.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.ParserXLS;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;


public class ComprobaCartas {
	
	List<User>excel=null;
	List<File>cartas=new ArrayList<File>();
	ConexionBDD c=null;
	
	@Before
	public void rellenar() throws IOException
	{
		c=ConexionBDD.getConexion();
		c.eliminarDB();
		ReadCensus r=new RCensus("src/test/resources/Censos.xls",new GeneradorCartasTXT(),new ParserXLS());
		r.readCensus();
		excel=r.getUsuarios();
		for(User u:excel)
		{
			cartas.add(new File("cartas/"+u.getEmail()+".txt"));
			
			
		
		}
	}
	

	@Test
	public void testUsuario() throws IOException {

		for(int i=0;i<cartas.size();i++)
		{
			FileReader fr=new FileReader(cartas.get(i));
			BufferedReader br=new BufferedReader(fr);
			List<String>trozos=new ArrayList<String>();
			while(br.ready())
				trozos.add(br.readLine());
			
			assertTrue(trozos.get(1).contains(excel.get(i).getEmail()));
			br.close();
				
		}
		
	}
	
	@Test
	public void testContraseña() throws IOException {
	
		for(int i=0;i<cartas.size();i++)
		{
			FileReader fr=new FileReader(cartas.get(i));
			BufferedReader br=new BufferedReader(fr);
			List<String>trozos=new ArrayList<String>();
			while(br.ready())
				trozos.add(br.readLine());
			
			assertTrue(trozos.get(2).contains(excel.get(i).getContraseña()));
			br.close();
				
		}
		
	}
	
	@After
	public void eliminarDB()
	{
		c.eliminarDB();
	}
	

}
