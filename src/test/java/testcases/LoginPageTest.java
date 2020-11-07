package testcases;



import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

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
	
	@Test(priority =1)
	public void loginPageTitleTest() {
	String title =loginpage.validateLoginPageTitle();
	Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public void LogoImage() {
		boolean flag = loginpage.validateImage();
		Assert.assertTrue(flag);
		}
	
	@Test(priority = 3)
	public void loginTest() throws IOException {
		
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		 
	}

}
