package es.uniovi.asw;

import org.junit.Test;

import org.junit.Assert;

public class ComandosTest {

	/**
	 * Test de escritura en pdf
	 */
	@Test
	public void testPDF() {
		String[] args = {"Censos.xls","-x","-p"};
		LoadUsers.main(args);
	}
	/**
	 * Test de escritura en txt
	 */
	@Test
	public void testTXT() {
		String[] args = {"Censos.xls","-x","-t"};
		LoadUsers.main(args);
	}
	/**
	 * Faltan un parametro
	 */
	@Test
	public void testError1() {
		String[] args = {"Censos.xls","-x"};
		try{
			LoadUsers.main(args);
			//Si entra por aqui, es que no han ocurrido errores en la ejecucion normal, por lo que el test falla
			Assert.fail();
		}catch(Exception e){
			//Faltan parametros, deberia dar error
		}
	}
	/**
	 * Parametros mal introducidos
	 */
	@Test
	public void testError2() {
		String[] args = {"Censos.xls","-q","-q"};
		try{
			LoadUsers.main(args);
			//Si entra por aqui, es que no han ocurrido errores en la ejecucion normal, por lo que el test falla
			Assert.fail();
		}catch(Exception e){
			//Faltan parametros, deberia dar error
		}
	}
	
	/**
	 * Un parametro mal introducido
	 */
	@Test
	public void testError3() {
		String[] args = {"Censos.xls","-x","-9"};
		try{
			LoadUsers.main(args);
			//Si entra por aqui, es que no han ocurrido errores en la ejecucion normal, por lo que el test falla
			Assert.fail();
		}catch(Exception e){
			//Faltan parametros, deberia dar error
		}
	}
	/**
	 * Fichero no existe
	 */
	@Test
	public void testError4() {
		String[] args = {"Csoooos.xls","-x","-9"};
		try{
			LoadUsers.main(args);
			//Si entra por aqui, es que no han ocurrido errores en la ejecucion normal, por lo que el test falla
			Assert.fail();
		}catch(Exception e){
			//Faltan parametros, deberia dar error
		}
	}
	

}
