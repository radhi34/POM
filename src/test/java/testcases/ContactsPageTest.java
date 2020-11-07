package testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import base.TestBase;

import pages.DealsPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealpage;

	public ContactsPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		dealpage = new DealsPage();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		driver.switchTo().frame("mainpanel");
		contactpage =homepage.ClickOnContactlink();
	
	}
@Test(priority=1)	
public void verifyContactPAgeLabel() {
	Assert.assertTrue(contactpage.verifyContactsLabel() , "label is missing");
	
}

@Test(priority=2)
public void selectcontactTest() {
	contactpage.selectContact("aa aaa");
}

/*
 * @DataProvider public Object[][] getCRMTestData(){ utilities.Xls_Reader d =
 * new utilities.Xls_Reader
 * ("C:\\Selenium_Workspace\\POM_Project\\src\\main\\java\\data\\FreeCrmTestData.xlsx"
 * ); Object data[][] = utilities.Xls_Reader.getTestData("contacts"); return
 * data; }
 */
@Test(priority=3, dataProvider="getCRMTestData")
public void validateCreateNewContact(String title, String firstName, String lastName, String company){
	homepage.clickOnNewContactLink();
	//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	contactpage.createNewContact(title, firstName, lastName, company);
	
}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
