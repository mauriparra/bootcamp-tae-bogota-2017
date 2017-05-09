package com.globant.bootcampAutomation;

import com.globant.bootcampAutomation.Helper.BrowserFactory;
import org.apache.http.util.Args;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

import static com.globant.bootcampAutomation.Page1.PAGE_URL;


/**
 * Created by carrio1 on 4/27/17.
 */
public class PagesTest {


    @Test
    public void submitNormalBooking(){

        WebDriver driver=BrowserFactory.startBrowser("chrome",PAGE_URL);

        Page1 page1=PageFactory.initElements(driver, Page1.class);
        page1.bookFlight("dfw","ist");


    }

    @Test
    public void maxAdults(){

        WebDriver driver=BrowserFactory.startBrowser("chrome",PAGE_URL);

        Page1 page1=PageFactory.initElements(driver, Page1.class);
        page1.maxAdults("dfw","ist");

    }

    @Test
    public void invalidDate(){

        WebDriver driver=BrowserFactory.startBrowser("chrome",PAGE_URL);

        Page1 page1=PageFactory.initElements(driver, Page1.class);
        page1.pastDate("dfw","ist");
    }

}
