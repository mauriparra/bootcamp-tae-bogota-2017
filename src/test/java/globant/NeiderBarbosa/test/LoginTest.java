package globant.NeiderBarbosa.test;




import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import globant.NeiderBarbosa.Page.LoginPage;

public class LoginTest {
	
	WebDriver driver;	
	LoginPage Login;
	globant.NeiderBarbosa.Page.UpdatePage UpdatePage;
	
	@BeforeTest
	public void setup () {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		
		driver.get("https://www.exito.com/account/logging.jsp");
	    Login = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test	
	public void TestLogin() {
		Login.Login("Nerderduancho@hotmail.com", "rediennaud");
		globant.NeiderBarbosa.Page.UpdatePage UpdatePage = Login.SubmitPage();
		AssertJUnit.assertEquals(driver.getTitle(), "exito.com - Administración de cuenta");
		UpdatePage.FramePocision();
		UpdatePage.UpdateGeneralDate("Neider", "Duan", 2 , "2", "3", "1995");
		UpdatePage.UpdateContacDate("nerderduancho@hotmail.com", "3138326533", "2658371", "CU", "Bogota");
		//UpdatePage.UpdatePersonalDate("Soltero", "Estudiante", 2, 2 ,2);
				
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
