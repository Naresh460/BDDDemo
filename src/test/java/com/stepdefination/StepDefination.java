package com.stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.Base;
import com.pageobjects.AddEmployee;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SearchResultsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination extends Base {
	LoginPage loginP;
	HomePage homeP;
	AddEmployee addEmployee;
	SearchResultsPage searchresultsPage;

	@Before
	public void browserSetup(Scenario s) throws IOException {
		this.senar = s;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\configuration\\prop.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
	}

	@After
	public void teardown(Scenario s) {

		//if (senar.isFailed()) {
			TakesScreenshot scr = (TakesScreenshot) driver;
			byte[] data = scr.getScreenshotAs(OutputType.BYTES);
			senar.attach(data, "image/png", "");

		//}
		driver.quit();
	}

//	@AfterStep
//	public void eachStep(Scenario s) {
//
//		TakesScreenshot scr = (TakesScreenshot) driver;
//		byte[] data = scr.getScreenshotAs(OutputType.BYTES);
//		senar.attach(data, "image/png", "");
//
//	}

	@Given("user in login Page")
	public void user_in_login_page() {
		System.out.println("Already in login page");
	}

	@Then("verify the Logo")
	public void verify_the_logo() {
		loginP = new LoginPage();
		Boolean aResult = loginP.verifyLogo();
		Assert.assertTrue("Verifing the logo", aResult);
	}

	@When("enter username and password and loggedin")
	public void enter_username_and_password_and_loggedin() {
		loginP = new LoginPage();
		homeP = loginP.loginMethod();

	}

	@Then("verify Homepage")
	public void verify_homepage() {
		Boolean aResults = homeP.verifyHomePage();
		Assert.assertTrue("Verifing the Homepage", aResults);

	}

	@And("enter id {string} in the EmployeeId box")
	public void enter_id_in_the_employee_id_box(String string) {
		homeP.enterID(string);

	}

	@And("click on search buton")
	public void click_on_search_buton() {
		searchresultsPage = homeP.clickSearchBtn();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		Boolean aResults = searchresultsPage.verifyresultSet();
		Assert.assertTrue("Results Passed", aResults);

	}
	
	
	@Then("user clicked on Add btton")
	public void user_clicked_on_add_btton() throws InterruptedException {
		addEmployee =homeP.addBtn();
		Thread.sleep(2000);
	}
	
	
	@Then("enter the Employee firstname {string} and lastname {string} and EmployeeId {string}")
	public void enter_the_employee_firstname_and_lastname_and_employee_id(String fname, String lanme, String int1) throws InterruptedException {
		addEmployee.enterdetails(fname, lanme, int1);
		Thread.sleep(2000);
	}



	
	@Then("click on save button")
	public void click_on_save_button() {
		addEmployee.saveBtn();
	}
	
	

	






	

}
