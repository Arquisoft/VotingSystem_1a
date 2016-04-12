package es.uniovi.asw.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SampleTest {

  public static final String USERNAME = "carlvilla";
  public static final String ACCESS_KEY = "0233acf3-4700-42f6-90e9-761227147d49";
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

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