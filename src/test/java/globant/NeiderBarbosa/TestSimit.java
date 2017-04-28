package globant.NeiderBarbosa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TestSimit {
	
	@Test(priority = 1)
	public void testconsultar() {
	  //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www2.simit.org.co/Simit/");
	  WebElement pdf = driver.findElement(By.id("slideMenu_0"));
	  pdf.click();
	}
	
	@Test(priority = 2)
	public void testPdf() {
	  //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www2.simit.org.co/Simit/");
	  WebElement pdf = driver.findElement(By.name("consultar"));
	  pdf.click();
	}
	
	@Test(priority = 3) 
	public void testDocument(){
		//System.setProperty("webdriver.chrome.driver", "‪C:\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www2.simit.org.co/Simit/");
		  Select TypeDoc = new Select(driver.findElement(By.name("tipoDocumento")));
		  TypeDoc.selectByVisibleText("cedula");
		  WebElement Number = driver.findElement(By.name("identificacion"));
		  Number.sendKeys("1030586558");
		  Select Type = new Select((WebElement) driver.findElements(By.name("raddiobuuton")));
		  Type.selectByValue("5");
		  WebElement Capchat = driver.findElement(By.name("txtInput"));
		  Capchat.sendKeys("basura");
		  WebElement Query = driver.findElement(By.name("consultar"));
		  Query.click();
		  
	}

}
