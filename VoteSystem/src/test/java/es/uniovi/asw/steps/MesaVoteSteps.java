package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import es.uniovi.asw.Application;
import es.uniovi.asw.utils.SeleniumUtils;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class MesaVoteSteps {

	GeneralSteps gs = new GeneralSteps();
	
	@Given("^I'm a member of the polling station and I have logged in$")
	public void i_m_a_member_of_the_polling_station_and_I_have_logged_in() throws Throwable {
		gs.establecerDriver();	
		gs.driver.get("localhost:8080");
		gs.driver.findElement(By.linkText("Acceso Mesa Electoral")).click();
		SeleniumUtils.EsperaCargaPaginaSteps("id", "form-login:name", 10);
		SeleniumUtils.driver.findElement(By.id("form-login:name")).sendKeys("1");
		SeleniumUtils.driver.findElement(By.id("form-login:password")).sendKeys("pas1");
		SeleniumUtils.driver.findElement(By.id("form-login:login")).click();
	}
	
	@Then("^I fill the DNI field writing \"([^\"]*)\"$")
	public void i_fill_the_User_DNI_field_writing(String arg1) throws Throwable {
		List<WebElement> dni = SeleniumUtils.EsperaCargaPaginaSteps("id", "form-dni:dni", 3);
		dni.get(0).sendKeys(arg1);	
	}
	
	@Then("^I click the comprueba button$")
	public void i_click_the_comprueba_button() throws Throwable {
		gs.driver.findElement(By.id("form-dni:comprobar")).click();
	}
	





}
