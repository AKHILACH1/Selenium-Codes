package com.obsqura.TestNgSample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicCommandsObsqura extends Base{
	@Test
	public void singleInputFieldVerification() {
		String inputMessage="Hello";
		String actualMessage,expectedMessage;
		driver.findElement(By.id("single-input-field")).sendKeys(inputMessage);
		driver.findElement(By.id("button-one")).click();
		actualMessage=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		expectedMessage="Your Message : "+inputMessage;
		Assert.assertEquals(expectedMessage, actualMessage,"not equals");
		
		
	}

}
