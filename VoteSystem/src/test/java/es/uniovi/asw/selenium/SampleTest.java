package es.uniovi.asw.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SampleTest {


  public static void main(String[] args) throws Exception {

	  String sauceUser = System.getenv("SAUCE_USERNAME");
	  String saucePassword = System.getenv("SAUCE_ACCESS_KEY");
	  String URL = "http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com:80/wd/hub";
	  
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 10");
    caps.setCapability("version", "43.0");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

    /**
     * Goes to Sauce Lab's guinea-pig page and prints title
     */

    driver.get("https://saucelabs.com/test/guinea-pig");
    System.out.println("title of page is: " + driver.getTitle());

    driver.quit();
  }
}