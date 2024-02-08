package com.bit.sample;


	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.io.Files;
import com.thoughtworks.selenium.Wait;

	public class Selenium2 {
		WebDriver dr;
		 Actions ac= new Actions(dr);
		WebElement ele;
	 public  void multipolWindowHandle(){ 
	  String pwin = dr.getWindowHandle();
	 
	  ac.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
	  sendKeys(Keys.ENTER).build().perform();
	 Set<String>  cwin =dr.getWindowHandles();
	 for (String win:cwin){
		 if (!win.equals(pwin)) {
			 dr.switchTo().window(win);
			 
		 }
		
	 
	 
	 dr.switchTo().defaultContent();
	 // DefaultContent take back to parent window
	 }

	}
	 public void mouseRelatedMethod() { 
		 ac.click().build().perform();
		 // all mouseRelatedMethod methods will be build and perform method
		 ac.clickAndHold();
		 ac.contextClick();
		 ac.doubleClick();
		 ac.dragAndDrop(ele, ele);
		 ac.dragAndDropBy(ele, 100, 50);
		 ac.keyUp(Keys.ARROW_UP);
		 ac.moveToElement(ele);
		 //moveToElement is for hover over
		 ac.pause(2000).release();
		 
		 
	 }
	 public void iframeHandling () {
		 dr.switchTo().frame("Demo.");
		 ac.dragAndDrop(ele, ele);
		 // if any element under iframe tag then first need to
	//switch driver to the frame then action
		 
	 }
	 public void cookieRelated(String cookieName) {
		 //cookieRelated is undeer manage
		 Set<Cookie> allCookie=dr.manage().getCookies();
		 for ( Cookie oneCookie:allCookie) {
			 if (oneCookie.getName().equals(cookieName)) {
				 dr.manage().deleteCookie(oneCookie);
				 break;
			 }
			 
		 }
	 

		 public void alertMethod() {
			 // javaScript base window popup
			Alert a= dr.switchTo().alert();
		 a.accept();//click OK button
		 a.dismiss();// click cancel button
		 a.getText();//get the text from alert box
		 a.sendKeys("jknh");//type on textbox
	 //if it is web base popup then we will click on cross button to handle
		 //if it is window base popup then selenium can't handle it.in order 
		 //to handle that we need third party api like sikulli,autoIT
		 //and robot framework
	 }
		 public void waitForElement(WebElement ele) {
			 dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// explicit for particular element and it will wait based on the logic
			 WebDriverWait wait =new WebDriverWait(dr, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			 
		 }
	 
	

		 File f1;
			FileInputStream fi;

			public void screenShot() throws IOException {
				File f = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
				Files.copy(f, new File("Users\\User\\Desktop\\BTC_OnlineClass"
						+ "\\TestNgProject_Online\\MavenClass_OnlineBatch\\screenShot"));
				try {
					dr.findElement(By.xpath("XPathOf"));

					f1 = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
					Files.copy(f1, new File("Users\\User\\Desktop\\BTC_OnlineClass"
							+ "\\TestNgProject_Online\\MavenClass_OnlineBatch\\screenShot"));

				} catch (NoSuchElementException e) {
					System.out.println("element not found");
				} catch (FileNotFoundException f1) {
					System.out.println("file not found");
				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				} finally {
					// finally block used to make the connection or to make object free
					// exception is a kind of error which can be handled by developer
					// Exception two kinds: compile time and run time
					// when compiler want but it happen in a run time it's called compile time
					// exception
					// only compile time exception can be handled using try catch block and throw
					// and throws clause
					// the way try catch block works keep try pass, catch block will not be executed
					// if try block fail, catch block will be executed. in both cases finally block
					// will be executed
					// some example of some run time exception: array out of boundary exception,
					// arithmetic exception,
					// null point exception, stack overflow exception.
					// other than this there could be compile time exception
					// throws clause can handle multiple exceptions and it goes next to method sign
					// throw clause can handle one exception and it goes last line of exception

					if (fi != null) {
						fi.close();
					}

				}

			}

			public WebElement fluentWait(WebElement element) {

				// Create a FluentWait object with a timeout of 30 seconds
				Wait<WebDriver> wait = new FluentWait<>(dr).withTimeout(Duration.ofSeconds(30))
						.pollingEvery(Duration.ofSeconds(2)) // Check the condition every 2 seconds
						.ignoring(Exception.class); // Ignore exceptions such as NoSuchElementException

				// Define the condition to wait for (in this case, the presence of an element
				// with id="some-element")
				WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {

					public WebElement apply(WebDriver dr) {
						return element;
					}
				});

				return element;

_

		}
}
