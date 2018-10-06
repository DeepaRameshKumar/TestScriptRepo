package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//input[@type ='email']")
	WebElement emailId;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(xpath = "//input[@type ='password']")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement loginBtn;
	
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pwd) {
		
		emailId.sendKeys(un);
		continueBtn.click();
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	

}
