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
public class VoteTest {

  WebDriver driver;
  URL saucelabs;
  
  String sauceUser;
  String saucePassword;
  
  DesiredCapabilities capabilities;
  
  @Before
  public void setUp() throws Exception {
			
	  //http://apiwave.com/java/snippets/removal/org.openqa.selenium.remote.DesiredCapabilities?cursor=CrEBCg4KCHByaW9yaXR5EgIIGBKaAWoTc35maW5lLWJyYW5jaC04OTIyMXKCAQsSCkphdmFDb21taXQicnJzdHVkaW8vcnN0dWRpby8zZTI5YzIzYWVkYzNmODZkZGZhZTQ1ZTViYTA0OTQzMTUxMGIzMGUwL3NyYy5nd3QudGVzdC5vcmcucnN0dWRpby5zdHVkaW8uc2VsZW5pdW0uQm9vdFJTdHVkaW8uamF2YQwYACAA

	   sauceUser = System.getenv("SAUCE_USERNAME");
	   saucePassword = System.getenv("SAUCE_ACCESS_KEY");
	  
	          if (sauceUser != null && saucePassword != null && !sauceUser.isEmpty() && !saucePassword.isEmpty()) {
	              saucelabs = new URL("http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com/wd/hub");
	  
	              // https://saucelabs.com/docs/platforms
	              capabilities = DesiredCapabilities.firefox();
	              capabilities.setCapability("platform", "OS X 10.11");
	              capabilities.setCapability("version", "45");
	              capabilities.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
	  
	              driver = new RemoteWebDriver(saucelabs, capabilities);
	          } else {
	              driver = new FirefoxDriver();
	          }

  }
  
  

  
  @Test
  public void mesaVoteTest() throws Exception {
	  driver.get("http://localhost:8080/");
	  driver.findElement(By.linkText("Acceso Mesa Electoral")).click();
	    driver.findElement(By.id("form-login:name")).clear();
	    driver.findElement(By.id("form-login:name")).sendKeys("1");
	    driver.findElement(By.id("form-login:password")).clear();
	    driver.findElement(By.id("form-login:password")).sendKeys("pas1");
	    driver.findElement(By.id("form-login:login")).click();
	    SeleniumUtils.EsperaCargaPagina(driver, "id", "dni", 10);
	    driver.findElement(By.id("form-dni:dni")).clear();
	    driver.findElement(By.id("form-dni:dni")).sendKeys("45443827R");
	    driver.findElement(By.id("form-dni:comprobar")).click();
	    SeleniumUtils.EsperaCargaPagina(driver, "text", "Se ha registrado "
	    		+ "el votante con éxito", 10);
	    
	    if (sauceUser != null){
	    	 if (sauceUser != null){
	 		    SauceREST r = new SauceREST(sauceUser, saucePassword);
	 		    r.jobPassed(System.getenv("TRAVIS_JOB_NUMBER"));
	 		    
	 	  }
	    }
	    
	    driver.quit();
  }
  
  
  @Test
  public void userVoteTest() throws Exception {
	  driver.get("http://localhost:8080/");
    driver.findElement(By.id("form-login:name")).clear();
    driver.findElement(By.id("form-login:name")).sendKeys("54313432L");
    driver.findElement(By.id("form-login:password")).clear();
    driver.findElement(By.id("form-login:password")).sendKeys("SCHNihd6pR");
    driver.findElement(By.id("form-login:login")).click();
    SeleniumUtils.EsperaCargaPagina(driver, "id", "tablaPartidos:0:botonVotar", 10);
    driver.findElement(By.id("tablaPartidos:0:botonVotar")).click();
    driver.findElement(By.id("tablaPartidos:4:j_idt14")).click();
    SeleniumUtils.EsperaCargaPagina(driver, "text", "Ya ha votado, no puede realizar mas votos", 10);
    
    if (sauceUser != null){
   	 if (sauceUser != null){
		    SauceREST r = new SauceREST(sauceUser, saucePassword);
		    r.jobPassed(System.getenv("TRAVIS_JOB_NUMBER"));
		    
	  }
   }
    
    driver.quit();
   
  }
  
  
  
  @Test
  public void userVoteYetTest() throws Exception {
	  driver.get("http://localhost:8080/");
    driver.findElement(By.id("form-login:name")).clear();
    driver.findElement(By.id("form-login:name")).sendKeys("34587263E");
    driver.findElement(By.id("form-login:password")).clear();
    driver.findElement(By.id("form-login:password")).sendKeys("jPzUf9mRlI");
    driver.findElement(By.id("form-login:login")).click();
    SeleniumUtils.EsperaCargaPagina(driver, "text", "Este usuario ya ha votado", 10);
    
    if (sauceUser != null){
   	 if (sauceUser != null){
		    SauceREST r = new SauceREST(sauceUser, saucePassword);
		    r.jobPassed(System.getenv("TRAVIS_JOB_NUMBER"));
		    
	  }
   }
    
    driver.quit();
  }
  

	

	
	
}
