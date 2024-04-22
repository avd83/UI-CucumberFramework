package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class LoginSteps extends Base {

	// WebDriver driver;
	LoginPage loginPage;
	AddCustomerPage addCust;
	// SearchCustomerPage searchCustPage;
	public static String expectedName;
	public static String expectedEmail;

	@Before
	public void initialization() throws IOException {

		logger = Logger.getLogger("UI-CucumberFramework");// Added Logger
		PropertyConfigurator.configure("log4j.properties");// Added Logger
		FileInputStream fis = new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(fis);

		String br = prop.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("edgepath"));
			driver = new EdgeDriver();
		}
		logger.info("-------------launching the browser---------------");

	}

	@Given(": User launch browser")
	public void user_launch_browser() throws IOException {
		// System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		// driver = new ChromeDriver();
		//initialization();
		loginPage = new LoginPage(driver);
	}

	@When(": User open url {string}")
	public void user_open_url(String url) {
		logger.info("-------------launching the URL---------------");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Then(": User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("-------------Enter email and password---------------");
		loginPage.setEmail(email);
		loginPage.setPassword(password);
	}

	@Then(": User clicks on Login button")
	public void user_clicks_on_login_button() {
		logger.info("-------------Clicking the login button---------------");
		loginPage.clickLoginBtn();
	}

	@Then(": User should get validation error message as {string}")
	public void user_should_get_validation_error_message_as(String expectedValidationMsg) throws InterruptedException {
		logger.info("-------------Error validation---------------");
		String actualValidationMsg = loginPage.getLoginValidtaionMsg();
		Thread.sleep(3000);
		System.out.println(actualValidationMsg);
		if (actualValidationMsg.contains(expectedValidationMsg)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

	@Then(": Page title should be {string}")
	public void page_title_should_be(String title) {
		logger.info("-------------Capture PageTitle---------------");

		if (driver.getPageSource().contains("Login was unscuccessful.")) {
			driver.close();
			logger.info("-------------Login Failed---------------");
			Assert.assertTrue(false);
		} else {
			logger.info("-------------Login Passed---------------");
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When(": User clicks on Logout button")
	public void user_clicks_on_logout_button() throws InterruptedException {
		logger.info("-------------Logout the page---------------");
		loginPage.clickLogoutBtn();
		Thread.sleep(3000);
	}

	@Then(": Close the browser")
	public void close_the_browser() {
		logger.info("-------------Closing the browser---------------");
		driver.quit();
	}

	// -----------------Customer-------------------------------------
	@Then(": User view dahsboard")
	public void user_view_dahsboard() {

		addCust = new AddCustomerPage(driver);
		String actualTitle = addCust.getPagetitle();
		Assert.assertEquals("Dashboard / nopCommerce administration", actualTitle);
	}

	@When(": User clicks on customer menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		logger.info("-------------Click on Customer Menu---------------");
		Thread.sleep(3000);
		addCust.clickOnCustomerLink();
	}

	@When(": click on customer menu Item")
	public void click_on_customer_menu_item() throws InterruptedException {
		logger.info("-------------Click on Customer Menu Item---------------");
		Thread.sleep(2000);
		addCust.clickOnCustomerLinkMenuItem();
	}

	@When(": User clicks on Add new button")
	public void user_clicks_on_add_new_button() throws InterruptedException {

		addCust.clickAddNewBtn();
		Thread.sleep(2000);
	}

	@Then(": User can view customer page")
	public void user_can_view_customer_page() {
		String actualAddNewTitle = addCust.getPagetitle();
		Assert.assertEquals("Add a new customer / nopCommerce administration", actualAddNewTitle);

	}

	@When(": User eneters customer info details")
	public void user_eneters_customer_info_details() throws InterruptedException {
		logger.info("-------------Adding new customer information---------------");
		String email = randomString() + "@gmail.com";
		addCust.enterEmail(email);
		addCust.enterPassword(randomString().toString());
		addCust.enterFName(randomString().toString());
		addCust.enterLName(randomString().toString());
		addCust.selectGender();
		// addCust.enterDate();
		addCust.enterCompanyName(randomString().toString());
		addCust.selectTaxChkBox();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		// addCust.selectNewsLatter();
		// addCust.setCustomerRoles();
		Thread.sleep(2000);
		addCust.setVendor();
		addCust.selectChkBox();
		addCust.enterComment();
	}

	@When(": Clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {
		logger.info("-------------Save customer information---------------");
		addCust.clickSaveBtn();
		Thread.sleep(3000);
	}

	@Then(": User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		logger.info("-------------Verify confirmation of added New custmer info ---------------");
		String actualConfirmationMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		System.out.println(actualConfirmationMessage);
		//SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(expectedConfirmationMsg, actualConfirmationMessage);
		//softAssert.assertAll();
	}

	// ----------------------Customer Search by Fname------------------

	@When(": User enters customers FirstName")
	public void user_enters_customers_first_name() {
		logger.info("-------------Search customers by FirstName---------------");
		expectedName = "Virat";
		searchCustPage = new SearchCustomerPage(driver);
		searchCustPage.setfName(expectedName);
	}

	@When(": User clicks on Search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		logger.info("-------------Click on Search button---------------");
		searchCustPage.clickSearchBtn();
	}

	@Then(": User should get the FirstName in table")
	public void user_should_get_the_first_name_in_table() {
		logger.info("-------------finding data table after search---------------");
		String actualName = searchCustPage.getVerifyName(expectedName);
		Assert.assertEquals(expectedName, actualName);
	}

	// ---------------------Customer Search by email-------------------

	@When(": User enters customers Email")
	public void user_enters_customers_email() {
		logger.info("-------------Search customers by emailId---------------");
		expectedEmail = "GgXkR@gmail.com";
		searchCustPage = new SearchCustomerPage(driver);
		searchCustPage.setEmail(expectedEmail);
	}

	@Then(": User should get the Email in table")
	public void user_should_get_the_email_in_table() {
		logger.info("-------------finding data table after search---------------");
		String actualEmail = searchCustPage.getVerifyName(expectedEmail);
		Assert.assertEquals(expectedEmail, actualEmail);
	}
}
