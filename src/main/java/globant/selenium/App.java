package globant.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import globant.selenium.setup;

/**
 * Hello world!
 *
 */
public class App 
{ 	
    	 
    	 @Test
    	 public void test1(){
    		 setup Obj = new setup();	
 	    	 WebDriver driver  = Obj.iniciar();
    		 driver.get("file:///C:/Users/Sergio%20Gonzalez%20Rios/Pictures/Formulario%20de%20Prueba%20de%20Campos%20Personalizados%20_%20Espa%C3%B1ol.html");
    		 	Select dropdown = new Select(driver.findElement(By.name("ttl_select")));
    		 	dropdown.selectByVisibleText("Dr");
    		 	driver.findElement(By.name("field1")).sendKeys("Antonio");  		 	
    		 	WebElement check = driver.findElement(By.name("field6"));
    		 	check.click();
    		 	WebElement Botton1 = driver.findElement(By.name("soltero"));
    		 	Botton1.click();
    		 	Select dropdown1 = new Select(driver.findElement(By.name("Ingresos")));
    			dropdown1.selectByValue("0030000");
    			WebElement Botton2 = driver.findElement(By.name("OpenField4_02"));
    		 	Botton2.click();
    			driver.findElement(By.name("enviar")).click();
    			//Thread.sleep(10000);
    			driver.quit();
    	 }
    	 @Test
    	 public void test2(){
    		 setup Obj = new setup();	
 	    	 WebDriver driver  = Obj.iniciar();
    		 driver.get("file:///C:/Users/Sergio%20Gonzalez%20Rios/Pictures/Formulario%20de%20Prueba%20de%20Campos%20Personalizados%20_%20Espa%C3%B1ol.html");
    		 
    		 	Select dropdown1 = new Select(driver.findElement(By.name("Ingresos")));
    			dropdown1.selectByValue("1");
    			WebElement Botton2 = driver.findElement(By.name("OpenField4_02"));
    		 	Botton2.click();
    			driver.findElement(By.name("enviar")).click();
    			driver.quit();
    	 }
    		 

    	

    	
		
	
	
}
