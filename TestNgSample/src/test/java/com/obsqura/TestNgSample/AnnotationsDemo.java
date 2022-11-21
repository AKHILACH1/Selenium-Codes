package com.obsqura.TestNgSample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	@Test
	public void testCase2() {
		System.out.println("Executed Test Case 2");
	}
	
	@Test
	public void testCase1() {
		System.out.println("Executed Test Case 1");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Executed Before Every Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Executed After Every Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Executed Before Class Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Executed After Class Method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Executed Before Test Method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Executed After Test Method");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Executed Before Test Suite Method");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Executed After Test Suite Method");
	}


}
