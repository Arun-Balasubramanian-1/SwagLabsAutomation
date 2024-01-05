package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceProducts {
	WebDriver driver;
	
	//=================Initialize page elements=======
	public SauceProducts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//==================Locators==================
	@FindBy(className="product_label")
	WebElement productsSection;
	
	public List<WebElement> addToCart(String product) {
		return driver.findElements(By.xpath("//div[contains(text(),'" + product + "')]//ancestor::div[@class='inventory_item']//button[contains(text(),'ADD TO CART')]"));
	}
	
	public List<WebElement> removeItem(String product) {
		return driver.findElements(By.xpath("//div[contains(text(),'" + product + "')]//ancestor::div[@class='inventory_item']//button[contains(text(),'REMOVE')]"));
	}
	
	
	//==================Page Methods=================
	public boolean isProductsSectionPresent() {
		return productsSection.isDisplayed();
	}
	
	public void clickAddToCart(String product) {
		addToCart(product).get(0).click();
	}
	
	public boolean isAddToCartPresent(String product) {
		return addToCart(product).size() > 0;
	}
	
	public boolean isRemoveItemPresent(String product) {
		return removeItem(product).size() > 0;
	}
	
	

}
