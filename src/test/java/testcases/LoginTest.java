package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SauceDemoLogin;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginFailure() throws InterruptedException {
		SauceDemoLogin sauceLogin = new SauceDemoLogin(driver);
		sauceLogin.login("arun", "test");
		Thread.sleep(3000);
		String actualErrorMessage = sauceLogin.getLoginFailureMessage();
		System.out.println(actualErrorMessage);
		Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
	}

}
