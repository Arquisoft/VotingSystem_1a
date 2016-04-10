package es.uniovi.asw.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import es.uniovi.asw.selenium.utils.SeleniumUtils;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void loginTest() throws Exception {
    driver.get(baseUrl + "/login.xhtml");
    driver.findElement(By.id("form-login:name")).clear();
    driver.findElement(By.id("form-login:name")).sendKeys("user@gmail.com");
    driver.findElement(By.id("form-login:password")).clear();
    driver.findElement(By.id("form-login:password")).sendKeys("123");
    driver.findElement(By.id("form-login:login")).click();
    SeleniumUtils.textoPresentePagina(driver, "Página principal");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
