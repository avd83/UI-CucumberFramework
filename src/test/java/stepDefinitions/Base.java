package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Base {
	
	public static WebDriver driver;
	public LoginPage loginPage;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCustPage;
	public static Logger logger;
	public static Properties prop;
	
	

	public static String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public void WaitForElement(WebElement element,long timeoutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

}
