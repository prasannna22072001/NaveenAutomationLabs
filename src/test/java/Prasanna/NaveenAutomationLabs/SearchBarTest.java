package Prasanna.NaveenAutomationLabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import prasanna_kumar.TestComponents.BaseTest;

public class SearchBarTest extends BaseTest {

	
	@Test
	public void searchbar() throws InterruptedException {
		
		String[] RD = {"prasanna kumar", "tallam","prasannak@gmail.com","1234556789","1234"};
		 
		String[] prodStrings = {"iPod Nano" , "iPod Classic", "iPod Touch"};
		
		LoginPage lPage = new LoginPage(driver);
		
		lPage.searchbarstep1(RD);
		
		
		SearchBarPage search = new SearchBarPage(driver);
		search.step1();
		search.step2(prodStrings);
	}
	
	
}
