package com.obsqura.TestNgSample;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
			Assert.assertEquals(expectedMsg, inputMessage,"Not matching the message");
			
		}
		assertTrue(isSelected,"Radio button 'Male' is not checked");
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
		assertTrue(isSelected,"Radio button 'Female' is not checked");
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
		Assert.assertFalse(isMaleSelected,"Radio button 'Male' is  checked");
		Assert.assertFalse(isFemaleSelected,"Radio button 'Female' is  checked");
	}
	@Test
	public void checkBox() {
		WebElement checkbox,showMsgField;
		boolean isChecked;
		String expectedMsg="Success - Check box is checked",shownMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		checkbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		showMsgField=driver.findElement(By.xpath("//div[@id='message-one']"));
		checkbox.click();
		isChecked=checkbox.isSelected();
		shownMsg=showMsgField.getText();
		if(isChecked) {
			Assert.assertEquals(expectedMsg, shownMsg,"not equals the msg");
		}
		Assert.assertTrue(isChecked,"Checkbox is not checked");
		}
	

	@Test
	public void RadioButtonGenderGpMale() {
		WebElement radioButtonMale,buttonageGroup,buttonGetResult,showMsg1;
		boolean isSelectedMale,isselectedAgeGroup;
		String actualMessage1,expectedMsg1;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radioButtonMale= driver.findElement(By.xpath("//input[@id='inlineRadio11']"));
		buttonGetResult=driver.findElement(By.xpath("//button[@id='button-two']"));
		buttonageGroup=driver.findElement(By.xpath("//input[@id='inlineRadio22']"));
		showMsg1=driver.findElement(By.xpath("//div[@id='message-two']"));
		radioButtonMale.click();
		isSelectedMale=radioButtonMale.isSelected();
		if(isSelectedMale) {
			buttonageGroup.click();
			isselectedAgeGroup=buttonageGroup.isSelected();
			if(isselectedAgeGroup) {
				buttonGetResult.click();
				actualMessage1="Gender : Male"+'\n'+ "Age group: 1 to 18";
				expectedMsg1=showMsg1.getText();
				Assert.assertEquals(expectedMsg1, actualMessage1,"Not matching the message");
			}
			Assert.assertTrue(isselectedAgeGroup, "not selected age group");
		}	
		Assert.assertTrue(isSelectedMale, "not selected male");
    }

	@Test
	public void RadioButtonGenderGpFemale() {
		WebElement radioButtonFemale,buttonageGroup,buttonGetResult,showMsg1;
		boolean isSelectedFemale,isselectedAgeGroup;
		String actualMessage1,expectedMsg1;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radioButtonFemale= driver.findElement(By.xpath("//input[@id='inlineRadio21']"));
		buttonGetResult=driver.findElement(By.xpath("//button[@id='button-two']"));
		buttonageGroup=driver.findElement(By.xpath("//input[@id='inlineRadio23']"));
		showMsg1=driver.findElement(By.xpath("//div[@id='message-two']"));
		radioButtonFemale.click();
		isSelectedFemale=radioButtonFemale.isSelected();
		if(isSelectedFemale) {
			buttonageGroup.click();
			isselectedAgeGroup=buttonageGroup.isSelected();
			if(isselectedAgeGroup) {
				buttonGetResult.click();
				actualMessage1="Gender : Female"+'\n'+"Age group: 19 to 44";
				expectedMsg1=showMsg1.getText();
				Assert.assertEquals(actualMessage1, expectedMsg1,"not equals");
			}
			Assert.assertTrue(isselectedAgeGroup, "not selected age group");
		}	
		Assert.assertTrue(isSelectedFemale, "not selected female");
    }
	@Test
	public void checkBoxes() {
		WebElement checkbox1, checkbox2;
		boolean isChecked1, isChecked2;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		checkbox1 = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		checkbox2 = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		checkbox1.click();
		isChecked1 = checkbox1.isSelected();
		checkbox2.click();
		isChecked2 = checkbox2.isSelected();
		if (isChecked1) {
			Assert.assertTrue(isChecked1, "Checkbox1 is not checked");
		}
		if (isChecked2) {
			Assert.assertTrue(isChecked2, "Checkbox2 is not checked");
		}
	}
	@Test
	public void checkBoxesAllSelectOrUnSelect() {
		WebElement checkbox1, checkbox2, checkbox3, checkbox4, selectOrDeselectButton;
		boolean isChecked1, isChecked2, isChecked3, isChecked4;
		String buttonText;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		checkbox1 = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		checkbox2 = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		checkbox3 = driver.findElement(By.xpath("//input[@id='check-box-three']"));
		checkbox4 = driver.findElement(By.xpath("//input[@id='check-box-four']"));
		selectOrDeselectButton = driver.findElement(By.xpath("//input[@id='button-two']"));
		checkbox1.click();
		isChecked1 = checkbox1.isSelected();
		checkbox2.click();
		isChecked2 = checkbox2.isSelected();
		checkbox3.click();
		isChecked3 = checkbox3.isSelected();
		checkbox4.click();
		isChecked4 = checkbox4.isSelected();
		if ((isChecked1==true) && (isChecked2==true) &&(isChecked3==true)&&(isChecked4==true)) {
			selectOrDeselectButton.click();
			isChecked1=false;
			isChecked2=false;
			isChecked3=false;
			isChecked4=false;
			Assert.assertFalse(isChecked1, "Checkbox1 is  checked");
			Assert.assertFalse(isChecked2, "Checkbox2 is  checked");
			Assert.assertFalse(isChecked3, "Checkbox3 is  checked");
			Assert.assertFalse(isChecked4, "Checkbox4 is  checked");
		}
		
	}
}


