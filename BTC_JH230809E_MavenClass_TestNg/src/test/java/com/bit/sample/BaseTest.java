package com.bit.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {
	
	
	WebDriver dr;
	
	@Test
	public void openBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads"
				+ "\\chromedriver_win32_111\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("http://www.target.com");
		
		dr.findElement(By.id("..")).click();
		
		dr.manage().window().setSize(new Dimension(1200,900));
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		closeBrowser();
	}
	
	@Test
	public void openBrowser2() throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads"
				+ "\\chromedriver_win32_111\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://www.w3schools.com");
		dr.findElement(By.id("..")).click();
		
		
		dr.manage().window().setSize(new Dimension(1200,900));
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		closeBrowser();
	}
	
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(5000);
		dr.quit();
	}
	
	
	//String browser = "chrome";
	
	@Parameters({"browser"})
	@Test(groups = "smoke")
	public void passParameter(String arg) {
		//java will automatically pick the argument value from the parameter
		if(arg.equals("firefox")) {
			System.out.println("Firefox browser opened");
		}
		else if(arg.equals("chrome")) {
			System.out.println("Chrome browser opened");
			
		}else if(arg.equals("ie")) {
			System.out.println("IE browser opened");
			
		}else {
			System.out.println("No browser match found");
		}
	}
	
	@Test(groups = "intigration")
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(groups = {"intigration", "smoke"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups = "intigration")
	public void test3() {
		System.out.println("Test3");
	}
	

}
