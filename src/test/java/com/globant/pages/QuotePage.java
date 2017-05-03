/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import static com.globant.webtest.Constants.*;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author admin
 */
public class QuotePage extends WebSite{

    @FindBy(how = How.ID, using = "user_login")
    private WebElement userLoginInput;
    
    @FindBy(css = "#frmAgencias > #ENVIAR")
    private WebElement logingButton;
    
    @FindBy(css=".classDivAgencias")
    private WebElement divResults;
    
    public QuotePage(WebDriver driver) {
        super(driver);
    }
    
    public void loginAgent(){
        userLoginInput.sendKeys(USER_ID);
        logingButton.click();
    }
    
    public void selectAHotel(){
        System.out.println("Begining selection");
        List<WebElement> hotelButtons = divResults.findElements(By.cssSelector(".classAgencias > input"));
        Boolean firstHotel = true;
        
        for(WebElement button: hotelButtons){
            if(firstHotel){
                button.click();
                firstHotel = false;
                break;
            }
        }
        
        Assert.assertEquals(RESULTS_TITLE, getDriver().getTitle());
    }
}
