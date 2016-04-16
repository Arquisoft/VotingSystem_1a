package es.uniovi.asw.steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.saucelabs.saucerest.SauceREST;

import cucumber.api.java.en.Then;
import es.uniovi.asw.utils.SeleniumUtils;
import es.uniovi.asw.utils.StepsUtil;

public class GeneralSteps {

	@Autowired
	protected WebApplicationContext context;

	protected MockMvc mvc;
	protected MvcResult result;

	URL saucelabs;

	String sauceUser;
	String saucePassword;

	DesiredCapabilities capabilities;

	@Value("${local.server.port}")
	protected int port;

	WebDriver driver;

	protected void establecerDriver() {
		// http://apiwave.com/java/snippets/removal/org.openqa.selenium.remote.DesiredCapabilities?cursor=CrEBCg4KCHByaW9yaXR5EgIIGBKaAWoTc35maW5lLWJyYW5jaC04OTIyMXKCAQsSCkphdmFDb21taXQicnJzdHVkaW8vcnN0dWRpby8zZTI5YzIzYWVkYzNmODZkZGZhZTQ1ZTViYTA0OTQzMTUxMGIzMGUwL3NyYy5nd3QudGVzdC5vcmcucnN0dWRpby5zdHVkaW8uc2VsZW5pdW0uQm9vdFJTdHVkaW8uamF2YQwYACAA

		sauceUser = System.getenv("SAUCE_USERNAME");
		saucePassword = System.getenv("SAUCE_ACCESS_KEY");

		// sauceUser="carlvilla";
		// saucePassword="0233acf3-4700-42f6-90e9-761227147d49";

		if (sauceUser != null && saucePassword != null && !sauceUser.isEmpty() && !saucePassword.isEmpty()) {
			try {
				saucelabs = new URL("http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com/wd/hub");
			} catch (MalformedURLException e) {
				System.out.println("URI Sauce mal formada");
			}

			// https://saucelabs.com/docs/platforms
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("platform", "OS X 10.11");
			capabilities.setCapability("version", "45");
			capabilities.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
			capabilities.setCapability("name", "Test Vote");
			driver = new RemoteWebDriver(saucelabs, capabilities);
		} else {
			driver = new FirefoxDriver();
		}
		
		SeleniumUtils.setDriver(driver);
		StepsUtil.setSauceUser(sauceUser);
		StepsUtil.setSaucePassword(saucePassword);
	}



	@Then("^I fill the Password field writing \"([^\"]*)\"$")
	public void i_fill_the_Password_field_writing(String arg1) throws Throwable {
		List<WebElement> pass = SeleniumUtils.EsperaCargaPaginaSteps("id","form-login:password", 10);
		pass.get(0).sendKeys(arg1);
		
	}


	@Then("^I receive the string \"([^\"]*)\"$")
	public void i_receive_the_string(String arg1) throws Throwable {
		SeleniumUtils.EsperaCargaPaginaSteps("text", arg1, 10);
	}

	@Then("^I close the browser$")
	public void i_close_the_browse() throws Throwable {
		
		if (StepsUtil.getSauceUser() != null) {
			SauceREST r = new SauceREST(StepsUtil.getSauceUser(),StepsUtil.getSaucePassword());
			String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
			r.jobPassed(sessionId);

		}
		SeleniumUtils.driver.quit();
	}
	
	@Then("^I click the login button$")
	public void i_click_the_User_login_button() throws Throwable {
		List<WebElement> login = SeleniumUtils.EsperaCargaPaginaSteps("id","form-login:login", 10);
		login.get(0).click();  
	}


}
