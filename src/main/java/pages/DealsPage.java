package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DealsPage extends TestBase{

	public DealsPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy (xpath="//span[contains(text(),'Create New Event')]")
	WebElement createEvent;
	
	@FindBy(xpath="//span[contains(text(),'Create')]")
	WebElement create;
	
	@FindBy (xpath="//span[contains(text(), 'Post')]")
	WebElement Post;
	
	@FindBy (xpath ="//div[@class='_1mf _1mj']/span")
	WebElement Text;
	
	@FindBy (xpath="*[role='button'][tabindex='0'][css='21']")
	WebElement enter;

	
	public String verifyTitleEvent() {
		return driver.getTitle();
	}
	
	public ContactsPage ClickOnEveMake() throws IOException {
		
		createEvent.click();
		create.click();
		Post.click();
		Text.sendKeys("hii i am dhara");
		enter.click();
		return new ContactsPage();
	}
	
	
}
