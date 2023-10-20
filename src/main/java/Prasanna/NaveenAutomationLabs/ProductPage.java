package Prasanna.NaveenAutomationLabs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractComponent{

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//h4/a")
	List <WebElement> PNames;
	
	@FindBy(xpath="//ul[@class='list-inline']/li[3]/a/span")
	WebElement click1;
	
	public void step1() throws InterruptedException {
		
		Thread.sleep(2000);
		List <String> Productnames = PNames.stream().map(s->s.getText()).collect(Collectors.toList());
		Productnames.forEach(q->System.out.println(q));
	}
	
	public void step2(String[] ProductN) throws InterruptedException {
		
		
		
		for(int i=0;i<ProductN.length;i++) {
			
			String j = ProductN[i];
			WebElement Pr= PNames.stream().filter(s->s.getText().equalsIgnoreCase(j)).findFirst().orElse(null);
			Thread.sleep(1000);
			Pr.findElement(By.xpath("parent::h4/parent::div/following-sibling::div/button[2]")).click();
		
		}
		
		Thread.sleep(2000);
		click1.click();
	}
	
	
	
}
