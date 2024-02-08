package com.bit.sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	
	/* command+shift+o to import all at once 
	 * 
	 * TestNg doc: https://testng.org/doc/documentation-main.html
	 * 
    @BeforeSuite: The annotated method will be run before all tests in this
 suite have run.
    @AfterSuite: The annotated method will be run after all tests in this suite 
 have run.
    @BeforeTest: The annotated method will be run before any test method 
 belonging to the classes inside the <test> tag is run.
    @AfterTest: The annotated method will be run after all the test methods 
belonging to the classes inside the <test> tag have run.
    @BeforeGroups: The list of groups that this configuration method will run 
before. This method is guaranteed to run shortly before the first test method 
that belongs to any of these groups is invoked.
    @AfterGroups: The list of groups that this configuration method will run
 after. This method is guaranteed to run shortly after the last test method
 that belongs to any of these groups is invoked.
    @BeforeClass: The annotated method will be run before the first test 
 method in the current class is invoked.
    @AfterClass: The annotated method will be run after all the test methods 
 in the current class have been run.
    @BeforeMethod: The annotated method will be run before each test method.
     @AfterMethod: The annotated method will be run after each test method.	
	 */


	
	@Test(groups = "smoke")
	public void test20() {
		System.out.println("Test 20");
	}

	@Test(groups = { "regression", "smoke" })
	public void test21() {
		System.out.println("Test 21");
	}

	@Test(groups = "regressioin")
	public void test22() {
		System.out.println("Test 22");
	}

	@Test(groups = "smoke")
	public void test23() {
		System.out.println("Test 23");
	}

	@BeforeSuite
	public void test1() {
		System.out.println("@BeforeSuite");
	}

	@AfterSuite
	public void test2() {
		System.out.println("@AfterSuite");
	}

	@BeforeTest
	public void test3() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void test4() {
		System.out.println("@AfterTest");
	}

	@BeforeGroups
	public void test5() {
		System.out.println("@BeforeGroups");
	}

	@AfterGroups
	public void test6() {
		System.out.println("@AfterGroups");
	}

	@BeforeClass
	public void test7() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public void test8() {
		System.out.println("@AfterClass");
	}

	@BeforeMethod
	public void test9() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void test10() {
		System.out.println("@AfterMethod");
	}

}
