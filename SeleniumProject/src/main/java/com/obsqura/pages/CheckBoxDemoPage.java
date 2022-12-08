package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemoPage {
	public WebDriver driver;
	By checkbox = By.xpath("//input[@id='gridCheck']");
	By showMsgField = By.xpath("//div[@id='message-one']");

	By checkbox1 = By.xpath("//input[@id='check-box-one']");
	By checkbox2 = By.xpath("//input[@id='check-box-two']");

	By checkbox3 = By.xpath("//input[@id='check-box-three']");
	By checkbox4 = By.xpath("//input[@id='check-box-four']");
	By selectOrDeselectButton = By.xpath("//input[@id='button-two']");

	public CheckBoxDemoPage(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void checkBox() {

		boolean isChecked;
		String expectedMsg = "Success - Check box is checked", shownMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.findElement(checkbox).click();
		isChecked = driver.findElement(checkbox).isSelected();
		shownMsg = driver.findElement(showMsgField).getText();
		if (isChecked) {
			Assert.assertEquals(expectedMsg, shownMsg, "not equals the msg");
		}
		Assert.assertTrue(isChecked, "Checkbox is not checked");
	}

	@Test
	public void checkBoxes() {

		boolean isChecked1, isChecked2;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.findElement(checkbox1).click();
		isChecked1 = driver.findElement(checkbox1).isSelected();
		driver.findElement(checkbox2).click();
		isChecked2 = driver.findElement(checkbox1).isSelected();
		if (isChecked1) {
			Assert.assertTrue(isChecked1, "Checkbox1 is not checked");
		}
		if (isChecked2) {
			Assert.assertTrue(isChecked2, "Checkbox2 is not checked");
		}
	}

	@Test
	public void checkBoxesAllSelectOrUnSelect() {

		boolean isChecked1, isChecked2, isChecked3, isChecked4;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.findElement(checkbox1).click();
		isChecked1 = driver.findElement(checkbox1).isSelected();
		driver.findElement(checkbox2).click();
		isChecked2 = driver.findElement(checkbox2).isSelected();
		driver.findElement(checkbox3).click();
		isChecked3 = driver.findElement(checkbox3).isSelected();
		driver.findElement(checkbox4).click();
		isChecked4 = driver.findElement(checkbox3).isSelected();
		if ((isChecked1 == true) && (isChecked2 == true) && (isChecked3 == true) && (isChecked4 == true)) {
			driver.findElement(selectOrDeselectButton).click();
			isChecked1 = false;
			isChecked2 = false;
			isChecked3 = false;
			isChecked4 = false;
			Assert.assertFalse(isChecked1, "Checkbox1 is  checked");
			Assert.assertFalse(isChecked2, "Checkbox2 is  checked");
			Assert.assertFalse(isChecked3, "Checkbox3 is  checked");
			Assert.assertFalse(isChecked4, "Checkbox4 is  checked");
		}

	}
}
