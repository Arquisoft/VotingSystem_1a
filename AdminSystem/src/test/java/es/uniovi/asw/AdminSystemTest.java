package es.uniovi.asw;

import org.junit.Assert;
import org.junit.Test;

import es.uniovi.asw.confParser.LoadConfiguration;
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
		String[] args = { "conf", "src/test/resources/conf.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/places.xls", "-x" };
		try {
			LoadConfiguration.main(args);
		} catch (AdminException e) {
			// No deberia entrar por aqui
			Assert.fail();
		}
	}
	
	/**
	 * Test de configuracion con fichero vacio
	 * 
	 */
	@Test
	public void testConfiguracionVacio() {
		String[] args = { "conf", "src/test/resources/confVacio.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/places.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			//Da excepcion de fichero vacio, no deberia entrar aqui
			Assert.fail();
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test de fichero conf inexistente
	 */
	@Test
	public void testFicheroNoExisteConf1() {
		String[] args = { "conf", "src/test/resources/confNoexiste.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/places.xls", "-x" };
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
		String[] args = { "conf", "src/test/resources/conf.xls", "-x", "src/test/resources/optionsNoExiste.xls", "-x", "src/test/resources/places.xls", "-x" };
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
		String[] args = { "conf", "src/test/resources/conf.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/placesNoExiste.xls", "-x" };
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
		String[] args = { "conf", "src/test/resources/conf.txt", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/placesNoExiste.xls", "-x" };
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
		String[] args = { "conf", "src/test/resources/conf.xls", "-x", "src/test/resources/options.txt", "-x", "src/test/resources/placesNoExiste.xls", "-x" };
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
		String[] args = { "conf", "src/test/resources/conf.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/placesNoExiste.txt", "-x" };
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
		String[] args = { "conf", "src/test/resources/confErrores.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/places.xls", "-x" };
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
		String[] args = { "conf", "src/test/resources/conf.xls", "-x", "src/test/resources/options.xls", "-x", "src/test/resources/placesErrores.xls", "-x" };
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
		String[] args = { "count", "src/test/resources/votes.xls", "-x" };
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
		String[] args = { "count", "src/test/resources/votesInexistentes.xls", "-x" };
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
		String[] args = { "count", "src/test/resources/votes.txt", "-x" };
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
		String[] args = { "count", "src/test/resources/votesConErrores.xls", "-x" };
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
		String[] args = { "count", "src/test/resources/votesLugaresNoexisten.xls", "-x" };
		try {
			LoadConfiguration.main(args);
			// El lugar 693 no existe, pero se recoge la excepcion y no entra por aqui
		} catch (AdminException e) {
			e.printStackTrace();
			Assert.fail();
			
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
		String[] args = { "noexisto", "src/test/resources/votes.xls", "-x" };
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
		String[] args = { "count", "src/test/resources/votes.xls", "-t" };
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
