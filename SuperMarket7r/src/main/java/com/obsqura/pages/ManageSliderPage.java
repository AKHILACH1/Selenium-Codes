package com.obsqura.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//h1[text()='List Sliders']")
	WebElement listSliderText;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(id="main_img")
	WebElement chooseFile;
	
	@FindBy(id="link")
	WebElement link;
	
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement alertText;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement saveButton;
	
	
	public void verifyTitleOfPage() throws IOException {		
		String actual=driver.getTitle();
		String expected=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageSliderSheet");
		Assert.assertEquals(actual, expected,"TitleBar is not expected");
	}

	public void verifyAddNewSlider() throws IOException {
		Assert.assertTrue(PageUtility.isElementEnabled(newButton),"New button is not enabled");
		PageUtility.clickOnElement(newButton);		
		Assert.assertTrue(PageUtility.isElementEnabled(chooseFile),"ChooseFile link is not enabled");
		PageUtility.enterText(chooseFile,System.getProperty("user.dir")+constants.Constants.picture);
		Assert.assertTrue(PageUtility.isElementEnabled(link),"Link field is not enabled");
		PageUtility.enterText(link,ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageSliderSheet"));
		Assert.assertTrue(PageUtility.isElementEnabled(saveButton),"Save button is not enabled");
		PageUtility.clickOnElement(saveButton);		
		String actual=PageUtility.getElementText(alertText);
		String expected=ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageSliderSheet");
		Assert.assertEquals(actual, expected, "Alert is Not Expected");
	}

}
