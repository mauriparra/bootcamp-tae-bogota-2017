package com.globant.bootcampAutomation;

import org.apache.http.util.Args;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

/**
 * Created by carrio1 on 4/27/17.
 */
public class SeleniumTest {

    public WebDriver driver;
    Page1 page1;

    @BeforeClass (alwaysRun = true)
    public void pageTest (){
        this.driver = new ChromeDriver();
    }

    @AfterClass (alwaysRun = true)
    public void closeTest (){
        this.driver.quit();
    }

    @Test
    public void testPage1(){

        Page1.main();
        Assert.assertEquals(page1.success,true);
    }


}
