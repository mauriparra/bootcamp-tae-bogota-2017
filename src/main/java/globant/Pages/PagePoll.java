package globant.pages;

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
	@FindBy(how = How.XPATH, using = "(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Solter@'][text()='Solter@'])[2]")
	WebElement dropdownSelectorSingle;
	@FindBy(how = How.XPATH, using = "(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Casad@'][text()='Casad@'])[2]")
	WebElement dropdownSelectorMarried;
	@FindBy(how = How.XPATH, using = "(//CONTENT[@class='quantumWizMenuPaperselectContent'][text()='Viud@'][text()='Viud@'])[2]")
	WebElement dropdownSelectorWidower;
	@FindBy(how = How.XPATH, using = "(//DIV[@class='exportLabelWrapper'])[1]")
	WebElement radioButtonYesEmployed;
	@FindBy(how = How.XPATH, using = "(//DIV[@class='exportLabelWrapper'])[2]")
	WebElement radioButtonNoEmployed;
	@FindBy(how = How.XPATH, using = "//INPUT[@type='text']")
	WebElement inputText;
	@FindBy(how = How.XPATH, using = "//SPAN[@class='quantumWizButtonPaperbuttonLabel exportLabel'][text()='Enviar']")
	WebElement send;

	public void writeCalendar(String date) {
		calendar.sendKeys(date);
		calendar.click();
	}

	public void writeDropdown(String select) {
		
		if (select.equals("single")){
			dropdown.click();
			dropdownSelectorSingle.click();
			dropdownSelectorSingle.click();
			
		}else if(select.equals("married")){
			dropdown.click();
			dropdownSelectorMarried.click();
			dropdownSelectorMarried.click();
			
		}else if(select.equals("windower")){
			dropdown.click();
			dropdownSelectorWidower.click();
			dropdownSelectorWidower.click();			
		}else{
			System.out.println("wrong");
		}
	}

	public void writeRadioButton(String select) {
		if(select.equals("employed")){
			radioButtonYesEmployed.click();
		}else if(select.equals("unemployed")){
			radioButtonNoEmployed.click();
		}
		
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
