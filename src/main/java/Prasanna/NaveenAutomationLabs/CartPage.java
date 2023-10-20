package Prasanna.NaveenAutomationLabs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="#cart-total")
	WebElement cartButton;
	
	@FindBy(xpath="(//p/a/strong)[1]")
	WebElement viewCart;
	
	@FindBy(xpath="//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr/td/strong[1]")
	List <WebElement> totals;
	
	@FindBy(xpath="//div[@class='col-sm-4 col-sm-offset-8']/table/tbody/tr/td[2]")
	List <WebElement> costs;
	
	public void step1() throws InterruptedException {
		
		Thread.sleep(2000);
		cartButton.click();
		viewCart.click();
	}
	
	public void step2() {
		
		List <String> t= totals.stream().map(w->w.getText()).collect(Collectors.toList());
		t.forEach(a->System.out.println(a));
		
		List <String> c =costs.stream().map(g->g.getText()).collect(Collectors.toList());
		c.forEach(w->System.out.println(w));
 	}
	
	
}
