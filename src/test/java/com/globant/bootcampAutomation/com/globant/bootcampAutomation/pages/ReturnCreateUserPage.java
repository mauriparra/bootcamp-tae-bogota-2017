package com.globant.bootcampAutomation.com.globant.bootcampAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReturnCreateUserPage extends Page{

    public ReturnCreateUserPage(WebDriver driver) {
        super(driver);
    }

    public String currentUrl(){
        String result = new WebDriverWait(this.driver, 5).until(new ExpectedCondition<String>() {
            public String apply(WebDriver d) {
                return d.getCurrentUrl();
            }
        });
        return result;
    }
}
