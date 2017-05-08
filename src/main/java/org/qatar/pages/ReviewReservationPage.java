package org.qatar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReviewReservationPage {

	@FindBy(how = How.CSS, using = "#modifySearch")
	WebElement buttonModifySearch;
	@FindBy(how = How.CSS, using = "div.header-line")
	WebElement headerLineOptions;
	@FindBy(how = How.CSS, using = "#isQmilesEnabled")
	WebElement buttonBookUsingSmiles;
	
	public boolean ValidatePageReviewButtonModifySearch(){
		if(buttonModifySearch.isEnabled()){
			return true;
		}
		return false;
	}
	public boolean ValidatePageReviewLineOption(){
		if(headerLineOptions.isDisplayed()){
			return true;
		}
		return false;
	}
	
	public boolean ValidatePageReviewButtonBookSmile(){
		if(buttonBookUsingSmiles.isEnabled()){
			return true;
		}
		return false;
	}

}
