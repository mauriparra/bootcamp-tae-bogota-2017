package globant.NeiderBarbosa.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import globant.NeiderBarbosa.Page.LoginPage;

public class LoginTest {
	
	WebDriver driver;	
	LoginPage Login;
	globant.NeiderBarbosa.Page.UpdatePage UpdatePage;
	
	@BeforeTest
	public void setup () {
		driver  = new ChromeDriver();
		driver.get("https://www.exito.com/account/logging.jsp");
	    Login = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test 
	public void TestLogin() {
		Login.Login("Nerderduancho@hotmail.com", "rediennaud");
		assertEquals(driver.getTitle(), "      exito.com - Administración de cuenta");
		globant.NeiderBarbosa.Page.UpdatePage UpdatePage = Login.SubmitPage();
		UpdatePage.UpdateGeneral("Juan Carlos", "Leon Rodriguez", "nerderduancho@hotmail.com", 2, "2", "3", "1900");
	}
	//@AfterTest
	public void close() {
		driver.quit();
	}
}
