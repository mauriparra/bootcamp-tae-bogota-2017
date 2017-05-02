package com.globant.bootcampAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class AmazonHomePage {

    WebDriver driver;

    public AmazonHomePage (WebDriver driver){

        this.driver = driver;
    }

    @FindBy (id = "nav-link-accountList")
    WebElement accountList;

    @FindBy (how = How.ID, using = "searchDropdownBox")
    WebElement searchDrodwonBox;

    @FindBy (how = How.CSS, using = "input.nav-input")
    WebElement searchButton;

    @FindBy (css = "option[value=\"search-alias=mobile-apps\"]")
    WebElement appsAndGamesOption;

    public void clickOnLogIn (){
        accountList.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void searchOnDropDown (){
        searchDrodwonBox.click();
        appsAndGamesOption.click();
        appsAndGamesOption.click();
    }


}
