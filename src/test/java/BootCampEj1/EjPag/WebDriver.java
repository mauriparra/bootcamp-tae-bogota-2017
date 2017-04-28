package BootCampEj1.EjPag;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriver {

	@Test
	public void test1(){
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Santi\\Instaladores\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://www.avianca.com/es-co/");
		driver.findElement(By.id("ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_rbIda")).click();
		driver.findElement(By.id("ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_ddlCiudadOrigenBooking")).sendKeys("Bogotá");
		
		if(driver.findElement(By.className("select-ciudades select-origen ui-autocomplete-input hover")).isDisplayed()){
			driver.findElement(By.id("ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_ddlCiudadOrigenBooking")).sendKeys(Keys.ARROW_DOWN);
		}
		//driver.findElement(By.id("ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_ddlCiudadDestinoBooking")).sendKeys("Miami");
		//driver.findElement(By.id("btn_calendar_1")).click();	
	}
	
	

}
