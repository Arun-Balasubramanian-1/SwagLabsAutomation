package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLogin {
	
	WebDriver driver;
	
	//=============Locators=========================
	@FindBy(id="user-name")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement loginFailureMsg;
	
	//============Page Methods======================
	public void login(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public String getLoginFailureMessage() {
		return loginFailureMsg.getText();
	}
	
	//Initialize driver and page elements
	public SauceDemoLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
