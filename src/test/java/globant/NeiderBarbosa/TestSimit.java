package globant.NeiderBarbosa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TestSimit {
	
	@Test
	public void testSimit() {
	  System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www2.simit.org.co/Simit/");
	  driver.quit();
	}
	
	@Test 
	public void testDocument(){
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www2.simit.org.co/Simit/");
		  Select comboBox = new Select(driver.findElement(By.name("tipoDocumento")));
		  comboBox.selectByVisibleText("cedula");
		  driver.quit();
	}

}
