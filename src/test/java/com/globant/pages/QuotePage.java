/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import static com.globant.webtest.Constants.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 *
 * @author admin
 */
public class QuotePage {

    WebSite website;
    /*@FindBy(how = How.ID, using = "SpanLabelDivLoad")
    private WebElement loaderSpinner;*/

    public QuotePage(WebDriver driver) {
        website = new WebSite(driver);
    }
    
    public void selectAResult(){
        
        /*new FluentWait<WebElement>(loaderSpinner).
                withTimeout(10, TimeUnit.SECONDS).
                pollingEvery(100, TimeUnit.MILLISECONDS).
                until(new Function<WebElement, Boolean>(){
                    @Override
                    public Boolean apply(WebElement element){
                        return element.isDisplayed();
                    }
                });
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(loaderSpinner));
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOf(loaderSpinner));*/
        WebElement loaderSpinner = new WebDriverWait(website.getDriver(), TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.id("SpanLabelDivLoad")));
        new WebDriverWait(website.getDriver(), TIMEOUT).until(ExpectedConditions.invisibilityOf(loaderSpinner));
        Assert.assertEquals(RESULTS_TITLE, website.getDriver().getTitle());
        System.out.println("OK!");
    }
}
