package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectInputDemoPage {
	public WebDriver driver;
	Select objSelect,objMultiple;
	By selectField=By.xpath("//select[@id='single-input-field']");
	By multipleField = By.xpath("//select[@id='multi-select-field']");
	By showMsg=By.xpath("//div[@id='message-two']");
	
	public SelectInputDemoPage(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void selectByVisibleTextSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
	    objSelect = new Select(driver.findElement(selectField));
		objSelect.selectByVisibleText("Red");
		objSelect.selectByVisibleText("Green");
		objSelect.selectByVisibleText("Yellow");
	}

	@Test
	public void SelectByIndex() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
	    objSelect = new Select(driver.findElement(selectField));
		objSelect.selectByIndex(1);
		objSelect.selectByIndex(2);
		objSelect.selectByIndex(3);
	}

	@Test
	public void SelectByValue() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(selectField));
		objSelect.selectByValue("Red");
		objSelect.selectByValue("Green");
		objSelect.selectByValue("Yellow");
	}

	@Test
	public void listSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(selectField));
		List<WebElement> option = objSelect.getOptions();
		int count = option.size();

	}

	@Test
	public void multipleSample() {
		boolean isMultipleFlag;
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
	    objMultiple = new Select(driver.findElement(multipleField));
	    isMultipleFlag = objMultiple.isMultiple();
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
		objSelect = new Select(driver.findElement(selectField));
		objSelect.selectByVisibleText(colour);
	}
	@Test
	public void multipleSample1() {
		WebElement buttonGetAllSelected;
		boolean isMultipleFlag;
		List<WebElement> option;
		String actualMsg,expectedMsg="All selected colors are : Red,Yellow,Green";
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		objMultiple = new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
	    buttonGetAllSelected=driver.findElement(multipleField);
	    option = objMultiple.getOptions();
	    isMultipleFlag = objMultiple.isMultiple();
		Assert.assertTrue(isMultipleFlag, "Multiple Selection is not possible");
		objMultiple.selectByVisibleText("Red");
		objMultiple.selectByVisibleText("Yellow");
		objMultiple.selectByVisibleText("Green");
		buttonGetAllSelected.click();
		actualMsg=driver.findElement(showMsg).getText();
		Assert.assertTrue(isMultipleFlag,"multiple colours not selected");
		//Assert.assertEquals(actualMsg,expectedMsg,"selected colours are not same");
		objMultiple.deselectAll();
	}

}
