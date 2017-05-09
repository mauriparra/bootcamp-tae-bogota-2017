package globant.NeiderBarbosa.Ana.test;




import org.testng.annotations.Test;
import globant.NeiderBarbosa.Ana.Page.FlightReservationPage;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class FlightReservationTest {
	
	private String url = "http://www.ana.co.jp/asw/wws/us/e/";
	WebDriver driver;	
	FlightReservationPage flightReservation;
	
	@BeforeTest
	public void setup () {
		
	
		driver = new ChromeDriver();
		driver.get(url);
	    flightReservation = PageFactory.initElements(driver, FlightReservationPage.class);
	}
	
	
  	public boolean transforExpect( String string){
  		if (string.equals("1"))
  			return true;
  		else
  			return false;
  	}
  	
  	
  	
	
	@Test
	@Parameters ({"cityOrigin" ,"cityDestiny" , "dateInicial" , "dateEnd","adults","young" ,"childs","infants" , "cityOriginExpect" ,"cityDestinyExpect" , "dateInicialExpect" , "dateEndExpect","adultsExpect","youngExpect" ,"childsExpect","infantsExpect"})
	public void bookingTest(String cityOrigin , String cityDestiny , String dateInicial , String dateEnd, String adults, String young ,String childs, String infants ,  String cityOriginExpect , String cityDestinyExpect ,  String dateInicialExpect, String dateEndExpect, String adultsExpect, String youngExpect, String childsExpect, String infantsExpect)  {
		//assertEquals(flightReservation.selectOrigin(cityOrigin), transforExpect(cityOriginExpect));
		assertEquals(flightReservation.selectDestiny(cityDestiny), transforExpect(cityDestinyExpect));
		assertEquals(flightReservation.person(1, adults),transforExpect(adultsExpect) );
		assertEquals(flightReservation.person(2, young),transforExpect(youngExpect) );
		assertEquals(flightReservation.person(3, childs),transforExpect(childsExpect) );
		assertEquals(flightReservation.person(4, infants),transforExpect(infantsExpect) );
		//assertEquals(flightReservation.genereateDates(dateInicial),transforExpect(dateInicialExpect));
	}
	
	
	//@AfterTest
	public void close() {
		driver.quit();
	}
}
