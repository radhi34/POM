package testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestAllureReportListner;
@Listeners({TestAllureReportListner.class})
public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException{
		super();
		
	}

	@BeforeMethod
	public void SetUP() throws IOException  {
		initialization();
		loginpage= new LoginPage();
		
	}

	@Test(priority =1, description = "verifying login page title test")
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	
	public void loginPageTitleTest() {
	String title =loginpage.validateLoginPageTitle();
	AssertJUnit.assertEquals(title,"CRMPR - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2, description = "verifying image")
	
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description: Verify image")
	@Story("Story Name: To check login page image")
	public void LogoImage() {
		boolean flag = loginpage.validateImage();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority = 3, description = "login into app")

	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify login into app with correct username and password")
	@Story("Story Name: To check login functionality")
	public void loginTest() throws IOException {
		
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		 
	}

}
