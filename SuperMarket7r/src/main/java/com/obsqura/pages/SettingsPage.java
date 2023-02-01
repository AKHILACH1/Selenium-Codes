package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class SettingsPage {
	WebDriver driver;
	
	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[19]//a[@class=' nav-link']//p")
	WebElement settings;

	@FindBy(xpath = "//p[contains(text(),'Logout')]")
	WebElement logout;

	public void verifyLogout() throws IOException {
		PageUtility.scrollToTheElement(settings, driver);
		PageUtility.clickOnElement(settings);
		PageUtility.scrollToTheElement(logout, driver);
		PageUtility.clickOnElement(logout);		
		String actualUrl =  PageUtility.gettingCurrentUrl(driver);
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "SettingsSheet");
		Assert.assertEquals(actualUrl, expectedUrl,"Invalid URL");
	}

}
