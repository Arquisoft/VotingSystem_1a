package es.uniovi.asw.selenium;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLogin() throws Exception {
	    driver.get(baseUrl + "/");
	    
	  }

	 

}
