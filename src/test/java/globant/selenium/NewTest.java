package globant.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class NewTest {
	public static WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void test1() {
	  driver.get("https://goo.gl/forms/X5JYTIizWgt5Pg2v1");
	  WebElement calendar= driver.findElement(By.xpath("//INPUT[@type='date']/self::INPUT"));
	  calendar.click();
	  calendar.sendKeys("20031990");
	  WebElement select = driver.findElement(By.xpath("//DIV[@class='quantumWizMenuPaperselectOption freebirdThemedSelectOptionDarkerDisabled exportOption isSelected isPlaceholder']"));
	  select.click();
	  WebElement select2 =driver.findElement(By.xpath("(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Casad@'][text()='Casad@'])[2]"));
	  select2.click();
	  select2.click();
	  WebElement radiobutton = driver.findElement(By.xpath("(//DIV[@class='exportLabelWrapper'])[2]"));
	  radiobutton.click();
	  WebElement textbox = driver.findElement(By.xpath("//INPUT[@type='text']"));
	  textbox.click();
	  textbox.sendKeys("Prueba de texto");
	  WebElement send = driver.findElement(By.xpath("//SPAN[@class='quantumWizButtonPaperbuttonLabel exportLabel'][text()='Enviar']"));
	  send.click();
	  String exit = driver.getCurrentUrl();
	  System.out.println(exit);
	  Assert.assertEquals("https://docs.google.com/forms/d/e/1FAIpQLSdccTDCqi87lZM7vQ3uLm46h7mkv_4stZioAjxD5Sud5LuVnA/formResponse", exit);
		
  }
  @Test
  public void test2() {
	  driver.get("https://goo.gl/forms/X5JYTIizWgt5Pg2v1");
	  WebElement calendar= driver.findElement(By.xpath("//INPUT[@type='date']/self::INPUT"));
	  calendar.click();
	  calendar.sendKeys("18051990");
	  WebElement select = driver.findElement(By.xpath("//DIV[@class='quantumWizMenuPaperselectOption freebirdThemedSelectOptionDarkerDisabled exportOption isSelected isPlaceholder']"));
	  select.click();
//	  WebElement select2 =driver.findElement(By.xpath("(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Casad@'][text()='Casad@'])[2]"));
//	  select2.click();
//	  select2.click();
	  WebElement radiobutton = driver.findElement(By.xpath("(//DIV[@class='exportLabelWrapper'])[2]"));
	  radiobutton.click();
	  WebElement textbox = driver.findElement(By.xpath("//INPUT[@type='text']"));
	  textbox.click();
	  textbox.sendKeys("Prueba de texto");
	  WebElement send = driver.findElement(By.xpath("//SPAN[@class='quantumWizButtonPaperbuttonLabel exportLabel'][text()='Enviar']"));
	  send.click();
	  String exit = driver.getCurrentUrl();
	  Assert.assertEquals("https://docs.google.com/forms/d/e/1FAIpQLSdccTDCqi87lZM7vQ3uLm46h7mkv_4stZioAjxD5Sud5LuVnA/formResponse", exit);
		
  }


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
