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

public class ManageLocationPage {
	public WebDriver driver;
	PageUtility pu=new PageUtility();
	HomePage hp= new HomePage(driver);

	String expected;
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageLocationTable;
	
	@FindBy(xpath = "(//p[text()='Manage Location'])[1]")
	WebElement manageLocation;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	WebElement statusColumn;

	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editBtn;

	@FindBy(xpath = "//select[@name='state_id']")
	WebElement stateDropdown;
	


	public void getActiveInactiveText() throws Exception {
			
		WebElement activeInactive, activeInactiveText;
		PageUtility.pageScroll(0, 50, driver);		
		int rowNumber = PageUtility.selectRowFromDynamicTable(manageLocationTable, ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageLocationSheet"));
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowNumber + 1)
				+ "]//td[5]//a";
		activeInactive = driver.findElement(By.xpath(locator));
		activeInactive.click();
		String locatorText = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowNumber + 1)
				+ "]//td[5]";
		activeInactiveText = driver.findElement(By.xpath(locatorText));
		String actual = activeInactiveText.getText();
		if (actual.equals("Active")) {
			expected = ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageLocationSheet");
		} else if (actual.equals("Inactive")) {
			expected = ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageLocationSheet");
		}
		Assert.assertEquals(actual, expected, "Active Inactive text not expected");
	
	}

}
