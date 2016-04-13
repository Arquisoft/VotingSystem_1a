package es.uniovi.asw.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.Application;
import es.uniovi.asw.selenium.utils.SeleniumUtils;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class LoginSteps {
/*	
	  @Autowired
	  protected WebApplicationContext context;

	  protected MockMvc mvc;
	  protected MvcResult result;
	  
	  @Value("${local.server.port}")
	  protected int port;
	  
	  
	  WebDriver driver;

	

	  @Given("^I'm a user and on the /login\\.xhtml page$")
	  public void i_m_a_user_and_on_the_login_xhtml_page() throws Throwable {
		  Assert.notNull(context);
		    this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
		    result = mvc.perform(get("/")).andReturn();
	  }

	@Then("^I fill the DNI field$")
	public void i_fill_the_DNI_field() throws Throwable {
		 driver = new FirefoxDriver();
		 driver.findElement(By.id("form-login:name")).sendKeys("45443827R");
	}

	@Then("^I fill the Password field$")
	public void i_fill_the_Password_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("form-login:password")).sendKeys("fcW3i1ciT8");
	}

	@Then("^I click the login button$")
	public void i_click_the_login_button() throws Throwable {
		driver.findElement(By.id("form-login:login")).click();       
	}

	@Then("^I receive status code of (\\d+)$")
	public void i_receive_status_code_of(int arg1) throws Throwable {
		assertThat(result.getResponse().getStatus(), is(arg1));
	}

	@Then("^I receive the string \"([^\"]*)\"$")
	public void i_receive_the_string(String arg1) throws Throwable {
		 assertThat(result.getResponse().getContentAsString(), containsString(arg1));
	}
	
	*/
}
