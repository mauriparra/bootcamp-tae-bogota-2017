package com.globant.bootcampAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by carrio1 on 4/27/17.
 */
public class SeleniumTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.iberia.com/co/");
        new WebDriverWait(driver,20);
        WebElement elementTextTo = driver.findElement(By.id("text-to-visible"));
        elementTextTo.sendKeys("Barcelona");

        WebElement elementIdaVuelta = driver.findElement(By.id("ida-vuelta"));
        elementIdaVuelta.click();

        WebElement elementDiaSalida = driver.findElement(By.id("diaSalida"));
        elementDiaSalida.sendKeys("11/05/2017");
        elementDiaSalida.sendKeys("\ue007");

        WebElement elementDiaRegreso = driver.findElement(By.id("diaRegreso"));
        elementDiaRegreso.sendKeys("01/06/2017");
        elementDiaRegreso.sendKeys("\ue007");

        elementDiaSalida.sendKeys("\ue007");

        Select selectAdultos = new Select(driver.findElement(By.id("select-adultos")));
        selectAdultos.selectByVisibleText("2");

        Select selectClase = new Select(driver.findElement(By.id("select-clase")));
        selectClase.selectByVisibleText("Turista Premium");

        WebElement elementCheckAvios = driver.findElement(By.id("check-avios"));
        elementCheckAvios.click();

        WebElement elementToAvailSubmit = driver.findElement(By.id("toAvailSubmit"));
        elementToAvailSubmit.click();


    }
}
