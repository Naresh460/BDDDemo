package com.stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.Base;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination extends Base {
	LoginPage loginP;
	HomePage homeP;
	
	
	@Before
	public static void browserSetup() throws IOException {
		prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\prop.properties");
		prop.load(fis);		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public static void teardown() {
		driver.quit();
	}

	@Given("user in login Page")
	public void user_in_login_page() {
		System.out.println("Already in login page");
	}

	@Then("verify the Logo")
	public void verify_the_logo() {
		loginP = new LoginPage();
		Boolean aResult = loginP.verifyLogo();
		Assert.assertTrue("Verifing the logo",aResult);
	}
	
	@When("enter username and password and loggedin")
	public void enter_username_and_password_and_loggedin() {
		loginP = new LoginPage();
		homeP = loginP.loginMethod();
		System.out.println("Home Page is entered");
	}



	
	@Then("verify Homepage")
	public void verify_homepage() {
		Boolean aResults = homeP.verifyHomePage();
		Assert.assertTrue("Verifing the Homepage",aResults);
	}




}
