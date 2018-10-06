package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	
	 LoginPage loginPage;
	 HomePage homePage;
	
	public LoginTest() {
		//to avoid null pointer exception use super which will call super class constructor because variable prop is user in initialization method and prop is initialized in testbase constructor
	super();
	}
	
	@BeforeMethod()
	public void setUp()  {
		
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		
	}
	
	@Test()
	public void loginTest() throws InterruptedException
	
	{
		homePage.openDropdown();
		//Thread.sleep(5000);
		
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS); 
	    //ElementNotInteractableException, added sleep
		loginPage = homePage.openLoginPage();
	
		//cannot make static reference to non static method when i used LoginPage instead of loginPage (LoginPage is a class loginPage is an object)
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod()
	public void tearDown() {
		
		driver.quit();
	}
	 

}
