package com.obsqura.TestNgSample;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CssFind extends Base{
	@Test
	public void cssWrite() {
	Dimension buttonSize=driver.findElement(By.xpath("//button[@id='button-two']")).getSize();
	String shape=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("box-sizing");
	String colour= driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("color");
	String font= driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font");
	String fontWeight=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font-weight");
	}
	
	@Test
	public void softAssert() {
		int expectedButtonHeight,actualButtonHeight,expectedButtonWidth,actualButtonWidth;
		String actualShape,expectedShape,expectedColor,actualColor,expectedFont,actualFont,expectedFontWeight,actualFontWeight; 
		 expectedButtonHeight = 38;
		 actualButtonHeight=driver.findElement(By.xpath("//button[@id='button-two']")).getSize().height;
		 expectedButtonWidth=94;
		 actualButtonWidth=driver.findElement(By.xpath("//button[@id='button-two']")).getSize().width;
		 actualShape="border-box";
		 expectedShape=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("box-sizing");
		 expectedColor="rgba(255, 255, 255, 1)";
		 actualColor=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("color");
		 expectedFont="16px / 24px \"Open Sans\", sans-serif";
		 actualFont=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font");
		 expectedFontWeight="400";
		 actualFontWeight=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font-weight");
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(expectedButtonHeight, actualButtonHeight);
		softAssert.assertEquals(expectedButtonWidth, actualButtonWidth);
		softAssert.assertEquals(expectedShape,actualShape);
		softAssert.assertEquals(expectedColor,actualColor);
		softAssert.assertEquals(expectedFont,actualFont);
		softAssert.assertEquals(expectedFontWeight,actualFontWeight);
		
		
		softAssert.assertAll();
}

}

/*url=https://selenium.obsqurazone.com/simple-form-demo.php
  1)verify the size,shape,color,font color,font weight of button get total*/