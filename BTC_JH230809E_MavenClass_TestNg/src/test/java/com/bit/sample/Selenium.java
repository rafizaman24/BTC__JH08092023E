package com.bit.sample;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

public class Selenium {
 
	WebDriver dr;
	
	public void seleniumMethod() {
		dr.close();
		 WebElement element= dr.findElement(By.id(""));
		 element.clear();
		 element.click();
		 element.findElement(By.id(""));
		 element.findElements(By.id(""));
		 element.getAttribute("type/id/class");
		 element.getCssValue("font size/anything");
		 element.getLocation().getX();
		 //this method helps to get x and y againts an element
		 element.getTagName();
		 element.getText();
		int x= Integer.parseInt("1");
		//Double.parseDouble("3.5");
		element.isDisplayed();
		element.isEnabled();
		element.isSelected();
		element.sendKeys("");
		element.sendKeys(Keys.ENTER);
		element.submit();
		// submit method will click without click method
		
       List<WebElement> elements= dr.findElements(By.id(" "));
       dr.get("url"); 
       dr.getCurrentUrl();
       dr.getPageSource().contains("shahidul");
       dr.getTitle();
       String pwin= dr.getWindowHandle();
       //getwindowHandle grabs parent window
      Set<String> cwin= dr.getWindowHandles();
      //getwindowHandle returns all windows
     Options opt= dr.manage();
     // manage returns options
    Navigation nav= dr.navigate();
    dr.quit();
   TargetLocator tarl= dr.switchTo();
   
   
     
	}
 
}
