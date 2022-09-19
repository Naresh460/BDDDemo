package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base;

public class AddEmployee extends Base{
	
	
	
	@FindBy(name="firstName")
	WebElement fName;
	
	@FindBy(name="lastName")
	WebElement lName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	
	@FindBy(xpath="//label[text()='Employee Id']/parent::div/following-sibling::div/input")
	WebElement employeeID;
	
	public AddEmployee() {
		  PageFactory.initElements(driver, this);
	  }
	
	
	
	public void enterdetails(String fname, String lname, String EpId) {
		fName.sendKeys(fname);
		lName.sendKeys(lname);
		employeeID.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		employeeID.sendKeys(EpId);
	}
	

	public PersonalDetailsPage saveBtn() {
		saveBtn.click();
		return new PersonalDetailsPage();
	}

}
