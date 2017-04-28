package globant.NeiderBarbosa;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestSimit {
	
		String Url = "http://www2.simit.org.co/Simit/";
		WebDriver driver = new ChromeDriver();
	
		@BeforeTest
		public void Connet() {
			driver.get(Url);
		}
		
		@Test (priority = 1)
		public void TestConnet() {
			Assert.assertEquals(driver.getTitle(), "Simit");
		}
		
		@Test(priority = 2) 
		public void testDocument(){
			  Select TypeDoc = new Select(driver.findElement(By.name("tipoDocumento")));
			  TypeDoc.selectByVisibleText("cedula");
			  WebElement Number = driver.findElement(By.name("identificacion"));
			  Number.sendKeys("1020292928");
			  Number.submit();
			  driver.quit();
			  Select Type = new Select((WebElement) driver.findElements(By.name("raddiobuuton")));
			  Type.selectByValue("5");
			  WebElement Capchat = driver.findElement(By.name("txtInput"));
			  Capchat.sendKeys("basura");
			  Capchat.submit();
		}
		
		@Test(priority = 3)
		public void TestQueryPdf() {
		  WebElement pdf = driver.findElement(By.name("pdf2"));
		  pdf.click();
		  Assert.assertEquals(driver.getTitle(), "Simit");
		  
		}
		
		@Test(priority = 4)
		public void TestQuery() {
		  WebElement query = driver.findElement(By.name("consultar"));
		  query.click();
		  Assert.assertEquals(driver.getTitle(), "Simit");
		}
		
		@Test(priority = 5)
		public void TestLinkFederacion() {
		  WebElement link = driver.findElement(By.linkText("http://www.fcm.org.co/"));
		  link.click();
		  Assert.assertEquals(driver.getTitle(), "Portal de la Federacion Colombiana de Municipios");
		}
		
		@Test(priority = 6)
		public void TestCerrar() {
			 driver.quit();
			}
	}


