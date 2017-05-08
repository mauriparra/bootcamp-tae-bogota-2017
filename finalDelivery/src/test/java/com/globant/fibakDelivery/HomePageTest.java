package com.globant.fibakDelivery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.finalDelivery.FindFlightPage;
import com.globant.finalDelivery.HomePage;



public class HomePageTest {
	
	public static WebDriver driver;
	public HomePage homepage;
	public FindFlightPage findlight;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "/Users/jenniffer/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.airfrance.us/");
		homepage = PageFactory.initElements(driver, HomePage.class);
	}
	
	
  @Test
  public void testFlightRoundTrip() {
	 homepage.searchFlighRoundTrip("PAR", "VCE", "2017", "08", "08", "2017", "09", "23", new String[]{HomePage.AFE_OPTIONS[0], HomePage.AFE_OPTIONS[1]});
		 
  }
  
  @Test
  public void testFlightOneWay(){
	  homepage.searchOneWay("PAR", "VCE", "2017", "07", "20", new String[]{HomePage.AFE_OPTIONS[0]});
  }
  
  
  
  
  @AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
