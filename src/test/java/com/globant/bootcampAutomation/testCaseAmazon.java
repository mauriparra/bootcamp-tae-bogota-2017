package com.globant.bootcampAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

/**
 * Created by MauricioLeonardo on 4/28/2017.
 */
public class testCaseAmazon {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.amazon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCaseAmazon() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-1")).click();
        driver.findElement(By.id("ap_email")).clear();
        driver.findElement(By.id("ap_email")).sendKeys("rack2106@hotmail.com");
        driver.findElement(By.id("ap_password")).clear();
        driver.findElement(By.id("ap_password")).sendKeys("mao1020754347");
        driver.findElement(By.name("rememberMe")).click();
        driver.findElement(By.id("signInSubmit")).click();
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    }
