package Prasanna.NaveenAutomationLabs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prasanna_kumar.TestComponents.BaseTest;

public class MainFile extends BaseTest{

	String[] RD = {"prasanna kumar", "tallam","prasannak@gmail.com","1234556789","1234"};
	String[] ProductN = {"HP LP3065","HTC Touch HD","MacBook","Product 8"};
	String[] DProduct = {"MacBook","HTC Touch HD"};
	double actualsum = 968.0;
	
	@Test
	public void test1() throws InterruptedException {
		
		//i didn't call startDriver because - i wrote beforetest annotation above this startdriver method in BaseTest class. So there is no need to call this method because of this annotation
		
		RegisterPage regPage = new RegisterPage(super.driver);
		regPage.stpe1();
		regPage.step2(RD);
		regPage.step3();
	
	
	
		LoginPage lPage = new LoginPage(super.driver);
		lPage.step1(RD);
		lPage.step2();
	
		ProductPage ProPage = new ProductPage(super.driver);
		ProPage.step1();
		ProPage.step2(ProductN);
		
		
		WishListPage WPage = new WishListPage(super.driver);
		double sum = WPage.step1();
		Assert.assertEquals(sum, actualsum);
		
		WPage.step2(DProduct);
		WPage.step3();
		
		CartPage cart = new CartPage(driver);
		cart.step1();
		cart.step2();
	}
	
	
}
