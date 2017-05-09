package com.globant.bootcampAutomation2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver){
		
		this.driver = driver;
	}
	
}
