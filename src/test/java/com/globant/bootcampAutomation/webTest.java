package com.jemnniffer.Bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webTest {
private  WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://www.tiquetesbaratos.com/");
	}
	
	@Test
	public void testDropDown() {
		Select dropDown = new Select(driver.findElement(By.id("adultos")));
		dropDown.selectByVisibleText("1");
		dropDown.deselectByValue("6");;
		dropDown.selectByIndex(1);
  }
	
	
	
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
