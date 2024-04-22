package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;	
	public AddCustomerPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	By email = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	By fName = By.xpath("//input[@id='Password']//following::input[@id='FirstName']");
	By lName = By.xpath("//input[@id='LastName']");
	By company = By.xpath("//input[@id='Company']");
	By date = By.xpath("//input[@id='Company']//parent::div//preceding-sibling::div//parent::div//preceding-sibling::div[@class='form-group row'][1]");
	By gender = By.xpath("//input[@id='Gender_Male']");
	By isTax = By.xpath("//input[@class='check-box' and @name='IsTaxExempt']");
	
	By newsLatter = By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']//option[2]");
	
	@FindBy (xpath = "//select[@id='SelectedCustomerRoleIds']//option[3]")
	WebElement listCustomerRoles;
	
	@FindBy (xpath = "//select[@id='VendorId']//option[3]")
	WebElement listVendors;	
	
	By isActive = By.xpath("//input[@id='Active']");
	By comment = By.xpath("//textarea[@name='AdminComment']");
	By saveBtn = By.cssSelector("button[name='save']");
	By addNewCustomerBtn = By.xpath("//a[@href='/Admin/Customer/Create']//i");
	By customerLink = By.xpath("//li//a[@class='nav-link']//i[@class='nav-icon far fa-user']//following-sibling::p");
	By customerLinkMenuItem = By.xpath("//a[@href='/Admin/Customer/List']//p");
	
	public String getPagetitle() {
		 return driver.getTitle();		
	}
	public void clickOnCustomerLink() {
		driver.findElement(customerLink).click();
	}
	
	public void clickOnCustomerLinkMenuItem() {
		driver.findElement(customerLinkMenuItem).click();
	}
	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}
	public void clickAddNewBtn() {
		driver.findElement(addNewCustomerBtn).click();
	}
	public void enterComment() {
		
		driver.findElement(comment).sendKeys("Required attention with this company");;
	}
	public void selectChkBox(){
		
		driver.findElement(isActive).click();
	}
	public void selectNewsLatter() {	
		driver.findElement(newsLatter).click();
	}
	public void setCustomerRoles() {		
		listCustomerRoles.click();
	}
	public void setVendor() {
			listVendors.click();
	}	
	public void selectTaxChkBox() {
		driver.findElement(isTax).click();
	}
	public void enterEmail(String email1) {
		driver.findElement(email).sendKeys(email1);;
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void enterFName(String fName1) {
		driver.findElement(fName).sendKeys(fName1);
	}
	public void enterLName(String lName1) {
		driver.findElement(lName).sendKeys(lName1);
	}
	public void enterCompanyName(String CName) {
		driver.findElement(company).sendKeys(CName);
	}
	public void enterDate() {
		driver.findElement(date).sendKeys("7/12/1983");
	}
	public void selectGender() {
		driver.findElement(gender).click();
	}
	
	
	
	
	
	
}
