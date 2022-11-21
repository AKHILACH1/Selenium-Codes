package com.obsqura.TestNgSample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sum extends Base{
	@Test
	public void sum() {
		int no1,no2,sum ;
		String s1,s2,total,actualValue,expectedValue;
		 no1=10;
		 no2=20;
		 sum= no1+no2;
		 s1=Integer.toString(no1);
		 s2=Integer.toString(no2);
		 total=Integer.toString(sum);
		 actualValue="Total A + B : "+sum;
		 driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys(s1);
		 driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys(s2);
		 driver.findElement(By.xpath("//button[@id='button-two']")).click();
		 expectedValue=driver.findElement(By.xpath("//div[@id='message-two']")).getText();
		 Assert.assertEquals(expectedValue, actualValue);
		
	}
	

}
