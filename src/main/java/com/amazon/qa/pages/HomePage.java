package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	Actions act = new Actions(driver);
	TestUtil testUtil = new TestUtil();
	
	@FindBy(id="nav-link-yourAccount")
	WebElement startDropdown;
	
     @FindBy(xpath="//span[contains(text(), 'Sign in') and @class=\"nav-action-inner\"]")
    WebElement signIn;

     @FindBy(id ="nav-link-shopall")
     WebElement categoryDropDown;
     
     @FindBy(id = "nav-link-wishlist")
     WebElement wishListBtn;
     
     @FindBy(xpath = "//span[@id='s-result-count']/span/span")
     WebElement ideaSearchName;
     
     @FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[2]")
     WebElement todayDealBtn;
     
     @FindBy(xpath = "//span[@data-a-class='sortOrderDropdown']//i")
     WebElement sortDropDown;
     
     @FindBy(id ="twotabsearchtextbox")
 	WebElement searchField;
 	
 	@FindBy(xpath = "//input[@value= 'Go']")
 	WebElement goBtn;
 	
 	@FindBy(id = "add-to-cart-button")
 	WebElement addToCartBtn;
     
public HomePage() {
	
	//following will initialize the web elements and this means the current class object
	PageFactory.initElements(driver, this);
}

public void openDropdown() {
	
	act.moveToElement(startDropdown).build().perform();
	
}


public LoginPage openLoginPage() throws InterruptedException {
	
	Thread.sleep(5000);
	signIn.click();
	return new LoginPage();
}

public void selectCategory(String categoryName, String subCategoryName) throws InterruptedException {
	
	Thread.sleep(5000);
	act.moveToElement(categoryDropDown).build().perform();
	Thread.sleep(5000);
	WebElement category = driver.findElement(By.xpath("//span[text()='"+categoryName+"']"));
	Thread.sleep(5000);
	act.moveToElement(category).build().perform();
	driver.findElement(By.xpath("//span[text()= '"+subCategoryName+"']")).click();
	
	
}

	public WishListPage openWishList() {
		
		wishListBtn.click();
		return new WishListPage();
	}
	
	public String verifyIdeaSearchName() {
		
		return ideaSearchName.getText();
	}

	public void openDeals() {
		
		todayDealBtn.click();
	}
	
	public void search(String searchProduct) {
		
		searchField.sendKeys(searchProduct);
		goBtn.click();
		
		
	}
	
	public void scrollNOpenProd(String openProduct) throws InterruptedException {
		
		WebElement product = driver .findElement(By.xpath("//img[@alt=\'"+openProduct+"']"));
	    try {
	    	if (product.isDisplayed()) {
		testUtil.scrollIntoView(product, driver);
		Thread.sleep(6000);
		product.click();}
		}
		catch (NoSuchElementException e) {
			throw new RuntimeException("This is where you put the message");
			}
	}
	
public void addToCart() {
		
		testUtil.switchWindow(driver);
		addToCartBtn.click();
	}

	public void filterAndSortProduct(String department, String price, String sort) throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement depCheckbox= driver.findElement(By.xpath("//div[@class='a-checkbox checkbox a-spacing-micro']/label/span[contains(text(),'"+department+"')]//preceding-sibling::input"));
		TestUtil util = new TestUtil();
		util.scrollIntoView(depCheckbox, driver);
		Thread.sleep(5000);
		depCheckbox.click();
		
		WebElement priceCheckbox =driver.findElement(By.xpath("//span[contains(text(),'"+price+"')]/preceding-sibling::input"));
		util.scrollIntoView(priceCheckbox, driver);
		Thread.sleep(5000);
		priceCheckbox.click();
		
		util.scrollIntoView(sortDropDown, driver);
		Thread.sleep(5000);
		sortDropDown.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'"+sort+"')]")).click();
	    
	
	}
	
}
