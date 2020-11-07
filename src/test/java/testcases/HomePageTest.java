package testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	
	
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	@Test(priority=1)
	public void verifyHomepageTitle() {
		String homepageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "HomePAge title not match");
	}
	
	@Test(priority=2)
	public void verifyingUserName() {
		driver.switchTo().frame("mainpanel");
		homepage.verifyCorrectUserName();
		Assert.assertTrue(homepage.verifyCorrectUserName());
		
	}
	
	@Test(priority=3)
	public void verifyContactLink() throws IOException {
		driver.switchTo().frame("mainpanel");
		contactpage = homepage.ClickOnContactlink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
