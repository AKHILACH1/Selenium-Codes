package com.obsqura.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.FakerUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[14]/a")
	private WebElement manageDeliveryBoyOption;
	
	@FindBy(xpath = "//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	
	@FindBy(xpath = "//input[@id='address']")
	private WebElement addressField;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	
	@FindBy(xpath = "//div[@class='form-group']//child::input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement detailsAddedAlert;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[7]//div[@class='action-buttons']")
	private WebElement bluePasswordDetailsButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//td//div[@class='profile-info-name']")
	private WebElement passwordDetails;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//td//div[@class='profile-info-name']//span[1]")
	private WebElement actualPassword;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement blueSearchButton;
	
	@FindBy(xpath = "//input[@id='un']")
	private WebElement nameSearch;
	
	@FindBy(xpath = "//input[@id='ut']")
	private WebElement emailSearch;
	
	@FindBy(xpath = "//input[@id='ph']")
	private WebElement phoneNumberSearch;
	
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement redsearchButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]")
	private WebElement searchedDetails;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	private WebElement searchName;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]")
	private WebElement searchEmail;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[3]")
	private WebElement searchPhoneNumber;
	
	
	public void addDeliVeryBoyDetails() throws IOException, InterruptedException {
		boolean addedAlert;
		String name,emailNew,phoneNumb,userNameNew,passwordNew;
		name=FakerUtility.firstNameMethod();
		phoneNumb=FakerUtility.phoneNumber();
		emailNew=FakerUtility.email();
		userNameNew=FakerUtility.firstNameMethod();
		passwordNew=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageDeliveryBoy");
		WaitUtility.waitForElement(driver, manageDeliveryBoyOption);
		Assert.assertTrue(PageUtility.isElementEnabled(manageDeliveryBoyOption),"Manage Delivery Boy Option not enabled");
		PageUtility.clickOnElement(manageDeliveryBoyOption);	
		WaitUtility.waitForElement(driver,newButton);
		Assert.assertTrue(PageUtility.isElementEnabled(newButton),"New button not enabled");
		PageUtility.clickOnElement(newButton);
		WaitUtility.waitForElement(driver,nameField);
		Assert.assertTrue(PageUtility.isElementEnabled(nameField),"Name field not enabled");
		PageUtility.enterText(nameField,name);
		WaitUtility.waitForElement(driver, emailField);
		Assert.assertTrue(PageUtility.isElementEnabled(emailField),"email field not enabled");
		PageUtility.enterText(emailField,emailNew);
		WaitUtility.waitForElement(driver, phoneNumberField);
		Assert.assertTrue(PageUtility.isElementEnabled(phoneNumberField),"phone no field not enabled");
		PageUtility.enterText(phoneNumberField,phoneNumb);
		WaitUtility.waitForElement(driver,userNameField);
		Assert.assertTrue(PageUtility.isElementEnabled(userNameField),"User name field not enabled");
		PageUtility.enterText(userNameField,userNameNew);
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElement(driver, passwordField);
		Assert.assertTrue(PageUtility.isElementEnabled(passwordField),"Password is not enabled");
		PageUtility.enterText(passwordField,passwordNew);		
		Assert.assertTrue(PageUtility.isElementEnabled(saveButton),"Save button not enabled");
		//WaitUtility.waitForElementClickable(driver, saveButton);	
		WaitUtility.waitForElement(driver, saveButton);
		PageUtility.clickOnElement(saveButton);	
		WaitUtility.waitForElement(driver, detailsAddedAlert);
		addedAlert=PageUtility.isElementDisplayed(detailsAddedAlert);
		Assert.assertTrue(addedAlert, "Details added message not displayed");		
	}
	public void passwordDetails() throws IOException {
		String expectedPassword,actual;
		boolean isPasswordShown,isPasswordButton;
		expectedPassword=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageDeliveryBoy");
		PageUtility.clickOnElement(manageDeliveryBoyOption);
		isPasswordButton=PageUtility.isElementDisplayed(bluePasswordDetailsButton);
		Assert.assertTrue(isPasswordButton,"password hidden icon not displayed");
		WaitUtility.waitForElement(driver, bluePasswordDetailsButton);
		PageUtility.clickOnElement(bluePasswordDetailsButton);
		isPasswordShown=PageUtility.isElementDisplayed(passwordDetails);
		Assert.assertTrue(isPasswordShown, "Password details are not shown");
		actual=PageUtility.getElementText(actualPassword);
		Assert.assertEquals(actual, expectedPassword, "Password is incorrect");
	
	}
	public void searchByName() throws IOException {
		boolean details,isNameSearch;		
		String name=ExcelUtility.getString(0, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE, "ManageDeliveryBoy");
		PageUtility.clickOnElement(manageDeliveryBoyOption);
		PageUtility.clickOnElement(blueSearchButton);
		isNameSearch=PageUtility.isElementDisplayed(nameSearch);
		Assert.assertTrue(isNameSearch, "NameSearch field not visible");
		PageUtility.clickOnElement(nameSearch);
		PageUtility.enterText(nameSearch,name);
		details=PageUtility.isElementDisplayed(searchedDetails);
		Assert.assertTrue(details, "Details are not shown");
		
	}
	
	public void createNewDeliveryBoy(String name,String email,String phoneNumber) throws IOException {
		WaitUtility.waitForElement(driver, manageDeliveryBoyOption);
		PageUtility.clickOnElement(manageDeliveryBoyOption);
		WaitUtility.waitForElement(driver, newButton);
		PageUtility.clickOnElement(newButton);
		WaitUtility.waitForElement(driver, nameField);
		WaitUtility.waitForElement(driver, emailField);
		PageUtility.enterText(nameField, name);
		PageUtility.enterText(emailField, email);
		PageUtility.enterText(phoneNumberField, phoneNumber);
		//PageUtility.enterText(addressField, address);
		PageUtility.enterText(userNameField,FakerUtility.firstNameMethod());
		PageUtility.ScrollBy(driver);
		PageUtility.enterText(passwordField,ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageDeliveryBoy"));
		WaitUtility.waitForElement(driver, saveButton);
		PageUtility.clickOnElement(saveButton);
		boolean addedAlert=PageUtility.isElementDisplayed(detailsAddedAlert);
		Assert.assertTrue(addedAlert, "Details added message not displayed");
	}
	

}
