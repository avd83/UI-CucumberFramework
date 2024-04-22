package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;	
	public LoginPage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy (css="input[id='Email']")
	WebElement email;
	
	@FindBy (xpath="//input[@id='Email']//following::div/input[@id='Password']")
	WebElement password;
	
	@FindBy (xpath="//label[text()='Remember me?']")
	WebElement checkBox;
	
	@FindBy (xpath="//input[@id='Email']//parent::div[@class='inputs']//parent::div[@class='form-fields']//following::div[4][@class='buttons']//button[text()='Log in']")
	WebElement loginBtn;
	
	@FindBy (xpath="//li//a[text()='Logout']")
	WebElement logoutBtn;
	
	@FindBy (xpath="//div[contains(text(),'Login was unsuccessful')]")
	WebElement loginValidationMsg;
		
	public void setEmail(String mail) {
		email.clear();
		 email.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		checkBox.click();
		loginBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();		
	}

	public String getLoginValidtaionMsg() {	
	
		return loginValidationMsg.getText();
		
	}

}
