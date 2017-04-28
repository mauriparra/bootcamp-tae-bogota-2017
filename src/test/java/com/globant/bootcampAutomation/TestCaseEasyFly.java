package com.globant.bootcampAutomation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by MauricioLeonardo on 4/27/2017.
 */

public class TestCaseEasyFly {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.easyfly.com.co/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCaseEasyFly() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector(".ciudad.origen")).click();
        Select selectCiudad = new Select(driver.findElement(By.cssSelector(".ciudad.origen")));
        selectCiudad.deselectByVisibleText("Bogotá(BOG)");
        driver.findElement(By.linkText("originsTextReturn")).click();
        Select selectDestino = new Select (driver.findElement(By.xpath("originsTextReturn")));
        selectDestino.deselectByVisibleText("Bucaramanga (BGA)");
        driver.findElement(By.id("rdoIda")).click();
        driver.findElement(By.className("fecha_ida hasDatepicker")).click();
        driver.findElement(By.linkText("27")).click();
        driver.findElement(By.id("pax")).click();
        driver.findElement(By.xpath("//form[@id='form']/div[8]")).click();
        driver.findElement(By.id("btnBuscar")).click();
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



