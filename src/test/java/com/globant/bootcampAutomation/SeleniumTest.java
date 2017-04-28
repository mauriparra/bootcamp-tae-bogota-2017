package com.globant.bootcampAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by carrio1 on 4/27/17.
 */
public class SeleniumTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.hazunaweb.com/curso-de-html/ejemplo-formulario-html/");
        new WebDriverWait(driver,20);
        WebElement elementName = driver.findElement(By.name("Nombre"));
        elementName.sendKeys("Carlos");



    }
}
