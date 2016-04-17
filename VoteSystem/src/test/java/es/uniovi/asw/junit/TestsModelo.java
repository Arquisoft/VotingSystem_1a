package es.uniovi.asw.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.model.OpcionVoto;
import es.uniovi.asw.model.User;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.Voto;

public class TestsModelo {

	@Test
	public void testConfiguracion() {
		Configuracion conf = new Configuracion();
		conf.setFecha(new Date());
		conf.setHoraInicio(9);
		conf.setHoraFin(23);
		
		assertEquals(conf.getHoraInicio(),9);
		assertEquals(conf.getHoraFin(), 23);
		
		
		Configuracion conf2 = new Configuracion();
		conf2.setFecha(new Date());
		conf2.setHoraInicio(9);
		conf2.setHoraFin(23);
		
		assertEquals(conf.getHoraInicio(),9);
		assertEquals(conf.getHoraFin(), 23);
		
		assertTrue(conf.equals(conf2));
	}
	
	
	@Test
	public void testLugarVoto() {
		LugarVoto lugar = new LugarVoto(1,"colegio","Xvdimast7","Oviedo","España");
		assertEquals(lugar.getCiudad(),"Oviedo");
		assertEquals(lugar.getContraseña(),"Xvdimast7");
		assertEquals(lugar.getPais(),"España");
		assertEquals(lugar.getId(),1);
		assertEquals(lugar.getNombre(),"colegio");
		
		LugarVoto lugar2 = new LugarVoto();
		
		lugar2.setCiudad("Madrid");
		lugar2.setPais("Spain");
		lugar2.setId(2);
		lugar2.setNombre("colegio2");
		lugar2.setContraseña("jbfd98");
			
		assertFalse(lugar.equals(lugar2));
		assertTrue(lugar.equals(lugar));
			
	}

	@Test
	public void testOpcionVoto() {
		OpcionVoto opcion = new OpcionVoto();	
		opcion.setNombre("IU");
		
		assertEquals("IU", opcion.getNombre());
		
		OpcionVoto opcion2 = new OpcionVoto();
		opcion2.setNombre("PP");
		
		assertFalse(opcion.equals(opcion2));
		assertTrue(opcion.equals(opcion));
	}

	@Test
	public void testUser() {
		User user = new User();
		
		user.setCodigoMesa(1234424);
		user.setEmail("user@email.com");
		user.setName("Jose");
		user.setNIF("21433535E");
		user.setPassword("gey2g3uip23");
		
		assertEquals(1234424, user.getCodigoMesa());
		assertEquals("user@email.com", user.getEmail());
		assertEquals("Jose", user.getName());
		assertEquals("21433535E", user.getNIF());
		assertEquals("gey2g3uip23", user.getPassword());
		
		User user2 = new User("Miguel","32424738P","user2@email.com",1234424,"n3npUH989hb");

		assertTrue(user.equals(user));
		assertFalse(user.equals(user2));
		
	}

	@Test
	public void testVotante() {
		Votante votante = new Votante("21433535E");
		Votante votante2 = new Votante("63826239R");
		
		assertEquals("21433535E", votante.getId());
			
		assertTrue(votante.equals(votante));
		assertFalse(votante.equals(votante2));	
	}

	@Test
	public void testVoto() {
		Voto voto = new Voto("IU",12334,1);
	
		assertEquals("IU", voto.getOpcion());
		assertEquals(12334, voto.getLugar());
		assertEquals(1, voto.getNumero());
		
		Voto voto2 = new Voto("IU",24534,1);
		
		assertTrue(voto.equals(voto));
		assertFalse(voto.equals(voto2));	
	}

}
