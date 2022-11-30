package com.obsqura.TestNgSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru extends Base { /*
									 * Launch the browser and up the url(http://demo.guru99.com/test/ajax.html)
									 * Verify all the radiobuttons are deselected by default 
									 * Click the radio button‘No’ , it should be locate by ‘name’ 
									 * Close the browser
									 */
	@Test
	public void radioButtonDeSelected() {
		WebElement radioYes,radioNo,buttonCheck,showMsg;
		String actualMsg,expectedMsg;
		boolean isYesSelected,isNoSelected;
		radioYes=driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		radioNo=driver.findElement(By.xpath("(//input[@name='name'])[2]"));
		buttonCheck=driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		showMsg=driver.findElement(By.xpath("//p[@class='radiobutton']"));
		isYesSelected=radioYes.isSelected();
		isNoSelected=radioNo.isSelected();
		if((isYesSelected==false)&&(isNoSelected==false)) {
			buttonCheck.click();
			expectedMsg="Radio button is Not checked";
			actualMsg=showMsg.getText();
			Assert.assertEquals(expectedMsg,actualMsg,"text not matching");
		}
		Assert.assertFalse(isYesSelected,"yes button  selected");
		Assert.assertFalse(isNoSelected,"no button selected");
	}
	
	@Test
	public void radioButtonNoSelected() {
		WebElement radioNo,buttonCheck,showMsg;
		String actualMsg,expectedMsg;
		boolean isNoSelected;
		radioNo=driver.findElement(By.xpath("(//input[@name='name'])[2]"));
		buttonCheck=driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		showMsg=driver.findElement(By.xpath("//p[@class='radiobutton']"));
		radioNo.click();
		isNoSelected=radioNo.isSelected();
		if(isNoSelected==true) {
			buttonCheck.click();
			expectedMsg="Radio button is checked and it's value is No";
			actualMsg=showMsg.getText();
			Assert.assertEquals(expectedMsg,actualMsg,"text not matching");
		}
		
		Assert.assertTrue(isNoSelected,"no button not selected");
	}

}
