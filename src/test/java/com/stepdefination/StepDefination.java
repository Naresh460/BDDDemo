package com.stepdefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {
	 
	   static  WebDriver driver;
	   
	@Before
	public static void before() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterStep
	public static void screeshot() throws IOException {
		 LocalDateTime myObj = LocalDateTime.now();
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"); 

		    String formattedDate = myObj.format(myFormatObj);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Projects\\BDDproject\\screenshots\\"+formattedDate+".png");
		FileUtils.copyFile(source, dest);
		
	}
	
	@Given("The Url to Browser")
	public void the_url_to_browser() {
	   
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	}
	
	
	@And ("Provided {string} and {string}")
	public void provided_and(String uname, String pword) {
	    driver.findElement(By.name("username")).sendKeys(uname);
	    driver.findElement(By.name("password")).sendKeys(pword);
	    driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']")).click();
	}

	@When("Appliaion is loaded verify the Homepage")
	public void appliaion_is_loaded_verify_the_homepage() {
	    Boolean expected =driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed();
	    Assert.assertTrue("Pass", expected);
	}

	@And("quit the browser")
	public void quit_the_browser() {
	    driver.quit();
	}
	
	@When("enter the keyword {string} in the search box")
	public void enter_the_keyword_in_the_search_box(String a) {
	   driver.findElement(By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input")).sendKeys(a);
	}

	@Then("click on search icon")
	public void click_on_search_icon() {
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@When("Click on add button")
	public void click_on_add_button() {
	    driver.findElement(By.xpath("//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
	}

	@Then("user in Add Employee form")
	public void user_in_add_employee_form() {
	   driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Add Employee']")).isDisplayed();
	}

	@Then("enter {string} as first name and {string} as last name")
	public void enter_naresh_as_first_name_and_as_last_name(String fname, String lname) {
	   driver.findElement(By.name("firstName")).sendKeys(fname);
	   driver.findElement(By.name("lastName")).sendKeys(lname);
	}

	@Then("click on save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Verify user added cconfirmation")
	public void verify_user_added_cconfirmation() {
	   driver.findElement(By.xpath("//h6[text()='Personal Details']")).isDisplayed();
	}

	


}
