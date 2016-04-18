package es.uniovi.asw.utils;

import java.util.List;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static WebDriver driver;

	public static void setDriver(WebDriver driverAux) {
		driver = driverAux;
	}

	/**
	 * Mueve el ratón a la opción de menú submenu(desplegable). Evento hover y
	 * clicka la opcion opcionclick
	 * 
	 * @param driver
	 * @param submenu
	 * @param opcionclick
	 */
	static public void ClickSubopcionMenuHover(WebDriver driver, String submenu, String opcionclick) {
		// Pasamos el raton por el submenu de Gestion de alumnos para
		// que aparezca el menu desplegable
		Actions builder = new Actions(driver);
		WebElement hoverElement = driver.findElement(By.id(submenu));
		builder.moveToElement(hoverElement).perform();
		// Pinchamos la opcion opcionclick
		By locator = By.id(opcionclick);
		driver.findElement(locator).click();
	}

	static public void textoPresentePagina(WebDriver driver, String texto) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
		assertTrue("Texto " + texto + " no localizado!", list.size() > 0);
	}

	static public void textoNoPresentePagina(WebDriver driver, String texto) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
		assertTrue("Texto " + texto + " aun presente !", list.size() == 0);
	}

	static public void esperaCargaPaginaNoTexto(WebDriver driver, String texto, int timeout) {
		Boolean resultado = (new WebDriverWait(driver, timeout)).until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'" + texto + "')]")));

		assertTrue(resultado);
	}

	static public List<WebElement> esperaCargaPaginaxpath(WebDriver driver, String xpath, int timeout) {
		WebElement resultado = (new WebDriverWait(driver, timeout))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		assertTrue(resultado != null);
		List<WebElement> elementos = driver.findElements(By.xpath(xpath));

		return elementos;
	}

	/**
	 * Permite buscar por Id o Class con espera criterio. "id" or "class" or
	 * "text" Aviso. Que se usa espera por la visibilidad del elemento De esta
	 * forma sirve tanto para carga de páginas enteras como para elementos que
	 * estan ocultos y se hace visibles
	 * 
	 * 
	 * @param driver
	 * @param criterio
	 * @param id
	 * @param timeout
	 * @return
	 */
	static public List<WebElement> esperaCargaPagina(WebDriver driver, String criterio, String id, int timeout) {
		String busqueda;
		if (criterio.equals("id"))
			busqueda = "//*[contains(@id,'" + id + "')]";
		else if (criterio.equals("class"))
			busqueda = "//*[contains(@class,'" + id + "')]";
		else
			busqueda = "//*[contains(text(),'" + id + "')]";
		return esperaCargaPaginaxpath(driver, busqueda, timeout);
	}

	public static List<WebElement> esperaCargaPaginaSteps(String criterio, String id, int timeout) {
		String busqueda;
		if (criterio.equals("id"))
			busqueda = "//*[contains(@id,'" + id + "')]";
		else if (criterio.equals("class"))
			busqueda = "//*[contains(@class,'" + id + "')]";
		else
			busqueda = "//*[contains(text(),'" + id + "')]";
		return esperaCargaPaginaxpath(driver, busqueda, timeout);
	}
}
