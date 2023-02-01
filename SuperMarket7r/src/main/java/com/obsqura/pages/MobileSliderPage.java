package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class MobileSliderPage {
	WebDriver driver;	
	
	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="select#cat_id")
	WebElement categoryDropDown;
	@FindBy(css="input#main_img")
	WebElement chooseFile;
	@FindBy(css="button[class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(css="div[class='alert alert-success alert-dismissible']>h5")
	WebElement alertText;
	@FindBy(css="a[class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[11]/a")
	private WebElement mblSlideMenu;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]/a/span")
	private WebElement statusBtn;
	
	
		public void NewButtonEntry() throws IOException {
			PageUtility.clickOnElement(newButton);					
			PageUtility.selectIndexFromDropdown(categoryDropDown,Integer.parseInt(ExcelUtility.getNumeric(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE ,"manageSlider")));
			PageUtility.sendKeyFunctionforImage(chooseFile, ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE ,"manageSlider"));
			PageUtility.clickOnElement(saveButton);		
			String actual=PageUtility.getElementText(alertText);
			String expected="Alert!";
			Assert.assertEquals(actual, expected, "Alert Not Expected");
		}
		public void chkStatusBtnPresent() {
			boolean statusButton,isMobileSliderMenu;
			isMobileSliderMenu=mblSlideMenu.isDisplayed();
			Assert.assertTrue(isMobileSliderMenu, "Mobileslder option is not visible in the menu");
			PageUtility.clickOnElement(mblSlideMenu);
			statusButton = PageUtility.isElementDisplayed(statusBtn);
			Assert.assertTrue(statusButton, "Status button not displayed");
		
		}

		
	}
	
	

