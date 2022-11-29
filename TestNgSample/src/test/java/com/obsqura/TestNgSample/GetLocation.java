package com.obsqura.TestNgSample;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetLocation extends Base {

	@Test
	public void findLoc() {     //Verify Show message button place under enter message field.(https://selenium.obsqurazone.com/simple-form-demo.php)
		Point buttonLocation, textFieldLocation;
		int x, y, x1, y1;
		boolean greater = false;
		buttonLocation = driver.findElement(By.xpath("//button[@id='button-one']")).getLocation();
		x = buttonLocation.getX();
		y = buttonLocation.getY();
		textFieldLocation = driver.findElement(By.xpath("//input[@id='single-input-field']")).getLocation();
		x1 = textFieldLocation.getX();
		y1 = textFieldLocation.getY();
		if (y > y1) {
			greater = true;
		}
		Assert.assertTrue(greater, "Show message button place is not under enter message field");
	}

	@Test
	public void findelementsSample() {
		String text;
		List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='list-group list-group-flush']//li"));
		for (WebElement menu : menuList) {
			text = menu.getText();
			if (text.contentEquals("Radio Buttons Demo")) {
				menu.click();
				break;
			}

		}

	}
	@Test
	public void findelementsSample1() {   //Click on date picker category from menu option using find elements(https://selenium.obsqurazone.com/)
		String text;
		List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
		for (WebElement menu : menuList) {
			text = menu.getText();
			if (text.contentEquals("DATE PICKERS")) {
				menu.click();
				break;
			}

		}

	}

	@Test
	public void findelementsSample2() {
		int i;
		String text;
		List<WebElement> menuList1 = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
				for (i = 0; i < menuList1.size(); i++) {
				text = menuList1.get(i).getText();
				if (text.contentEquals("DATE PICKERS")) {
					menuList1.get(i).click();
					break;
				}

			}
	}
	
	@Test
	public void checkRadioButtonMale() {
		WebElement radioButtonMale,buttonselect,showMsg;
		boolean isSelected;
		String inputMessage="Radio button 'Male' is checked",expectedMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radioButtonMale= driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		buttonselect=driver.findElement(By.xpath("//button[@id='button-one']"));
		showMsg=driver.findElement(By.xpath("//div[@id='message-one']"));
		radioButtonMale.click();
		isSelected=radioButtonMale.isSelected();
		if(isSelected) {
			buttonselect.click();
			expectedMsg=showMsg.getText();
			Assert.assertEquals(expectedMsg, inputMessage);
			
		}
	}
	@Test
	public void checkRadioButtonFemale() {
		WebElement radioButtonFemale,buttonselect,showMsg;
		boolean isSelected;
		String inputMessage="Radio button 'Female' is checked",expectedMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radioButtonFemale= driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		buttonselect=driver.findElement(By.xpath("//button[@id='button-one']"));
		showMsg=driver.findElement(By.xpath("//div[@id='message-one']"));
		radioButtonFemale.click();
		isSelected=radioButtonFemale.isSelected();
		if(isSelected) {
			buttonselect.click();
			expectedMsg=showMsg.getText();
			Assert.assertEquals(expectedMsg, inputMessage);
			
		}
	}
	@Test
	public void checkRadioButtonNone() {
		WebElement radioButtonFemale,radioButtonMale,buttonselect,showMsg;
		boolean isMaleSelected,isFemaleSelected;
		String inputMessage="Radio button is Not checked",expectedMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radioButtonMale= driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		radioButtonFemale= driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		buttonselect=driver.findElement(By.xpath("//button[@id='button-one']"));
		showMsg=driver.findElement(By.xpath("//div[@id='message-one']"));
		isMaleSelected=radioButtonMale.isSelected();
		isFemaleSelected=radioButtonFemale.isSelected();
		if((isMaleSelected==false)&&(isFemaleSelected==false)) {
			buttonselect.click();
			expectedMsg=showMsg.getText();
			Assert.assertEquals(expectedMsg, inputMessage);
			
		}
	}
}


