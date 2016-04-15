package es.uniovi.asw.selenium;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.saucelabs.saucerest.SauceREST;

import es.uniovi.asw.Application;
import es.uniovi.asw.selenium.utils.SeleniumUtils;

@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginTest {

	WebDriver driver;
	URL saucelabs;

	String sauceUser;
	String saucePassword;

	DesiredCapabilities capabilities;

	@Before
	public void setUp() throws Exception {

		// http://apiwave.com/java/snippets/removal/org.openqa.selenium.remote.DesiredCapabilities?cursor=CrEBCg4KCHByaW9yaXR5EgIIGBKaAWoTc35maW5lLWJyYW5jaC04OTIyMXKCAQsSCkphdmFDb21taXQicnJzdHVkaW8vcnN0dWRpby8zZTI5YzIzYWVkYzNmODZkZGZhZTQ1ZTViYTA0OTQzMTUxMGIzMGUwL3NyYy5nd3QudGVzdC5vcmcucnN0dWRpby5zdHVkaW8uc2VsZW5pdW0uQm9vdFJTdHVkaW8uamF2YQwYACAA

		sauceUser = System.getenv("SAUCE_USERNAME");
		saucePassword = System.getenv("SAUCE_ACCESS_KEY");

		if (sauceUser != null && saucePassword != null && !sauceUser.isEmpty() && !saucePassword.isEmpty()) {
			saucelabs = new URL("http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com/wd/hub");

			// https://saucelabs.com/docs/platforms
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("platform", "OS X 10.11");
			capabilities.setCapability("version", "45");
			capabilities.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
			capabilities.setCapability("build", "Test Login");

			driver = new RemoteWebDriver(saucelabs, capabilities);
		} else {
			driver = new FirefoxDriver();
		}

	}

	@Test
	public void userLoginTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("form-login:name")).clear();
		driver.findElement(By.id("form-login:name")).sendKeys("45443827R");
		driver.findElement(By.id("form-login:password")).clear();
		driver.findElement(By.id("form-login:password")).sendKeys("fcW3i1ciT8");
		driver.findElement(By.id("form-login:login")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Cerrar Sesion", 10);

		if (sauceUser != null) {
			SauceREST r = new SauceREST(sauceUser, saucePassword);
			String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
			r.jobPassed(sessionId);

		}

		driver.quit();
	}

	@Test
	public void failedUserLoginTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("form-login:name")).clear();
		driver.findElement(By.id("form-login:name")).sendKeys("45443827R");
		driver.findElement(By.id("form-login:password")).clear();
		driver.findElement(By.id("form-login:password")).sendKeys("erronea");
		driver.findElement(By.id("form-login:login")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Contraseña o usuario incorrecto", 10);

		if (sauceUser != null) {
			SauceREST r = new SauceREST(sauceUser, saucePassword);
			String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
			r.jobPassed(sessionId);

		}

		driver.quit();
	}

}
