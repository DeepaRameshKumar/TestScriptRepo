package com.amazon.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICITE_WAIT =60;
	
	public void scrollIntoView(WebElement element,WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}
	
	public void switchWindow(WebDriver driver) {
		
		
	     for (String Child_Window : driver.getWindowHandles())  
	     {  
	     driver.switchTo().window(Child_Window);  
		
	     }
	}
	
}
