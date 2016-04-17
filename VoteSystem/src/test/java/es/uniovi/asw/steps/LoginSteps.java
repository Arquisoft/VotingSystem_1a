package es.uniovi.asw.steps;

import java.util.List;

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
public class LoginSteps {

	GeneralSteps gs = new GeneralSteps();

	@Given("^I'm a user and on the /login\\.xhtml page$")
	public void i_m_a_user_and_on_the_login_xhtml_page() throws Throwable {
		gs.establecerDriver("Login Test");
		SeleniumUtils.driver.get("localhost:8080");
	}

	@Then("^I fill the User DNI field writing \"([^\"]*)\"$")
	public void i_fill_the_User_DNI_field_writing(String arg1) throws Throwable {
		List<WebElement> dni = SeleniumUtils.EsperaCargaPaginaSteps("id", "form-login:name", 10);
		dni.get(0).sendKeys("45443827R");
	}

}
