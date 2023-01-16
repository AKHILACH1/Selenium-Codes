package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class LoginPage {
public WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath="//input[@name='username']")
		private WebElement adminField;
			
		@FindBy(xpath="//input[@name='password']")
		private WebElement passwordField;
		
		@FindBy(xpath="//input[@name='username']")
		private WebElement rememberMeCheckBox;
		
		@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
		private WebElement signInButton;
	
		public void adminLogin() throws IOException {
			Boolean isEnabled;
			String admin=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "LoginExcelSheet");
			String password=ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE, "LoginExcelSheet");
		 	adminField.sendKeys(admin);
		 	passwordField.sendKeys(password);
		    PageUtility.clickOnElement(rememberMeCheckBox);
		    isEnabled=PageUtility.isElementDisplayed(signInButton);
		    Assert.assertTrue(isEnabled,"Button not enabled");
		    PageUtility.clickOnElement(signInButton);
		    Assert.assertTrue(true, "SignIn failed"); 
		    }
	}
