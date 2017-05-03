package 


globant.NeiderBarbosa;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TestExitoRegistro {

	@Test
	public void Connet (){
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.exito.com/account/logging.jsp");
		WebElement register = driver.findElement(By.id("aRegistry"));
		register.click();
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Neider Duan");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Barbosa Castro");
		Select day = new Select(driver.findElement(By.id("dayOfBirth")));
		day.selectByValue("2");
		Select moth = new Select(driver.findElement(By.id("monthOfBirth")));
		moth.selectByValue("2");
		Select year = new Select(driver.findElement(By.id("yearOfBirth")));
		year.selectByValue("1991");
		WebElement Gener = driver.findElement(By.id("rbtM"));
		Gener.click();
		WebElement Email = driver.findElement(By.id("createEmailAddr"));
		Email.sendKeys("trf@gmail.com");
		WebElement Password1 = driver.findElement(By.id("createPassword"));
		Password1.sendKeys("123456789");
		WebElement Password2 = driver.findElement(By.id("createConfirmPassword"));
		Password2.sendKeys("123456789");		
		//Select  Document = new Select(driver.findElement(By.id("createConfirmPassword")));
		//Document.selectByValue("1");
		WebElement Number = driver.findElement(By.id("cedulaId"));
		Number.sendKeys("11111111");
		WebElement Acept = driver.findElement(By.id("createButton"));
		Acept.click();	
	}
	
}
