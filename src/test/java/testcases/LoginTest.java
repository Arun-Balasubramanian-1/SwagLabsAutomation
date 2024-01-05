package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.SauceDemoLogin;
import pages.SauceProducts;

public class LoginTest extends BaseClass  {
	
	@Test(enabled = true)
	public void loginFailure() throws InterruptedException {
		SauceDemoLogin sauceLogin = new SauceDemoLogin(driver);
		
		sauceLogin.login("arun", "test");
		Thread.sleep(4000);
		String actualErrorMessage = sauceLogin.getLoginFailureMessage();
		System.out.println(actualErrorMessage);
		Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test(enabled = true, groups = {"sanity"})
	public void loginSuccess()throws InterruptedException {
		SauceDemoLogin sauceLogin = new SauceDemoLogin(driver);
		SauceProducts  sauceProduct = new SauceProducts(driver);
		sauceLogin.login("standard_user", "secret_sauce");
		Thread.sleep(4000);
		Assert.assertEquals(sauceProduct.isProductsSectionPresent(), true);
	}
	
	@Test
	public void addItemToCart() throws InterruptedException {
		SauceDemoLogin sauceLogin = new SauceDemoLogin(driver);
		SauceProducts  sauceProduct = new SauceProducts(driver);
		String product = "Sauce Labs Backpack";

		sauceLogin.login("standard_user", "secret_sauce");
		Thread.sleep(3000);
		Assert.assertEquals(sauceProduct.isAddToCartPresent(product), true);
		Assert.assertEquals(sauceProduct.isRemoveItemPresent(product), false);
		sauceProduct.clickAddToCart(product);
		Thread.sleep(3000);
		Assert.assertEquals(sauceProduct.isAddToCartPresent(product), false);
		Assert.assertEquals(sauceProduct.isRemoveItemPresent(product), true);
	}

}
