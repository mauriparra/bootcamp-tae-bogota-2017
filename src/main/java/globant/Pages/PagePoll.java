package globant.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//WebElements Locators
public class PagePoll {
	WebDriver driver;

	public PagePoll(WebDriver driver1) {
		this.driver = driver1;

	}

	@FindBy(how = How.XPATH, using = "//INPUT[@type='date']/self::INPUT")
	WebElement calendar;
	@FindBy(how = How.XPATH, using = "//DIV[@class='quantumWizMenuPaperselectOption freebirdThemedSelectOptionDarkerDisabled exportOption isSelected isPlaceholder']")
	WebElement dropdown;
	@FindBy(how = How.XPATH, using = "(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Casad@'][text()='Casad@'])[1]")
	WebElement dropdownSelector1;
	@FindBy(how = How.XPATH, using = "(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Casad@'][text()='Casad@'])[2]")
	WebElement dropdownSelector2;
	@FindBy(how = How.XPATH, using = "(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Casad@'][text()='Casad@'])[3]")
	WebElement dropdownSelector3;
	@FindBy(how = How.XPATH, using = "(//DIV[@class='exportLabelWrapper'])[1]")
	WebElement radioButton1;
	@FindBy(how = How.XPATH, using = "(//DIV[@class='exportLabelWrapper'])[2]")
	WebElement radioButton2;
	@FindBy(how = How.XPATH, using = "//INPUT[@type='text']")
	WebElement inputText;
	@FindBy(how = How.XPATH, using = "//SPAN[@class='quantumWizButtonPaperbuttonLabel exportLabel'][text()='Enviar']")
	WebElement send;

	public void writeCalendar(String date) {
		calendar.sendKeys(date);
		calendar.click();
	}

	public void writeDropdown() {
		dropdown.click();
	}

	public void writeDropdownSelector1() {
		dropdownSelector1.click();
		dropdownSelector1.click();
	}
	public void writeDropdownSelector2() {
		dropdownSelector2.click();
		dropdownSelector2.click();
	}
	public void writeDropdownSelector3() {
		dropdownSelector3.click();
		dropdownSelector2.click();
	}

	public void writeRadioButton1() {
		radioButton1.click();
	}
	public void writeRadioButton2() {
		radioButton2.click();
	}

	public void writeInputText(String text) {
		inputText.click();
		inputText.sendKeys(text);
	}

	public PageResult doSend() {
		send.click();
		return PageFactory.initElements(driver, PageResult.class);
	}
	public String url(){
		 return driver.getCurrentUrl();
    }

	
}
