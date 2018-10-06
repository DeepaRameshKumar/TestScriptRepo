package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class AddProductToCartTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	//first constructor will be called then before method
	public AddProductToCartTest() {
		
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws InterruptedException 
	{
		/*initialization(); is a static method in test base class which is extended by AddProductToCartTest so can be directly called 
		Define static methods in the following scenarios only:

        If you are writing utility classes and they are not supposed to be changed.
        If the method is not using any instance variable.
        If any operation is not dependent on instance creation.
        If there is some code that can easily be shared by all the instance methods, extract that code into a static method.
        If you are sure that the definition of the method will never be changed or overridden. As static methods can not be overridden. */
		initialization();	
	    homePage = new HomePage();
	    
	    //login action---
	    homePage.openDropdown();
		//Thread.sleep(6000);
		
		//since openLoginPage is returning LoginPage object, store it in LoginPage
	    loginPage = homePage.openLoginPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	
	}
	
	@Test
	public void AddProductToCart() throws InterruptedException {
		
		homePage.selectCategory(prop.getProperty("categoryName"), prop.getProperty("subCategoryName"));
		
		homePage.search(prop.getProperty("searchProduct"));
		
		homePage.scrollNOpenProd(prop.getProperty("openProduct"));
		
	     //for new tab no need to create separate page can continue in same page
	     
		homePage.addToCart();
		
		
	}
	
	@AfterMethod()
	public void tearDown() {
		
		driver.quit();
	}
	 

}
