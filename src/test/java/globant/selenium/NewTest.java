package globant.selenium;

import org.testng.annotations.Test;

import globant.Pages.PagePoll;
import globant.Pages.PageResult;
import globant.Pages.Setup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;


public class NewTest {
	public static WebDriver driver;
	
 
  @BeforeMethod
  public void beforeMethod() {
	   driver = Setup.startBrowser("chrome", "https://goo.gl/forms/X5JYTIizWgt5Pg2v1");
	    }
  @Parameters({"date","text","civil_status","work"})
  @Test
  public void test1(String date, String text,String civil_status, String work) {
	  PagePoll testPagePoll=PageFactory.initElements(driver, PagePoll.class);
	  testPagePoll.writeCalendar(date);
	  testPagePoll.writeDropdown(civil_status);
	  testPagePoll.writeRadioButton(work);
	  testPagePoll.writeInputText(text);
	  PageResult testPage2=testPagePoll.doSend();
      Assert.assertEquals("https://docs.google.com/forms/d/e/1FAIpQLSdccTDCqi87lZM7vQ3uLm46h7mkv_4stZioAjxD5Sud5LuVnA/formResponse", testPage2.url());
		
  }
  @Test
  public void test2(String date, String text,String civil_status, String work) {
	  PagePoll testPagePoll=PageFactory.initElements(driver, PagePoll.class);
	  testPagePoll.writeCalendar(date);
	  testPagePoll.writeDropdown(civil_status);
	 // testPagePoll.writeRadioButton(work);
	  testPagePoll.writeInputText(text);
	  PageResult testPage2=testPagePoll.doSend();
      Assert.assertEquals("https://docs.google.com/forms/d/e/1FAIpQLSdccTDCqi87lZM7vQ3uLm46h7mkv_4stZioAjxD5Sud5LuVnA/viewanalytics", testPage2.url());	
  }
  

  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
