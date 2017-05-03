package com.globant.bootcampAutomation.pages;

import com.globant.bootcampAutomation.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class amazonLogInPage extends basePage {

    //Extending the basePage abstract super class to get public variables and methods

    //Using the constructor to overload the driver to be used in each page object
    public amazonLogInPage (WebDriver driver) {super(driver);}

    @FindBy(id = "ap_email")
    WebElement userName;

    @FindBy(id = "ap_password")
    WebElement userPassword;

    @FindBy(how = How.NAME, using = "rememberMe")
    WebElement rememberUserCheckBox;

    @FindBy(how = How.ID, using = "signInSubmit")
    WebElement signInButton;

    @FindBy(id = "auth-error-message-box")
    WebElement loginErrorMessage;

    public void loginAmazon(String uID, String uPass, boolean remember) {

        userName.sendKeys(uID);
        userPassword.sendKeys(uPass);
        if (remember) {
            rememberUserCheckBox.click();
        }
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean invalidLogIn() {
        if (loginErrorMessage.isDisplayed()) {
        }
        return true;

    }

}
