package com.jenniffer.TestBootcamp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class TesWeb {
private  WebDriver driver;

	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/jenniffer/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.tiquetesbaratos.com/");
	}
	
	@Test
	public void testDropDown() {
		Select dropDown = new Select(driver.findElement(By.id("adultos")));
		dropDown.selectByVisibleText("1");
  }
	
	@Test
	public void testInput(){
		WebElement inputText = driver.findElement(By.name("origen"));
		inputText.sendKeys("Bogota");
		System.out.print(inputText.getText());
	}
	
	@Test
	public void testCheckBox(){
		WebElement checkBox = driver.findElement(By.name("transporte"));
		if(checkBox.isSelected()){
			checkBox.click();
		}
	}
	
	@Test
	public void testButton(){
		WebElement parentElement= driver.findElement(By.className("btn_reservar_vuelos"));
		WebElement chiLdElement = parentElement.findElement(By.id("btn_buscarmotor"));
		chiLdElement.submit();
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	
}
