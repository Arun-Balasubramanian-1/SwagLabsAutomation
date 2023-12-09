package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUpAll() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void setUpDriver() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().timeouts().implicitlyWait(4000L, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
