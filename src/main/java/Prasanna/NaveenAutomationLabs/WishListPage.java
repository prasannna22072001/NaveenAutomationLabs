package Prasanna.NaveenAutomationLabs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends AbstractComponent{

	WebDriver driver;
	
	public WishListPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//td/div[@class='price']")
	List <WebElement> PList;
	
	@FindBy(xpath="//tr/td[2]/a")
	List <WebElement> productName;
	
	@FindBy(css="#button-cart")
	WebElement addcart;
	
	public double step1() {
		
		List <String> LCost = PList.stream().map(q->q.getText().replace("$", "")).collect(Collectors.toList());
		//LCost.forEach(a->System.out.println(a));
		
		List<Float> FloatList = new ArrayList<>();

        for (String str : LCost) {
            try {
                float intValue = Float.parseFloat(str);
                FloatList.add(intValue);
            } catch (NumberFormatException e) {
                // Handle exceptions for strings that cannot be converted to integers.
                System.out.println("Error: Unable to parse '" + str + "' as an integer.");
            }
        }

        // Print the resulting list of integers
       double i=0.00;
        for (Float num : FloatList) {
        	i=i+num;
           
        }
        System.out.println(i);
        return i;
	}	
	
	
	public void step2(String[] DProduct) throws InterruptedException {
		
		//String[] DProduct = {"MacBook","HTC Touch HD"};
		
		
		for(int i=0;i<DProduct.length;i++) {
			
			String P = DProduct[i];
			WebElement w = productName.stream().filter(s->s.getText().equalsIgnoreCase(P)).findFirst().orElse(null);
			Thread.sleep(2000);
			w.findElement(By.xpath("parent::td/parent::tr/td[6]/button")).click();
		}
		
	}
	
	public void step3() {
		
		WebElement a =productName.stream().filter(q->q.getText().equalsIgnoreCase("HP LP3065")).findFirst().orElse(null);
		a.findElement(By.xpath("parent::td/parent::tr/td[6]/button")).click();
	
		waitForElementToAppear(addcart);
		addcart.click();
	
	}
	
	
	
}
