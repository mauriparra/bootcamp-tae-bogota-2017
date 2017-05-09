package com.globant.bootcampAutomation.practice2;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.bootcampAutomation.practice2.StartTest;

public class RegisterTest extends StartTest {

	@Test
	@Parameters({ "name", "lastName", "mail", "date", "terms", "gender", "city" })
    public void validateRegisterLink(String names, String lastName, String mail, String date, String terms, String gender, String city) throws Exception {
        HomePage homePage = new HomePage(driver);
		homePage.loadHomePage();
		homePage.findRegistredElement();		
        RegisterPage rp = homePage.linkPageHome();  
        rp.fillRegistrationForm(names, lastName, mail, date, terms, gender, city);
        rp.clickNext();
        
        assertTrue(rp.otherPage());
     }
}
