package com.obsqura.TestNgSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sum extends Base{
	@Test
	public void sumOfNumbers() {
		int no1,no2,sumNo ;
		String s1,s2,total,actualValue,expectedValue;
		 no1=10;
		 no2=20;
		 sumNo= no1+no2;
		 s1=Integer.toString(no1);
		 s2=Integer.toString(no2);
		 total=Integer.toString(sumNo);
		 actualValue="Total A + B : "+sumNo;
		 driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys(s1);
		 driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys(s2);
		 driver.findElement(By.xpath("//button[@id='button-two']")).click();
		 expectedValue=driver.findElement(By.xpath("//div[@id='message-two']")).getText();
		 Assert.assertEquals(expectedValue, actualValue);
		
	}
	@Test
	
	public void clearSample() {
		WebElement enterMsgField=driver.findElement(By.id("single-input-field"));
		enterMsgField.sendKeys("Hello");
		enterMsgField.clear();
		WebElement showMsg= driver.findElement(By.xpath("//button[@id='button-two']"));
		showMsg.isEnabled();
		showMsg.isDisplayed();
		showMsg.isSelected();
	}
	
	@Test
	public void enterMsgVerify() {
		String inputMessage="Hello";
		String actualMessage,expectedMessage;
		WebElement enterMsgField=driver.findElement(By.id("single-input-field"));
		WebElement showMsgButton= driver.findElement(By.xpath("//button[@id='button-two']"));
		WebElement ShowMsgField=driver.findElement(By.xpath("//div[@id='message-one']"));
		boolean isEnterMsgFieldDisplayed=enterMsgField.isDisplayed();
		boolean isShowMsgButtonDisplayed=showMsgButton.isDisplayed();
		boolean isShowMsgButtonEnabled=showMsgButton.isEnabled();
		if(isEnterMsgFieldDisplayed && isShowMsgButtonDisplayed) {
			enterMsgField.sendKeys(inputMessage);
			if(isShowMsgButtonEnabled) {
				showMsgButton.click();
				actualMessage=ShowMsgField.getText();
				expectedMessage="Your Message : "+inputMessage;
				Assert.assertEquals(expectedMessage,actualMessage,"not equals");
			}
			Assert.assertTrue(isShowMsgButtonEnabled,"Button is not enabled");
		}
		Assert.assertTrue(isEnterMsgFieldDisplayed,"Message field not displayed");
		Assert.assertTrue(isShowMsgButtonDisplayed,"Button is not displayed");
		
	}
		
	

}
