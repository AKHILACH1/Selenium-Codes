package com.obsqura.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonsDemoPage {
	public WebDriver driver;
	By radioButtonMale = By.xpath("//input[@id='inlineRadio1']");
	By buttonselect = By.xpath("//button[@id='button-one']");
	By showMsg = By.xpath("//div[@id='message-one']");
	By radioButtonFemale = By.xpath("//input[@id='inlineRadio2']");
	By radButtonFemale = By.xpath("//input[@id='inlineRadio21']");
	By buttonGetResult = By.xpath("//button[@id='button-two']");
	By buttonageGroup23 = By.xpath("//input[@id='inlineRadio23']");
	By showMsg1 = By.xpath("//div[@id='message-two']");
	By radioButtonMale1 = By.xpath("//input[@id='inlineRadio11']");
	By buttonageGroup22 = By.xpath("//input[@id='inlineRadio22']");

	public RadioButtonsDemoPage(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void checkRadioButtonMale() {
		boolean isSelected;
		String inputMessage = "Radio button 'Male' is checked", expectedMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(radioButtonMale).click();
		isSelected = driver.findElement(radioButtonMale).isSelected();
		if (isSelected) {
			driver.findElement(buttonselect).click();
			expectedMsg = driver.findElement(showMsg).getText();
			Assert.assertEquals(expectedMsg, inputMessage, "Not matching the message");
		}
		assertTrue(isSelected, "Radio button 'Male' is not checked");
	}

	@Test
	public void checkRadioButtonFemale() {
		boolean isSelected;
		String inputMessage = "Radio button 'Female' is checked", expectedMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(radioButtonFemale).click();
		isSelected = driver.findElement(radioButtonFemale).isSelected();
		if (isSelected) {
			driver.findElement(buttonselect).click();
			expectedMsg = driver.findElement(showMsg).getText();
			Assert.assertEquals(expectedMsg, inputMessage);
		}
		assertTrue(isSelected, "Radio button 'Female' is not checked");
	}

	@Test
	public void checkRadioButtonNone() {

		boolean isMaleSelected, isFemaleSelected;
		String inputMessage = "Radio button is Not checked", expectedMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		isMaleSelected = driver.findElement(radioButtonMale).isSelected();
		isFemaleSelected = driver.findElement(radioButtonFemale).isSelected();
		if ((isMaleSelected == false) && (isFemaleSelected == false)) {
			driver.findElement(buttonselect).click();
			expectedMsg = driver.findElement(showMsg).getText();
			Assert.assertEquals(expectedMsg, inputMessage);
		}
		Assert.assertFalse(isMaleSelected, "Radio button 'Male' is  checked");
		Assert.assertFalse(isFemaleSelected, "Radio button 'Female' is  checked");
	}

	@Test
	public void RadioButtonGenderGpMale() {
		boolean isSelectedMale, isselectedAgeGroup;
		String actualMessage1, expectedMsg1;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(radioButtonMale1).click();
		isSelectedMale = driver.findElement(radioButtonMale1).isSelected();
		if (isSelectedMale) {
			driver.findElement(buttonageGroup22).click();
			isselectedAgeGroup = driver.findElement(buttonageGroup22).isSelected();
			if (isselectedAgeGroup) {
				driver.findElement(buttonGetResult).click();
				actualMessage1 = "Gender : Male" + '\n' + "Age group: 1 to 18";
				expectedMsg1 = driver.findElement(showMsg1).getText();
				Assert.assertEquals(expectedMsg1, actualMessage1, "Not matching the message");
			}
			Assert.assertTrue(isselectedAgeGroup, "not selected age group");
		}
		Assert.assertTrue(isSelectedMale, "not selected male");
	}

	@Test
	public void RadioButtonGenderGpFemale() {
		boolean isSelectedFemale, isselectedAgeGroup;
		String actualMessage1, expectedMsg1;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(radioButtonFemale).click();
		isSelectedFemale = driver.findElement(radioButtonFemale).isSelected();
		if (isSelectedFemale) {
			driver.findElement(buttonageGroup23).click();
			isselectedAgeGroup = driver.findElement(buttonageGroup23).isSelected();
			if (isselectedAgeGroup) {
				driver.findElement(buttonGetResult).click();
				actualMessage1 = "Gender : Female" + '\n' + "Age group: 19 to 44";
				expectedMsg1 = driver.findElement(showMsg1).getText();
				Assert.assertEquals(actualMessage1, expectedMsg1, "not equals");
			}
			Assert.assertTrue(isselectedAgeGroup, "not selected age group");
		}
		Assert.assertTrue(isSelectedFemale, "not selected female");
	}
}
