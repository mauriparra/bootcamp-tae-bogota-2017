package com.globant.bootcampAutomation.practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;
    
    private static final String LINK_REGISTER = "Regístrate";
    private static final String HOME_PAGE = "http://www.cremadelechealqueria.com";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
	public void loadHomePage() {
		 driver.navigate().to(HOME_PAGE);
	}

    public void findRegistredElement() {
    	driver.findElement(By.linkText(LINK_REGISTER)).click();
    }    

    public RegisterPage linkPageHome() {
    	return PageFactory.initElements(driver, RegisterPage.class);
    }
}
