/**
 * 
 */
package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base;

/**
 * @author nbusireddy
 *
 */
public class LoginPage extends Base {
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pword;
	
	@FindBy(xpath="//div[@class='oxd-form-actions orangehrm-login-action']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='orangehrm-login-branding']")
	WebElement logo;
	
	
  public LoginPage() {
	  PageFactory.initElements(driver, this);
  }
  
   
  public HomePage loginMethod() {
	  uname.sendKeys(prop.getProperty("username"));
	  pword.sendKeys(prop.getProperty("password"));
	  loginBtn.click();
	  return new HomePage();
	  
  }
  
  public boolean verifyLogo() {
	 return logo.isDisplayed();
  }
  
  
  
}
