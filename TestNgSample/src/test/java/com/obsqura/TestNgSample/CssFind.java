package com.obsqura.TestNgSample;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

public class CssFind extends Base{
	@Test
	public void cssWrite() {
	Dimension buttonSize=driver.findElement(By.xpath("//button[@id='button-two']")).getSize();
	String shape=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("box-sizing");
	String colour= driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("color");
	String font= driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("color");
	String fontWeight=driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font-weight");
	}

}

/*url=https://selenium.obsqurazone.com/simple-form-demo.php
  1)verify the size,shape,color,font color,font weight of button get total*/