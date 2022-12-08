package com.obsqura.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SimpleFormDemoPage {

		public WebDriver driver;
		By singleInputField=By.xpath("//input[@id='single-input-field']");
		By showMessageButton=By.xpath("//button[@id='button-one']");
		By yourMessage=By.xpath("//div[@id='message-one']");
		
		By valueA=By.xpath("//input[@id='value-a']");
		By valueB=By.xpath("//input[@id='value-b']");
		By getTotalButton=By.xpath("//button[@id='button-two']");
		By msgTotal=By.xpath("//div[@id='message-two']");
		
		public SimpleFormDemoPage(WebDriver driver) {
			this.driver=driver;
		}

		

		public void verifyEnterMessageField() {
			String yourEnteredActualMsg,inputMsg="Obsqura";
			String expectedMsg="Your Message : "+inputMsg;
			driver.findElement(singleInputField).sendKeys("Obsqura");
			driver.findElement(showMessageButton).click();
			yourEnteredActualMsg=driver.findElement(yourMessage).getText();
			Assert.assertEquals(yourEnteredActualMsg, expectedMsg,"Msg not equal");
		}
		@Test
		public void twoInputFields() {
			 int no1=10,no2=20,sumNo ;
			 String s1,s2,actualValue,expectedValue;
			 sumNo= no1+no2;
			 s1=Integer.toString(no1);
			 s2=Integer.toString(no2);
			 actualValue="Total A + B : "+sumNo;
			 driver.findElement(valueA).sendKeys(s1);
			 driver.findElement(valueB).sendKeys(s2);
			 driver.findElement(getTotalButton).click();
			 expectedValue=driver.findElement(msgTotal).getText();
			 Assert.assertEquals(expectedValue, actualValue,"Msg not equal");
			
		}

}