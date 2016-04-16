package es.uniovi.asw.steps;

import org.openqa.selenium.By;
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
public class MesaLoginSteps{

	GeneralSteps gs = new GeneralSteps();
	
	
	@Given("^I'm a member of the polling station and on the /loginMesa\\.xhtml page$")
	public void i_m_a_member_of_the_polling_station_and_on_the_loginMesa_xhtml_page() throws Throwable {
		gs.establecerDriver();
		gs.driver.get("localhost:8080");
		gs.driver.findElement(By.linkText("Acceso Mesa Electoral")).click();
	}
	
	@Then("^I fill the ID field writing \"([^\"]*)\"$")
	public void i_fill_the_ID_field_writing(String arg1) throws Throwable {
		SeleniumUtils.EsperaCargaPagina(gs.driver, "id", "form-login:name", 10);
		gs.driver.findElement(By.id("form-login:name")).sendKeys(String.valueOf(arg1));
	}

	

}
