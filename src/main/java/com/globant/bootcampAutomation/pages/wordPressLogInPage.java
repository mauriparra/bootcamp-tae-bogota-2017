package com.globant.bootcampAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by MauricioLeonardo on 5/4/2017.
 */
public class wordPressLogInPage extends basePage {

    public wordPressLogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "user_login")
    WebElement field_EmailLogin;

    @FindBy (id = "user_pass")
    WebElement field_PasswordLogin;

    @FindBy (id = "rememberme")
    WebElement checkBox_rememberMe;

    @FindBy (id = "wp-submit")
    WebElement loginSubmitButton;

    public void setText_EmailLogin (String text){
        setElementText(field_EmailLogin,text);
    }

    public void setText_PasswordLogin(String text){
        setElementText(field_PasswordLogin,text);
    }

    public void clickRememberMeButton(Boolean remember){
        if (!remember){
            clickElement(checkBox_rememberMe);
        }
    }

    public wordPressHomePage clickLoginSubmitButton (){
        clickElement(loginSubmitButton);
        new WebDriverWait(driver, 10);
        return PageFactory.initElements(driver,wordPressHomePage.class);
    }



}
