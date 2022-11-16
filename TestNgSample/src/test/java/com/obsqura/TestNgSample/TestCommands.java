package com.obsqura.TestNgSample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCommands extends Base{
@Test
	public void verifyUrl() {
		String expectedUrl="https://www.amazon.in/";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		}
@Test
	public void verifyTitle() {
	String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String title = driver.getTitle();
	Assert.assertEquals(expectedTitle , title);
	}
@Test
    public void verifyUrlAndTitle() {
		String expectedUrl="https://www.amazon.in/";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String title = driver.getTitle();
		Assert.assertEquals(expectedTitle , title);
		
	}
@Test
	public void softAssert() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String title = driver.getTitle();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(expectedTitle, title);
		String expectedUrl="https://www.amazon.in/";
		String actualUrl=driver.getCurrentUrl();
		softAssert.assertEquals(expectedUrl, actualUrl);
		softAssert.assertAll();
}
	}
