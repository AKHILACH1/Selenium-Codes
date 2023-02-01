package com.obsqura.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class ManageUserPage {
	WebDriver driver;
	public ManageUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageUserTable;
	
	@FindBy(xpath = "//span[text()='janakijanani']")
	WebElement manageUserPassword;
	
	@FindBy(xpath = "//h1[text()='List Users']")
	WebElement listUserText;
	
	public void clickOnDownArrowBtn() throws Exception {
		PageUtility.ScrollBy(driver);
		
		int  rowNumber= PageUtility.selectRowFromDynamicTable(manageUserTable, "sree sree");
		String downLocator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber+1) +"]//td[3]//a";
		WebElement manageUserDownIcon = driver.findElement(By.xpath(downLocator));		
		PageUtility.clickJavaScriptExecutor(manageUserDownIcon, driver);		
		String actual=PageUtility.getElementText(listUserText);
		String expected=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageUserSheet");;
		Assert.assertEquals(actual, expected, constants.Constants.mu_errorVerifyManageUserPageText);
	}
	public void clickOnDownArrowBtnPsw() throws Exception {

		int  rowNumber= PageUtility.selectRowFromDynamicTable(manageUserTable, "sree sree");
		String downLocator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber+1) +"]//td[3]//a";
		WebElement manageUserDownIcon = driver.findElement(By.xpath(downLocator));		
		PageUtility.clickJavaScriptExecutor(manageUserDownIcon, driver);
		PageUtility.ScrollBy(driver);		
		int rowNumber1 = PageUtility.selectRowFromDynamicTable(manageUserTable, "sree sree");				
		String passwordLocator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber1+2) +"]//td//div//div//span[text()='janakijanani']";
		WebElement manageUserPassword = driver.findElement(By.xpath(passwordLocator));		
		String actual=PageUtility.getElementText(manageUserPassword);			
		String expected=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageUserSheet");;
		Assert.assertEquals(actual, expected, constants.Constants.mu_errorVerifyManageUserPassword);
		
		
	}

}
