package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver driver;

	public SearchCustomerPage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[id='SearchEmail']")
	WebElement email;

	@FindBy(xpath = "//tr/td[1]")
	List<WebElement> emailList;

	@FindBy(css = "input[id='SearchFirstName']")
	WebElement fName;

	@FindBy(xpath = "//tr/td[3]")
	List<WebElement> nameList;

	@FindBy(css = "input[id='SearchLastName']")
	WebElement lName;

	@FindBy(css = "input[id='SearchCompany']")
	WebElement searchCompany;

	@FindBy(css = "button[id='search-customers']")
	WebElement searchBtn;

	public void setEmail(String email1) {
		email.sendKeys(email1);
	}

	public void setfName(String fName1) {
		fName.sendKeys(fName1);
	}

	public void setlName(String lName1) {
		lName.sendKeys(lName1);
	}

	public void setSearchCompany(String companyName1) {
		searchCompany.sendKeys(companyName1);
	}

	public void clickSearchBtn() throws InterruptedException {
		searchBtn.click();
		Thread.sleep(3000);
	}

	public String getVerifyName(String expectedName) {

		for (WebElement name : nameList) {
			String searchName = name.getText();
			if (searchName.contains(expectedName)) {
				System.out.println(searchName);
			}
		}
		return expectedName;
	}

	public String getVerifyEmail(String expectedEmail) {

		for (WebElement name : nameList) {
			String searchEmail = name.getText();
			if (searchEmail.contains(expectedEmail)) {
				System.out.println(searchEmail);
			}
		}
		return expectedEmail;
	}
}
