package com.amazon.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.WishListPage;

public class ProductSortTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	WishListPage wishListPage;
	
	
	public ProductSortTest() {
		
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
	
	@Test
	public void sortAndAddToCart() throws InterruptedException {
		
		homePage.openDeals();
		homePage.filterAndSortProduct(prop.getProperty("department"), prop.getProperty("price"), prop.getProperty("sort"));
		List<WebElement> filter = driver.findElements(By.xpath("//a[@class='a-link-normal summary']"));
		for(WebElement ele :filter) {
		  Assert.assertEquals(ele.getText(),prop.getProperty("department","department not found"));
		  Assert.assertEquals(ele.getText(),prop.getProperty("price","price not found"));
		
	}
	
}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
