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
import org.testng.Assert;

/**
 *
 * @author admin
 */
public class ResultPage extends BasePage{
    
	private static String MSG_ERR_RESULT = "There isn't any fly result for your search";
	
	@FindBy(how = How.ID, using = "departureResults")
	WebElement departureResults;
	
	@FindBy(how = How.ID, using = "aa-pageTitle")
	WebElement resultTitle;
	
	@FindBy(how = How.CLASS_NAME, using = "chooseflights-sort")
	WebElement sortSelector;
	
	public ResultPage(WebDriver driver) {
		super(driver);
	}
	
	public void validateResult(){
		
		if(driver.findElement(By.className("headerCopy")).isEnabled()){
			System.out.println(driver.findElement(By.className("headerCopy")).getText());
			//Assert.assertEquals(, expected);
		}
		
		Assert.assertFalse(departureResults.isDisplayed(), MSG_ERR_RESULT);
		Assert.assertFalse(resultTitle.isDisplayed(), MSG_ERR_RESULT);
	}
}
