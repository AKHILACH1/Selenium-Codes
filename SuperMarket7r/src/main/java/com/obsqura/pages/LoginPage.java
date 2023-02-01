package com.obsqura.pages;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

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
		
		@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
		private WebElement alertText;
		
		
		public void adminInvalidLogin() throws IOException {			
			String admin=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "LoginExcelSheet");
			String password=ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE, "LoginExcelSheet");
			Assert.assertTrue(PageUtility.isElementEnabled(adminField), "Admin field is not enabled");
			PageUtility.enterText(adminField, admin);
			Assert.assertTrue(PageUtility.isElementEnabled(passwordField), "Password field is not enabled");
		 	PageUtility.enterText(passwordField,password);
		 	PageUtility.clickOnElement(rememberMeCheckBox);		
		 	Assert.assertTrue(PageUtility.isElementEnabled(signInButton), "SignIn button is not enabled");
		    PageUtility.clickOnElement(signInButton);
		    WaitUtility.waitForElement(driver, alertText);
		    Boolean IsDisplayedAlert = PageUtility.isElementDisplayed(alertText);
		 	Assert.assertTrue(IsDisplayedAlert,":::Alert text is not as expected");
			}
		public void adminLogin() throws IOException {
			String actual = PageUtility.getElementText(signInButton);
			String expected = "Sign In";
			String admin=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "LoginExcelSheet");
			String password=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE, "LoginExcelSheet");
			Assert.assertTrue(PageUtility.isElementEnabled(adminField), "admin field is not enabled");
			PageUtility.enterText(adminField, admin);
			Assert.assertTrue(PageUtility.isElementEnabled(passwordField), "Password field is not enabled");
		 	PageUtility.enterText(passwordField,password);
		 	PageUtility.clickOnElement(rememberMeCheckBox);		
		 	Assert.assertTrue(PageUtility.isElementEnabled(signInButton), "SignIn button is not enabled");
		    PageUtility.clickOnElement(signInButton);	
		 	Assert.assertEquals(actual, expected,"::Sign in is not expected");
			}
	}
