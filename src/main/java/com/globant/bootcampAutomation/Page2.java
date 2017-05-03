package com.globant.bootcampAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by carrio1 on 5/2/17.
 */


public class Page2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.iberia.com/co/");
        new WebDriverWait(driver, 20);
        WebElement elementTextTo = driver.findElement(By.id("text-to-visible"));
        elementTextTo.sendKeys("Barcelona");
        elementTextTo.sendKeys("\ue007");

        WebElement elementIda = driver.findElement(By.id("ida"));
        elementIda.click();

        WebElement elementDiaSalida = driver.findElement(By.id("diaSalida"));
        elementDiaSalida.sendKeys("11/07/2017");


        elementIda.click();

        new WebDriverWait(driver, 6);

        Select selectAdults = new Select(driver.findElement(By.id("select-adultos")));
        selectAdults.selectByVisibleText("2");

        Select selectClass = new Select(driver.findElement(By.id("select-clase")));
        selectClass.selectByVisibleText("Turista Premium");

        new WebDriverWait(driver, 5);

        WebElement elementToAvailSubmit = driver.findElement(By.id("toAvailSubmit"));
        elementToAvailSubmit.click();

    }

    boolean success = true;

}


