/**
 * 
 */
package globant.NeiderBarbosa.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;


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
	@FindBy(id = "phone")
	private WebElement Phone ;
	@FindBy(id = "cellular")
	private WebElement PhoneMobile ;
	@FindBy(id = "iframeIdMain")
	private WebElement Frame;
	@FindBy(id = "correspondenceCity")
	private WebElement Department ;
	@FindBy(id = "correspondenceShippingAddress")
	private WebElement City ;
	@FindBy(id = "maritalStatus")
	private WebElement MaritalStatus ;
	@FindBy(id = "occupation")
	private WebElement Ocupation;
	private WebElement Children;
	private WebElement Pets;
	private WebElement Car;
	
	
	
	public void FramePocision() {
		Driver.switchTo().frame(Frame);	
	}
	

	public void UpdateGeneralDate(String firstName , String lastName ,int gener , String Day , String Month ,String Year){
		SendText(FirstName, firstName);
		SendText(LastName, lastName);
		if (gener % 2 == 0)
			SendButton(male);
		else
			SendButton(female);
		SendCombo(DayBirth, Day);
		SendCombo(MonthBirth, Month);
		SendCombo(YearBirth, Year);
	}
	
	
	public void UpdateContacDate(String email ,String phone , String phoneMobile ,String departament ,String city ){
		SendText(Email, email);
		SendText(Phone, phone);
		SendText(PhoneMobile, phoneMobile);
		SendCombo(Department, departament);
		SendText(City, city);
	}
	
	public void UpdatePersonalDate(String maritalStatus, String ocupation , int children , int pets , int car){
		SendCombo(MaritalStatus, maritalStatus);
		SendCombo(Ocupation , ocupation);
		if (children % 2 == 0){
			Children.findElement(By.id("sonsClifre1"));
			SendButton(Children);
		}
		else{
			Children.findElement(By.id("sonsClifre0"));
			SendButton(Children);
		}
		if (pets % 2 == 0){
			Pets.findElement(By.id("havePets1"));
			SendButton(Children);
		}
		else{
			Pets.findElement(By.id("havePets0"));
			SendButton(Children);
		}
		if (car % 2 == 0){
			Car.findElement(By.id("haveCar1"));
			SendButton(Children);
		}
		else{
			Car.findElement(By.id("haveCar0"));
			SendButton(Children);
		}
		
		
			
	}
}
