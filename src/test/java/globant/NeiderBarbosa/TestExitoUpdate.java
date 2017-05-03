package 


globant.NeiderBarbosa;

import org.testng.annotations.Test;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestExitoUpdate{
	
	
	WebDriver driver;
	@Test
	public void Connet (){
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.exito.com/account/logging.jsp"); 
		WebElement User = driver.findElement(By.id("loginNonPop"));
		User.sendKeys("nerderduancho@hotmail.com");
		WebElement PassWord = driver.findElement(By.id("passwordNonPop"));
		PassWord.sendKeys("rediennaud");
		WebElement BotonLogin = driver.findElement(By.id("signInButtonNonPop"));	
		BotonLogin.click();
		driver.switchTo().alert().dismiss();
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Luis Carlos");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Perez Chacon");
	}
	
}
