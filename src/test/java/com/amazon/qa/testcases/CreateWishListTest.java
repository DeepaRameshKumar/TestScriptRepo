package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.WishListPage;

public class CreateWishListTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	WishListPage wishListPage;
	
	
	public CreateWishListTest() {
		
		super();
	}

	@BeforeMethod()
	public void setUp() throws InterruptedException{
		
		initialization();	
		homePage =new HomePage();
		homePage.openDropdown();
		loginPage = new LoginPage();
		loginPage = homePage.openLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test()
	public void createWishList() throws InterruptedException {
		
		wishListPage = homePage.openWishList();
		wishListPage.openCreatelistPopup();
		//Thread.sleep(5000);
		wishListPage.enterWishListName(prop.getProperty("wishListName"));
		wishListPage.selectPublic();
		wishListPage.selectKeepPurchasingCheckbox();
		//Thread.sleep(6000);
		wishListPage.createList();
		//Thread.sleep(6000);
		
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
