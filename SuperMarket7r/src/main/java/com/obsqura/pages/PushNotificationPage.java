package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.FakerUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class PushNotificationPage {
	public WebDriver driver;
	public PushNotificationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotificationBtn;
	
	@FindBy(xpath="//h1[text()='Push Notifications']")
	WebElement pushNotificationHeading;
	
	@FindBy(id="title")
	WebElement pushTitle;
	
	@FindBy(id="description")
	WebElement pushDescription;
	
	@FindBy(xpath="//button[text()=' Send']")
	WebElement pushSendButton;
	
	@FindBy(xpath="//a[text()='Reset']")
	WebElement pushResetButton;
	
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement alertText;
	
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement headText;
	
	@FindBy(xpath="//li[@class='nav-item dropdown']")
	WebElement admin;
	
	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']//a[2]")
	WebElement logOut;		
		
	
		
		public void pushNotificationSend() throws IOException {
			String actual , expected=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "PushNotificationSheet");
			WaitUtility.waitForElement(driver, pushNotificationBtn);
			Assert.assertTrue(pushNotificationBtn.isEnabled(),"push notification button not enabled");
			PageUtility.clickOnElement(pushNotificationBtn);
			Assert.assertTrue(pushTitle.isEnabled(),"Title field is not enabled");
			PageUtility.enterText(pushTitle, FakerUtility.generateSingleData());
			Assert.assertTrue(pushDescription.isEnabled(),"Description field is not enabled");
			PageUtility.enterText(pushDescription, FakerUtility.generateSingleData());	
			Assert.assertTrue(pushSendButton.isEnabled(),"Send button is not enabled");
			PageUtility.clickOnElement(pushSendButton);
			actual=PageUtility.getElementText(alertText);
			Assert.assertEquals(actual,expected,"Send notification failed");	
		}

		public void pushNotificationReset() throws IOException {	
			boolean isFieldEmpty=false;
			WaitUtility.waitForElement(driver, pushNotificationBtn);
			Assert.assertTrue(pushNotificationBtn.isEnabled(),"push notification button not enabled");
			PageUtility.clickOnElement(pushNotificationBtn);
			Assert.assertTrue(pushTitle.isEnabled(),"Title field is not enabled");
			PageUtility.enterText(pushTitle, FakerUtility.generateSingleData());
			Assert.assertTrue(pushDescription.isEnabled(),"Description field is not enabled");
			PageUtility.enterText(pushDescription, FakerUtility.generateSingleData());
			Assert.assertTrue(pushResetButton.isEnabled(),"push reset button not enabled");
			PageUtility.clickOnElement(pushResetButton);			
			if(PageUtility.isEmptyCheck(pushTitle)&&PageUtility.isEmptyCheck(pushDescription)) {
				isFieldEmpty=true;
			}
			Assert.assertTrue(isFieldEmpty, "Reset is failed");
		}
		
		public void pushNotificationAdminLogout() {			
			Assert.assertTrue(admin.isEnabled(),"Admin button is not enabled");
			PageUtility.clickOnElement(admin);
			Assert.assertTrue(logOut.isEnabled(),"Logout button is not enabled");
			PageUtility.clickOnElement(logOut);			
		}		
}
