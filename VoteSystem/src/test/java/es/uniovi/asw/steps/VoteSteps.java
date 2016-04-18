package es.uniovi.asw.steps;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import es.uniovi.asw.utils.SeleniumUtils;

public class VoteSteps {
	
	GeneralSteps gs = new GeneralSteps();
	
	@Given("^I'm a user and I have logged in$")
	public void i_m_a_user_and_I_have_logged_in() throws Throwable {
		 gs.establecerDriver("Vote Test");
		 gs.driver.get("localhost:8080");
		 SeleniumUtils.esperaCargaPagina(gs.driver, "id", "form-login:name", 12);
		 gs.driver.findElement(By.id("form-login:name")).sendKeys("75443827R");
		 gs.driver.findElement(By.id("form-login:password")).sendKeys("f6FVZov56c");
		 gs.driver.findElement(By.id("form-login:login")).click();    
	}

	

	@Then("^I choose an option$")
	public void i_choose_an_option() throws Throwable {
		SeleniumUtils.esperaCargaPagina(gs.driver, "id", "tablaPartidos:0:botonVotar", 12);
		gs.driver.findElement(By.id("tablaPartidos:0:botonVotar")).click();

	}

	@Then("^I confirm my choice$")
	public void i_confirm_my_choice() throws Throwable {
		gs.driver.findElement(By.id("tablaPartidos:4:j_idt14")).click();
		SeleniumUtils.esperaCargaPagina(gs.driver, "text", "Ya ha votado, no puede realizar mas votos", 12);
	}
	
}
