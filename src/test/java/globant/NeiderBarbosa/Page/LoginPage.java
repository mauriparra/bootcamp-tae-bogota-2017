/**
 * 
 */
package globant.NeiderBarbosa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
	
	UpdatePage UpdatePage;

	@FindBy(id = "loginNonPop")
	private WebElement Email ;
	
	@FindBy(id = "passwordNonPop")
	private WebElement PassWord ;
	
	@FindBy(id = "signInButtonNonPop")
	private WebElement BotonLogin ;
	
	public   LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void Login(String User , String Password){
		super.SendText(Email, User);
		super.SendText(PassWord, Password);
		super.SendBottom(BotonLogin);		
	}
	
	public UpdatePage SubmitPage(){
		return PageFactory.initElements(driver, UpdatePage.class);
		
	}
	
	


}
