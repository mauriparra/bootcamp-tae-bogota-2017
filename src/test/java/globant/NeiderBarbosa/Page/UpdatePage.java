/**
 * 
 */
package globant.NeiderBarbosa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UpdatePage extends BasePage {
	
	
	
	public UpdatePage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "firstName")
	private WebElement FirstName ;
	
	@FindBy(id = "lastName")
	private WebElement LastName ;
	
	@FindBy(id = "emailAddr")
	private WebElement Email ;
	
	@FindBy(id = "radio")
	private WebElement male ;
	
	@FindBy(id = "radio")
	private WebElement female ;
	
	@FindBy(id = "dayOfBirth")
	private WebElement DayBirth ;
	
	@FindBy(id = "monthOfBirth")
	private WebElement MonthBirth ;
	
	@FindBy(id = "yearOfBirth")
	private WebElement YearBirth ;

	
	
	public void UpdateGeneral(String firstName , String lastName , String email , int gener , String Day , String Month ,String Year){ // int gener odd is male or even is female 
		checkAlert(driver);
		SendText(FirstName, firstName);
		SendText(LastName, lastName);
		SendText(Email, email);
		if (gener % 2 == 0)
			SendBottom(male);
		else
			SendBottom(female);
		SendCombo(DayBirth, Day);
		SendCombo(MonthBirth, Month);
		SendCombo(YearBirth, Year);
	}
}
