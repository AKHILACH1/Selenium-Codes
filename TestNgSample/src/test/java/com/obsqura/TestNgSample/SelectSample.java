package com.obsqura.TestNgSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectSample extends Base {
	@Test
	public void selectByVisibleTextSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByVisibleText("Red");
		objSelect.selectByVisibleText("Green");
		objSelect.selectByVisibleText("Yellow");
	}

	@Test
	public void SelectByIndex() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByIndex(1);
		objSelect.selectByIndex(2);
		objSelect.selectByIndex(3);
	}

	@Test
	public void SelectByValue() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByValue("Red");
		objSelect.selectByValue("Green");
		objSelect.selectByValue("Yellow");
	}

	@Test
	public void listSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		List<WebElement> option = objSelect.getOptions();
		int count = option.size();

	}

	@Test
	public void multipleSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objMultiple = new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		boolean isMultipleFlag = objMultiple.isMultiple();
		Assert.assertTrue(isMultipleFlag, "Multiple Selection is not possible");
		objMultiple.selectByVisibleText("Red");
		objMultiple.selectByVisibleText("Yellow");
		objMultiple.selectByVisibleText("Green");
		objMultiple.deselectAll();
	}
	
	@Test
	public void selectByVisibleTextByAnyInput() {
		Select objSelect;
		String colour="Red";
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		objSelect = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByVisibleText(colour);
	}
	@Test
	public void multipleSample1() {
		Select objMultiple;
		WebElement buttonGetAllSelected,showMsg;
		boolean isMultipleFlag;
		List<WebElement> option;
		String actualMsg,expectedMsg="All selected colors are : Red,Yellow,Green";
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		objMultiple = new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
	    buttonGetAllSelected=driver.findElement(By.xpath("//button[@id='button-all']"));
		showMsg=driver.findElement(By.xpath("//div[@id='message-two']"));
	    option = objMultiple.getOptions();
	    isMultipleFlag = objMultiple.isMultiple();
		Assert.assertTrue(isMultipleFlag, "Multiple Selection is not possible");
		objMultiple.selectByVisibleText("Red");
		objMultiple.selectByVisibleText("Yellow");
		objMultiple.selectByVisibleText("Green");
		buttonGetAllSelected.click();
		actualMsg=showMsg.getText();
		Assert.assertEquals(actualMsg,expectedMsg,"selected colours are not same");
		objMultiple.deselectAll();
	}

}
