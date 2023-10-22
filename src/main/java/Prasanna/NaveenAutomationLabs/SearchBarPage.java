package Prasanna.NaveenAutomationLabs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBarPage extends AbstractComponent{

	WebDriver driver;
	
	public SearchBarPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchElement;
	
	@FindBy(xpath="//div[@class='caption']/h4/a")
	List<WebElement> namesElements;
	
	public void step1() {
		
		waitForElementToAppear(searchElement);
		searchElement.sendKeys("ip");
		searchElement.sendKeys(Keys.ENTER);
	}
	
	public void step2(String[] prodStrings) throws InterruptedException {
		
 		
		for(int i=0; i<prodStrings.length;i++) {
			
		String p = prodStrings[i];	
		
		WebElement nElement= namesElements.stream().filter(a->a.getText().equalsIgnoreCase(p)).findFirst().orElse(null);
		String priceString = nElement.findElement(By.xpath("parent::h4/following-sibling::p[@class='price']")).getText();
		System.out.println(priceString);
		Thread.sleep(2000);
		nElement.findElement(By.xpath("parent::h4/parent::div/following-sibling::div/button/span")).click();
		
		}
	}
}
