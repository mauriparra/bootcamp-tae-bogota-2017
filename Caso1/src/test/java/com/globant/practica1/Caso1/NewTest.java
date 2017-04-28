package com.globant.practica1.Caso1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class NewTest {
	 WebDriver driver;
	 public static String driverPath = "C:/Users/Margarita/Documents/drivers/";
	 
	 
	 
  @Test
  public void registerFormTest() { 	  

	  WebElement name = driver.findElement(By.id("edit-field-user-name-und-0-value"));
	  WebElement lastName = driver.findElement(By.id("edit-field-apellido-und-0-value"));
	  WebElement mail = driver.findElement(By.id("edit-mail"));
	  WebElement date = driver.findElement(By.id("edit-pass-datepicker-popup-0"));
	  WebElement terms = driver.findElement(By.cssSelector("#edit-profile-main-field-terms-and-conditions-und"));
	  WebElement btn = driver.findElement(By.id("edit-submit"));
	  Select gender = new Select(driver.findElement(By.id("edit-profile-main-field-user-gender-und")));
	  Select city = new Select(driver.findElement(By.id("edit-profile-main-field-user-city-und")));
	  	  
	  name.sendKeys("Juan");
	  lastName.sendKeys("Perez");
	  mail.sendKeys("correo@gmail.com");
	  date.sendKeys("22/02/1954");
	  
	  gender.selectByIndex(2);
	  city.selectByIndex(3);
	  terms.click();
	  btn.click();
	  
	  System.out.println("El formuario fue llenado satisfactoriamente");
  }
  
  @Test
  public void registerFormTestNoName() { 	  

	  WebElement lastName = driver.findElement(By.id("edit-field-apellido-und-0-value"));
	  WebElement mail = driver.findElement(By.id("edit-mail"));
	  WebElement date = driver.findElement(By.id("edit-pass-datepicker-popup-0"));
	  WebElement terms = driver.findElement(By.cssSelector("#edit-profile-main-field-terms-and-conditions-und"));
	  
	  Select gender = new Select(driver.findElement(By.id("edit-profile-main-field-user-gender-und")));
	  Select city = new Select(driver.findElement(By.id("edit-profile-main-field-user-city-und")));
	  	  
	  WebElement btn = driver.findElement(By.id("edit-submit"));
	  lastName.sendKeys("Perez");
	  mail.sendKeys("correo@gmail.com");
	  date.sendKeys("22/02/1954");
	  
	  gender.selectByIndex(2);
	  city.selectByIndex(3);
	  
	  btn.submit();
	  
	  System.out.println("No name in form");
  }
  
  @Test
  public void registerFormTestNoTerms() { 	  

	  WebElement name = driver.findElement(By.id("edit-field-user-name-und-0-value"));
	  WebElement lastName = driver.findElement(By.id("edit-field-apellido-und-0-value"));
	  WebElement mail = driver.findElement(By.id("edit-mail"));
	  WebElement date = driver.findElement(By.id("edit-pass-datepicker-popup-0"));
	  WebElement terms = driver.findElement(By.cssSelector("#edit-profile-main-field-terms-and-conditions-und"));
	  WebElement btn = driver.findElement(By.id("edit-submit"));
	  Select gender = new Select(driver.findElement(By.id("edit-profile-main-field-user-gender-und")));
	  Select city = new Select(driver.findElement(By.id("edit-profile-main-field-user-city-und")));
	  	  
	  name.sendKeys("Juan");
	  lastName.sendKeys("Perez");
	  mail.sendKeys("correo@gmail.com");
	  date.sendKeys("22/02/1954");
	  
	  gender.selectByIndex(2);
	  city.selectByIndex(3);
	  btn.click();
	  
	  System.out.println("Terms no checked");
  }
  
  @BeforeMethod(alwaysRun = true) 
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("http://www.cremadelechealqueria.com/user/register");
  }

  @AfterMethod
  public void afterMethod() {

	  driver.close();
  }

}
