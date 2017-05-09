package com.globant.bootcampAutomation.lufthansa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class StartTest {
	
    protected WebDriver driver;
	private static final String DRIVER_PATH = "src/test/res/";
	private static final String URL = "https://www.lufthansa.com/us/en/Homepage";
	//private static final String URL = "https://yahoo.es";

    @BeforeMethod
    public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");	  
  	  driver = new ChromeDriver();
  	  driver.get(URL);
  	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
