package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base;

public class SearchResultsPage extends Base{
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell'][2]/div[text()='0038']")
	WebElement verifyResults;
	
	public SearchResultsPage() {
		  PageFactory.initElements(driver, this);
	  }
	
	public boolean verifyresultSet() {
		return verifyResults.isDisplayed();
	}
	
	
	
}
