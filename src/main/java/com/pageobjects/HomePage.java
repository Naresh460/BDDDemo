package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base;

public class HomePage extends Base {

	@FindBy(xpath = "//h6[text()='PIM']")
	WebElement homePageverification;

	@FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
	WebElement employeeIdBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomePage() {
		return homePageverification.isDisplayed();
	}
}
