package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.WishListPage;

public class IdeaSortTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	WishListPage wishListPage;
	
	
	public IdeaSortTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		homePage =new HomePage();
		homePage.openDropdown();
		loginPage = new LoginPage();
		loginPage = homePage.openLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		wishListPage = homePage.openWishList();
	Thread.sleep(3000);
		wishListPage.addIdea(prop.getProperty("ideaName"));
		
	}
	
	@Test()
	public void addIdeaDescription() throws InterruptedException {
		
		wishListPage.addIdeaDetails(prop.getProperty("ideaName"), prop.getProperty("comment"), prop.getProperty("priority"), prop.getProperty("quantity"), prop.getProperty("has"));
	//	Thread.sleep(3000);
		wishListPage.giveFilterAndSortIdea(prop.getProperty("sort"));
		Assert.assertTrue(wishListPage.verifyIfIdeaPresent(prop.getProperty("ideaName")));
	}
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	

}
