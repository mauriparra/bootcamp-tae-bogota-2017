package com.globant.bootcampAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class AmazonLogInPage {

    WebDriver driver;

    public AmazonLogInPage(WebDriver driver) {

        this.driver = driver;
    }

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
