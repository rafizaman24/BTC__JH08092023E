package com.bit.sample;


import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class SeleniumAdvance {
	
	WebDriver dr;
	WebElement ele;
	List<WebElement> eles;
	Set<String> cwin;
	Options option;
	Navigation navigate;
	Point point;
	TargetLocator locate;
	Dimension dimension;
	Alert alert;

	// title / url / bookmarks etc from header
	// anything from the body section
	public void test1() {
		// driver methods
		dr.close();
		dr.quit();
		ele = dr.findElement(By.id(""));
		eles = dr.findElements(By.id(""));
		dr.get("");
		dr.getCurrentUrl();
		String texts = dr.getPageSource();
		dr.getTitle();
		String presentWin = dr.getWindowHandle();
		cwin = dr.getWindowHandles();
		//whichever window opens 1st is the parent
		locate = dr.switchTo();
		//https://bittechusa.atlassian.net/wiki/spaces/BA/pages/8486932/Multi+Window+Handle
		
		option = dr.manage();

		// webelement methods
		ele.clear();
		ele.click();
		ele.findElement(By.id(""));
		ele.getCssValue("border");
		ele.getAttribute("id");
		
		/*ele.getScreenshotAs(OutputType.FILE);
		File sf=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sf, new File("/Users/shahidulislam/Desktop/other/shot1.png"),true);
		File f=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\Users\\bittech\\Desktop\\screen\\shot1.png"), true);     
		*/
		dimension = ele.getSize();
		ele.getTagName();
		ele.getText();
		ele.isDisplayed();
		ele.isEnabled();
		ele.isSelected();
		ele.submit();
		ele.sendKeys("text");

		// Options methods
		option.getCookies();
		option.deleteAllCookies();// any cookie related methods always come from Otions 
		
		//Specifies the amount of time the DRIVER should wait when searching 
		//for an element if it is not immediately present. 
		option.timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//Sets the amount of time to wait for a page load to complete before throwing an error.
		//If the timeout is negative, page loads can be indefinite.
		option.timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		option.timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		option.window().maximize();
		
		// navigates methods
		navigate.back();
		navigate.forward();
		navigate.refresh();
		navigate.to("url");// vs dr.get()

		navigate = dr.navigate();
		dr.navigate().to("http://www.target.com");

		// point methods
		point = ele.getLocation();
		point.getX();
		point.getY();

		// targetlocator
		alert = locate.alert();
		alert.accept();// clcick ok button
		alert.dismiss();
		alert.sendKeys("");
		alert.getText();
		locate.defaultContent();// to go back main window
		
		locate.frame(0);
		locate.frame("");
		locate.frame(ele);
		locate.activeElement();
		locate.parentFrame();
		locate.window("");

		// Dimention methods
		dimension.getHeight();
		dimension.getWidth();

	}

	public void actionMethods() {
		//mouse N keyboard related task = Actions and Keys class are used
		Actions a = new Actions(dr);
		a.click(ele);
		a.clickAndHold(ele);
		a.contextClick().perform();// right click
		a.doubleClick(ele);
		a.dragAndDrop(ele, ele);
		a.dragAndDropBy(ele, 10, 200).build().perform();
		;
		a.keyDown(Keys.ARROW_DOWN);
		a.keyUp(Keys.CONTROL );
		a.moveToElement(ele).build().perform();
		;// hover over
		a.pause(20);
		a.release();
		a.sendKeys("");
		a.build().perform();

	}

	public void selectMethods() {
		Select s = new Select(ele);
		s.selectByIndex(0);
		s.selectByValue("");
		s.selectByVisibleText("");
		s.getOptions().size();
		s.getFirstSelectedOption();
		s.deselectByValue("");
		s.deselectAll();
		s.deselectByIndex(8);

		// to handle window/desktop based application
		// need third party API like Sikulli, AutoIT and Robot API
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript(" window.scrollTo(0, 1000)");
		js.executeScript("document.getElementById('email').value=\"sdfgh\";");
		js.executeScript("arguments[0].click()", dr.findElement(By.id("")));
	}
	
	

	public void screenShot() {
		int i = (int) Math.random();
		File f = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(f, new File(
					"/Users/bittechconsulting/eclipse-workspace/TestNGProject200926M/screenShoot/shot" + i + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		handleIframe(dr.findElements(By.tagName("iframe")), "class", "classValue");
	}

	public void handleIframe(List<WebElement> frames, String attName, String attValue) {
		for (WebElement frame : frames) {
			String v = frame.getAttribute(attName);
			if (v.equals(attValue)) {
				dr.switchTo().frame(attValue);
				// action
			}
		}

	}

	public void handleCookie(String cookieName) {
		Set<Cookie> cookies = dr.manage().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				dr.manage().deleteCookieNamed(cookieName);
			}
		}
	}  	
	

}
