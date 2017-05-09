package com.globant.bootcampAutomation.utility;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by MauricioLeonardo on 5/3/2017.
 */
public abstract class testBase {

    //Create this class to avoid code duplicity

    public WebDriver driver;

    @BeforeMethod(description = "This will run before each method and will take a browser from browserFactory")
    public void setUp() {
        Reporter.log("=====Browser session started=====", true);
        driver = browserFactory.startBrowser("chrome", "https://www.latam.com/en_us/");
        Reporter.log("=====Application Started=====", true);
    }

      @AfterMethod(description = "This will run after each method and will quit the driver regardless the result")
        public void tearDown()  {
        driver.quit();
        Reporter.log("=====Browser session ended",true);
   }
}
