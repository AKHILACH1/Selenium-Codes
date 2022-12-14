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
		System.out.println("Executed Before  Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Executed After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Executed Before Class ");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Executed After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Executed Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Executed After Test ");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Executed Before Test Suite ");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Executed After Test Suite");
	}


}
