package es.uniovi.asw;

import org.junit.Assert;
import org.junit.Test;

import es.uniovi.asw.ConfParser.LoadConfiguration;
import es.uniovi.asw.util.AdminException;

public class AdminSystemTest {
	// Test de configuracion
	// Test de configuracion
	// Test de configuracion
	// Test de configuracion

	/**
	 * Test de configuracion correcto
	 * 
	 */
	@Test
	public void testConfiguracion() {
		String[] args = { "conf", "conf.xls", "-x", "options.xls", "-x", "places.xls", "-x" };
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			// No deberia entrar por aqui
			Assert.fail();
		}
	}

	/**
	 * Test de fichero conf inexistente
	 */
	@Test
	public void testFicheroNoExisteConf1() {
		String[] args = { "conf", "confNoexiste.xls", "-x", "options.xls", "-x", "places.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Si entra por aqui, es que no ha dado excepcion, por lo que falla
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero options inexistente
	 */
	@Test
	public void testFicheroNoExisteConf2() {
		String[] args = { "conf", "conf.xls", "-x", "optionsNoExiste.xls", "-x", "places.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Si entra por aqui, es que no ha dado excepcion, por lo que falla
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero places inexistente
	 */
	@Test
	public void testFicheroNoExisteConf3() {
		String[] args = { "conf", "conf.xls", "-x", "options.xls", "-x", "placesNoExiste.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Si entra por aqui, es que no ha dado excepcion, por lo que falla
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero conf con extension erronea
	 */
	@Test
	public void testExtensionErroneaConf1() {
		String[] args = { "conf", "conf.txt", "-x", "options.xls", "-x", "placesNoExiste.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero options con extension erronea
	 */
	@Test
	public void testExtensionErroneaConf2() {
		String[] args = { "conf", "conf.xls", "-x", "options.txt", "-x", "placesNoExiste.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero places con extension erronea
	 */
	@Test
	public void testExtensionErroneaConf3() {
		String[] args = { "conf", "conf.xls", "-x", "options.xls", "-x", "placesNoExiste.txt", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero con errores
	 */
	@Test
	public void testFicheroConErroresConf1() {
		String[] args = { "conf", "confErrores.xls", "-x", "options.xls", "-x", "places.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test de fichero con errores
	 */
	@Test
	public void testFicheroConErroresConf2() {
		String[] args = { "conf", "conf.xls", "-x", "options.xls", "-x", "placesErrores.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}

	}

	// Test de recuento
	// Test de recuento
	// Test de recuento
	// Test de recuento

	/**
	 * Test de recuento correcto
	 */
	@Test
	public void testRecuento() {
		String[] args = { "count", "votes.xls", "-x" };
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			// No deberia entrar por aqui
			Assert.fail();
		}
	}

	/**
	 * Test de fichero inexistente
	 */
	@Test
	public void testFicheroNoExiste() {
		String[] args = { "count", "votesInexistentes.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Si entra por aqui, es que no ha dado excepcion, por lo que falla
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero con extension erronea
	 */
	@Test
	public void testExtensionErronea() {
		String[] args = { "count", "votes.txt", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero con errores
	 */
	@Test
	public void testFicheroConErrores() {
		String[] args = { "count", "votesConErrores.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// Deberia dar error
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Test de recuento con lugares que no existen
	 */
	@Test
	public void testLugaresNoExiste() {
		String[] args = { "count", "votesLugaresNoexisten.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// El lugar 693 no existe, por lo que deberia fallar y no entrar por aqui
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
			
		}
	}

	// Test generales
	// Test generales
	// Test generales
	// Test generales

	/**
	 * Test con una opcion que no existe
	 */
	@Test
	public void testOpcionNoExistente() {
		String[] args = { "noexisto", "votes.xls", "-x" };
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			// No deberia salir excepcion
			e.printStackTrace();
			Assert.fail();
		}
	}

	/**
	 * Test de opcion que no existe
	 */
	@Test
	public void testOpcionNoExiste() {
		String[] args = { "count", "votes.xls", "-t" };
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			e.printStackTrace();
			// Esa extension no es adoptada aun por el sistema, por lo que no es
			// valida
			Assert.fail();
		}
	}
	
	
	
	/**
	 * Test sin argumentos
	 */
	@Test
	public void testSinArgumentos(){
		String[] args = {};
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			e.printStackTrace();
			// No deberia dar error
			Assert.fail();
		}
	}
	
	/**
	 * Test de ayuda
	 */
	@Test
	public void testAyuda(){
		String[] args = {"-h"};
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			e.printStackTrace();
			// No deberia dar error
			Assert.fail();
		}
	}
}
