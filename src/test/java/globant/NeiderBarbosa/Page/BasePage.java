package globant.NeiderBarbosa.Page;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	

	private WebElement Text;
	private WebElement Bottom;
	private WebElement Combo;
	public WebDriver driver;
	
	public void checkAlert(WebDriver driver) {
	        Alert wait = driver.switchTo().alert(); 
	}
	
	public BasePage(WebDriver driver ) {
		this.driver = driver;
	}
	
	public void SendText (WebElement Text , String Data){
		this.Text = Text;
		Text.sendKeys(Data);
		
	}
	
	public void SendBottom (WebElement Bottom){
		this.Bottom = Bottom;
		Bottom.click();
	}
	
	

	public void SendCombo(WebElement Combo, String Value) {
		this.Combo = Combo;
		Select Select = new Select(Combo);
		Select.selectByValue(Value);
		
	}
	
	//public WebDriver getDriver(){
		//return driver;
	//}
	

	
		
}
	
	
