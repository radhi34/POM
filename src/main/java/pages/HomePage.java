package pages;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy (xpath="//td[contains(text(),'User: Demo User')]")
	WebElement user;

	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactLink;
	
	@FindBy (xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy (xpath="//a[Contains(text(),'Tasks']")
	WebElement TasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	public HomePage() throws IOException  {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage ClickOnContactlink() throws IOException {
		 ContactLink.click();
		 return new ContactsPage();
	}
	
	public DealsPage ClickOnDealLink() throws IOException {
		
		DealsLink.click();
		return new DealsPage();
	}
	
	public boolean verifyCorrectUserName() {
		return user.isDisplayed();
	}

	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactLink).build().perform();
		newContactLink.click();
		
	}
}
