package Prasanna.NaveenAutomationLabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import prasanna_kumar.TestComponents.BaseTest;

public class LoginFailTest extends BaseTest {
	
	String[] RD = {"prasanna kumar", "tallam","prasannak@gmail.com","1234556789","123"};
	String acctualWarning = "Warning: No match for E-Mail Address andor Password.";
	
	@Test
	public void loginfail() {
		
		LoginPage lPage = new LoginPage(super.driver);
		
		String warning = lPage.loginfailStep1(RD);
		Assert.assertEquals(warning, acctualWarning);
	}

}
