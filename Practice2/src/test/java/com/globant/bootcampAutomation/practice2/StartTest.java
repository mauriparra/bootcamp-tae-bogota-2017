package com.globant.bootcampAutomation.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class StartTest {
	
    protected WebDriver driver;
	private static String driverPath = "src/test/res/";

    @BeforeMethod
    public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
	  
  	  driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
