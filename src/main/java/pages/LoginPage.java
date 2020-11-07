package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object repository (OR)
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement Logo;
	
	
	public LoginPage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
		
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateImage() {
		return Logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd ) throws IOException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		
		return new HomePage();
	}

}
