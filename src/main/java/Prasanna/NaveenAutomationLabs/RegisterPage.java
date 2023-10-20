package Prasanna.NaveenAutomationLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractComponent{

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By results1 = By.xpath("//a[@title='My Account']/span[1]");
	
	@FindBy(xpath="//a[@title='My Account']/span[1]")
	WebElement myAccount;
	
	
	@FindBy(xpath="//a[contains(.,'Register')]")
	WebElement register;
	
	@FindBy(id="input-firstname")
	WebElement fName;
	
	@FindBy(id="input-lastname")
	WebElement lName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement phone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement password_con;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement check_box;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement warning;
	
	@FindBy(xpath="//li/a[contains(.,'Login')]")
	WebElement login;
	
	public void stpe1() throws InterruptedException {
		
		
		waitForElementToAppear(myAccount);
		myAccount.click();
		register.click();
	}
	
	public void step2(String[] rD) {
		
		waitForElementToAppear(fName);
		fName.sendKeys(rD[0]);
		lName.sendKeys(rD[1]);
		email.sendKeys(rD[2]);
		phone.sendKeys(rD[3]);
		password.sendKeys(rD[4]);
		password_con.sendKeys(rD[4]);
		check_box.click();
		submit.click();
	}
	
	public void step3() throws InterruptedException {
		
		//Thread.sleep(3000);
		String Wmessage = warning.getText();
		if(Wmessage.equalsIgnoreCase("Warning: E-Mail Address is already registered!")) {
			myAccount.click();
			login.click();
		}
		
	}
	
}
