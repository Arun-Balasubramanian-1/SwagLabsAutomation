package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceProducts {
	WebDriver driver;
	
	//==================Locators==================
	@FindBy(className="product_label")
	WebElement productsSection;
	
	
	//==================Page Methods=================
	public boolean isProductsSectionPresent() {
		return productsSection.isDisplayed();
	}
	
	//=================Initialize page elements=======
	public SauceProducts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
