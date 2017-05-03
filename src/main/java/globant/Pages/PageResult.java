package globant.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageResult {
	WebDriver driver;

	public PageResult(WebDriver driver1) {
		this.driver = driver1;

	}
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "//A[@href='https://docs.google.com/forms/d/e/1FAIpQLSdccTDCqi87lZM7vQ3uLm46h7mkv_4stZioAjxD5Sud5LuVnA/viewanalytics?usp=form_confirm'][text()='Ver respuestas anteriores']")
	WebElement showAnswer;
	
	public void showAnswer(){
		showAnswer.click();
	}
	public String url(){
		 return driver.getCurrentUrl();
   }
}
