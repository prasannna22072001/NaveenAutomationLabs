package Prasanna.NaveenAutomationLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_button;
	
	@FindBy(xpath="//li/a[.='Desktops']")
	WebElement desktop;
	
	@FindBy(xpath="//a[contains(.,'Show All Desktops')]")
	WebElement click1;
	
	@FindBy(css=".alert.alert-danger.alert-dismissible")
	WebElement text1;
	
	@FindBy(xpath="//a[@title='My Account']/span[1]")
	WebElement myAccount;
	
	@FindBy(xpath="//li/a[contains(.,'Login')]")
	WebElement login;
	
	public void step1(String[] rd) {
		waitForElementToAppear(email);
		email.sendKeys(rd[2]);
		password.sendKeys(rd[4]);
		login_button.click();

	}

	public void step2() {
		waitForElementToAppear(desktop);
		Actions action = new Actions(driver);
		action.moveToElement(desktop).build().perform();
		click1.click();
	}

	
	public String loginfailStep1(String[] rd) {
		
		waitForElementToAppear(myAccount);
		myAccount.click();
		login.click();
		waitForElementToAppear(email);
		email.sendKeys(rd[2]);
		password.sendKeys(rd[4]);
		login_button.click();
		String wearning =text1.getText();
		System.out.println(wearning);
		
		return wearning;
	}
	
public void searchbarstep1(String[] rd) {
		
		waitForElementToAppear(myAccount);
		myAccount.click();
		login.click();
		waitForElementToAppear(email);
		email.sendKeys(rd[2]);
		password.sendKeys(rd[4]);
		login_button.click();
		
	}
	

}
