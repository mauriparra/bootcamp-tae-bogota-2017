package com.globant.bootcampAutomation.practice2;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	protected WebDriver driver;
	private WebDriverWait wait;	
	private List<WebElement> columns;
	private static final String DISAGREEMENT_TERMS = "No Acepto";
	
	@FindBy(id="edit-field-user-name-und-0-value")
	private WebElement name;
	@FindBy(id="edit-field-apellido-und-0-value")
	private WebElement lastName;
	@FindBy(id="edit-mail")
	private WebElement mail;
	@FindBy(id="edit-pass-datepicker-popup-0")
	private WebElement date;
	@FindBy(id="edit-profile-main-field-terms-and-conditions-und-1")
	private WebElement terms;
	@FindBy(id="edit-submit")
	private WebElement btnSubmit;
	@FindBy(id="edit-profile-main-field-user-gender-und")
	private WebElement selectGender;
	@FindBy(id="edit-profile-main-field-user-city-und")
	private WebElement selectCity;	
	@FindBy(id="ui-datepicker-div")	
	private WebElement calendar;
	
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String nameText, String lastNameText, String mailText, String dateText, String termsText, String genderText, String cityText) {
    	
    	wait = new WebDriverWait(driver, 30);    	
		Select gender = new Select(selectGender);
		Select city = new Select(selectCity);
		
		name.sendKeys(nameText);
		lastName.sendKeys(lastNameText);
		mail.sendKeys(mailText);
		
		date.click();		 
		wait.until(ExpectedConditions.elementToBeClickable(calendar));
		calendarMap();
		
    	if(termsText.equals(DISAGREEMENT_TERMS))
    		terms.click();

		gender.selectByVisibleText(genderText);
		city.selectByVisibleText(cityText);
		
		//btnSubmit.click();    	
	}
    
    public void clickNext() {
    	driver.navigate().to("http://www.cremadelechealqueria.com/productos");
    }
    
    public boolean otherPage() {
    	return driver.getCurrentUrl().equals("http://www.cremadelechealqueria.com/productos");
    }
    

    
    public void calendarMap() {
        columns = calendar.findElements(By.tagName("td"));
        
		for(WebElement cell : columns) {
			
			if(cell.getText().equals("23")) {
				cell.findElement(By.linkText("23")).click();
				break;
			}
		}
    }
}
