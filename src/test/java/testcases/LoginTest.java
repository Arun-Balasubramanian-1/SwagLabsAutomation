package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SauceDemoLogin;
import pages.SauceProducts;

public class LoginTest extends BaseClass  {
	
	@Test
	public void loginFailure() throws InterruptedException {
		SauceDemoLogin sauceLogin = new SauceDemoLogin(driver);
		
		sauceLogin.login("arun", "test");
		Thread.sleep(4000);
		String actualErrorMessage = sauceLogin.getLoginFailureMessage();
		System.out.println(actualErrorMessage);
		Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test
	public void loginSuccess()throws InterruptedException {
		SauceDemoLogin sauceLogin = new SauceDemoLogin(driver);
		SauceProducts  sauceProduct = new SauceProducts(driver);

		sauceLogin.login("standard_user", "secret_sauce");
		Thread.sleep(4000);
		Assert.assertEquals(sauceProduct.isProductsSectionPresent(), true);
	}

}
