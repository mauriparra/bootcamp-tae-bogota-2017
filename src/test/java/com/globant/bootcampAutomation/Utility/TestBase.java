package com.globant.bootcampAutomation.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class TestBase {

    public WebDriver driver;

    //This TestBase is created to avoid duplicity of code in different test cases

    @BeforeMethod(description = "This will run before each method and will take a browser from BrowserFactory")
    public void setUp()  {
        Reporter.log("=====Browser session started=====", true);
        driver = BrowserFactory.startBrowser("chrome","https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Reporter.log("=====Application Started=====",true);
    }

    @AfterMethod (description = "This will run after each method and will quit the driver regardless the result")
    public void tearDown()  {
        driver.quit();
        Reporter.log("=====Browser session ended",true);
        }
}
