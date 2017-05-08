package com.globant.bootcampAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * Created by MauricioLeonardo on 5/4/2017.
 */
public class wordPressPostPage extends basePage {

    public wordPressPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "textarea.textarea-autosize.editor-title__input")
    WebElement field_setPostTitle;

    @FindBy (xpath = "(//button[@type='button'])[4]")
    WebElement publishButton;

    @FindBy (xpath = ".//*[@id='primary']/div/div[2]/div[2]/div[1]/div[1]/div/span[1]/span")
    WebElement successfulPostSign;

    public void setText_PostTitle (String text){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(field_setPostTitle));
        setElementText(field_setPostTitle,text);
    }

    public void clickPublishButton (){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(publishButton));
        if (publishButton.isDisplayed()) {
            clickElement(publishButton);
        }
    }

    public void waitForPostConfirmation (){
        String postConfirmationNotice = successfulPostSign.getText();
        Reporter.log(postConfirmationNotice,true);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(successfulPostSign));
    }

    public boolean successfulPost(){
            return successfulPostSign.isDisplayed();
    }

}
