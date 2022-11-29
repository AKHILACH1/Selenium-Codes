package com.obsqura.TestNgSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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
		int expectedButtonHeight= 38,actualButtonHeight,expectedButtonWidth=94,actualButtonWidth;
		String actualShape,expectedShape="border-box",expectedColor="rgba(255, 255, 255, 1)",
				actualColor,expectedFont="16px / 24px \"Open Sans\", sans-serif",
				actualFont,expectedFontWeight="400",actualFontWeight; 
		 
		 actualButtonHeight=driver.findElement(By.xpath("//button[@id='button-two']")).getSize().height;
		 actualButtonWidth=driver.findElement(By.xpath("//button[@id='button-two']")).getSize().width;
		 actualShape=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("box-sizing");
		 actualColor=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("color");
		 actualFont=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font");
		 actualFontWeight=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font-weight");
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(expectedButtonHeight, actualButtonHeight);
		softAssert.assertEquals(expectedButtonWidth, actualButtonWidth);
		softAssert.assertEquals(expectedShape,actualShape);
		softAssert.assertEquals(expectedColor,actualColor);
		softAssert.assertEquals(expectedFont,actualFont);
		softAssert.assertEquals(expectedFontWeight,actualFontWeight);
		
		Point buttonLocation=driver.findElement(By.xpath("//button[@id='button-one']")).getLocation();
		int x=buttonLocation.getX();
		int y=buttonLocation.getY();
		softAssert.assertAll();
}
	@Test
	
	public void findelementsSample() {
		
		List<WebElement>menuList=driver.findElements(By.xpath("//ul[@class='list-group list-group-flush']//li"));
		menuList.get(2).click();
	}

}

/*url=https://selenium.obsqurazone.com/simple-form-demo.php
  1)verify the size,shape,color,font color,font weight of button get total*/