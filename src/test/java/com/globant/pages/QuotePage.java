/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author admin
 */
public class QuotePage {

    @FindBy(css="select[class*='sbox-rooms-select']")
    private WebElement roomSelector;
    
    public void selectAResult(){
        (new Select(roomSelector)).selectByValue("3");
    }
}
