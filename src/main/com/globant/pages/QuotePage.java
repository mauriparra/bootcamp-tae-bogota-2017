/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 *
 * @author admin
 */
public class QuotePage extends WebSite{

    @FindBy(how = How.ID, using = "blockrandom")
    private WebElement iframeResult;

    @FindBy(how = How.ID, using = "user_login")
    private WebElement userLoginInput;
    
    @FindBy(css = "#ENVIAR.botonNaranja")
    private WebElement logingButton;

    public QuotePage(WebDriver driver) {
        super(driver);
    }
    
    public void loginAgent(String userId){
        getDriver().switchTo().frame(iframeResult);
        userLoginInput.sendKeys(userId);
        logingButton.click();
    }
    
    public void selectAHotel(String resultsTitle){

        List<WebElement> hotelButtons = getDriver().findElements(By.className("classAgencias"));
        Boolean firstHotel = true;
        
        for(WebElement button: hotelButtons){
            if(firstHotel){
                By butonBook = By.cssSelector("#ENVIAR.botonNaranja");
                waitElement(butonBook);
                button.findElement(butonBook).click();
                firstHotel = false;
                break;
            }
        }
        getDriver().switchTo().defaultContent();
        waitElement("SpanLabelDivLoad2");
    }
}
