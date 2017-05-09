package globant.NeiderBarbosa.Page;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;






public class BasePage {
	

	private WebElement Text;
	private WebElement Combo;
	public WebDriver Driver;
	
	
	public BasePage(WebDriver driver ) {
		Driver = driver;
	}
	
	public void SendText (WebElement text , String data){
		Text = text;
		Text.clear();
		Text.sendKeys(data);
		
	}
	
	public void SendButton (WebElement button){
		button.click();
	}
	
	public void SendCombo(WebElement combo, String value) {
		Combo = combo;
		Select Select = new Select(Combo);
		Select.selectByValue(value);
	}		
}
	
	
