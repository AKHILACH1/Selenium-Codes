package com.obsqura.pages;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class HomePage {
	public WebDriver driver;
	PageUtility pu=new PageUtility();
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="(//p[contains(text(),'Manage Expe')])[1]")
	WebElement manageExpense;

	@FindBy(xpath="(//p[text()='Manage Users'])[1]")
	WebElement manageUsers;

	
	@FindBy(xpath = "//a//p[text()='Manage Product']")
	WebElement clickManageProduct;
	
	@FindBy(xpath = "//a[text()=' Admin@']")
	WebElement adminText;
	
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrder;
	
	@FindBy(xpath = "//p[text()='Manage Users'][1]")
	WebElement manageUser;
	
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	
	@FindBy(xpath = "//p[text()='Manage Location']")
	WebElement ManageLocation;
	
	@FindBy(xpath = "//li//p[text()='Manage Slider']")
	WebElement manageSlide;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="//a[@class='active nav-link']")
	WebElement dashBord;
	
	@FindBy(xpath="//div[@style='background-color:green !important;']")
	WebElement dashBoardBackground;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	
	@FindBy(xpath="//p[text()='Mobile Slider']")
	WebElement mobileSliderTab;
	
	public void clickManageLocationTab() throws IOException {
		String actual=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");
		PageUtility.pageScroll(0, 100, driver);
		Assert.assertTrue(PageUtility.isElementEnabled(ManageLocation),"manage location is not enabled ");
		PageUtility.clickOnElement(ManageLocation);
		Assert.assertEquals(actual, PageUtility.getElementText(ManageLocation),"ManageLocation click failed");
	}
	
	public void clickManageSlide() throws IOException {
		String actual=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");	
		PageUtility.pageScroll(0, 100, driver);
		Assert.assertTrue(PageUtility.isElementEnabled(manageSlide),"manage slider is not enabled ");
		PageUtility.clickOnElement(manageSlide);
		Assert.assertEquals(actual, PageUtility.getElementText(manageSlide),"ManageSlider click failed");
	}
		
	public void clickManagerUserTab() throws IOException {
		String actual=ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");
		Assert.assertTrue(PageUtility.isElementEnabled(manageUser),"manage user is not enabled ");
		PageUtility.clickOnElement(manageUser);
		String s=PageUtility.getElementText(manageUser);
		Assert.assertEquals(actual, PageUtility.getElementText(manageUser),"ManageUser click failed");
	}
		
	public void clickMobileSliderTab() throws IOException {
		String actual=ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");
		Assert.assertTrue(PageUtility.isElementEnabled(mobileSliderTab),"mobileSlider is not enabled ");
		PageUtility.clickOnElement(mobileSliderTab);
		Assert.assertEquals(actual, PageUtility.getElementText(mobileSliderTab),"MobileSlider click failed");
	}
	
	public void homeBgColorValidation() throws IOException {
		String actualBgColor = PageUtility.stylePropertyValidation(home, "background-color");
		String expectedBgColor =ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");
		Assert.assertEquals(actualBgColor, expectedBgColor,"Home page background colour is not as expected ");
	}
	
	public void manageExpenseTextValidation() throws IOException {
		String expectedText_ME = PageUtility.getElementText(manageExpense);
		String actualText_ME = ExcelUtility.getString(4, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");
		Assert.assertEquals(actualText_ME, expectedText_ME, "Manage expense text is not as expected ");
	}
	
	public void manageUsersTextValidation() throws IOException {		
		String expectedText_MU = PageUtility.getElementText(manageUsers);
		String actualText_MU = ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "HomeSheet");
		Assert.assertEquals(actualText_MU, expectedText_MU, "Manage user text is not as expected ");
	}
	
	
}
