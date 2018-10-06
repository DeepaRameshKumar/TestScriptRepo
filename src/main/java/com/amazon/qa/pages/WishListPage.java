package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class WishListPage extends TestBase {

	
	@FindBy(id = "createList")
	WebElement createNewListBtn;
	
	@FindBy(xpath = "//input[@class= \"a-button-input a-declarative\" and @type = \"submit\" and @aria-labelledby = \"WLNEW_privacy_public-announce\"]")
	WebElement publicBtn;
	
	@FindBy(id = "WLNEW_list_persistence")
	WebElement checkBox;
	
	@FindBy(id = "WLNEW_list_name")
	WebElement wishListNameField;
	
	@FindBy(xpath="//*[@id=\"a-popover-content-2\"]/form/div[2]/span[3]/span/span/input")
	WebElement createListBtn;
	
	@FindBy(xpath = "//a[text()=\"+Add Idea to List\"]")
	WebElement addIdeaBtn;
	
	@FindBy(id = "wfaTextInput")
	WebElement addIdeaField;
	
	@FindBy (id = "wfa-note-add-button")
	WebElement addToListBtn;
	
	@FindBy(id = "WLNOTES_Comment")
	WebElement commentTextBox;
	
	@FindBy(xpath="//*[@id=\"cqpPage\"]/div[1]/div[2]/div/div[2]/div[2]/div[1]/span/span/span/span")
	WebElement priorityDropDown;
	
	@FindBy(id="WLNOTES_Requested")
	WebElement quantityField;
	
	@FindBy(id="WLNOTES_Purchased")
	WebElement hasField;
	
	@FindBy(xpath="//input[@aria-labelledby='WLNOTES_save-announce']")
	WebElement saveBtn;
	
	@FindBy(xpath="//span[text()='Filter & Sort']")
	WebElement FilterandSortBtn;
	
	public WishListPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void openCreatelistPopup() {
		
		createNewListBtn.click();
	}
	
    public void selectPublic() {
		
    	publicBtn.click();
	}
	
 public void selectKeepPurchasingCheckbox() {
		
	 checkBox.click();
	}
 
 public void enterWishListName(String wishListName) {
	 
	 wishListNameField.clear();
	 wishListNameField.sendKeys(wishListName);
	}
 
 public void createList() {
		
	 createListBtn.click();
	}
 
 public void addIdea(String idea) throws InterruptedException {
	 
	 addIdeaBtn.click();
	 //Thread.sleep(5000);
	 addIdeaField.sendKeys(idea);
	 addToListBtn.click();
 }
 
 public void addIdeaDetails(String idea, String comment,String priority,String quantity,String has) throws InterruptedException {
	 
	 driver.findElement(By.xpath("//span[text()=\'"+idea+"']/parent::div/parent::h3/parent::div//following-sibling::span[@data-action='reg-dispatch-modal']/a")).click();
	Thread.sleep(3000);
	 commentTextBox.sendKeys(comment);
	 priorityDropDown.click();
	 driver.findElement(By.xpath("//li/a[.='"+priority+"']")).click();
	 quantityField.sendKeys(quantity);
	 hasField.sendKeys(has);
	 saveBtn.click();
	 
 }
 
 public HomePage searchForProducts(String idea) {
	 
	 driver.findElement(By.xpath("//span[text()='"+idea+"']/parent::div/parent::h3/parent::div/parent::div/parent::div/parent::div//following-sibling::div[@class='a-fixed-right-grid-col dateAddedText a-col-right']//a")).click();
	 return new HomePage();
	 
 }
 
 public void giveFilterAndSortIdea(String sort) throws InterruptedException {
	 Thread.sleep(5000);
	 FilterandSortBtn.click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//span[text()='"+sort+"']")).click();
 }
 
 public boolean verifyIfIdeaPresent(String idea) {
	 
	 return driver.findElement(By.xpath("//span[text()='"+idea+"']")).isDisplayed();
 }

 
}
