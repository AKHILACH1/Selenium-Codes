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

public class ManageExpensePage {
	public WebDriver driver;
	public ManageExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//p[contains(text(),'Manage Expense')]")
	private WebElement manageExpenseBtn;
	
	@FindBy(xpath="//p[contains(text(),'Expense Category')]")
	private WebElement expenseCategoryBtn;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newBtn;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement titleField;
	
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveBtn;
	
	public void manageExpenseMethod() throws IOException {
		String actual=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageExpenseSheet");
		WaitUtility.waitForElement(driver, manageExpenseBtn);
		Assert.assertTrue(PageUtility.isElementEnabled(manageExpenseBtn),"manage expense button is not enabled");
		PageUtility.clickOnElement(manageExpenseBtn);		
		WaitUtility.waitForElement(driver, expenseCategoryBtn);
		Assert.assertTrue(PageUtility.isElementEnabled(expenseCategoryBtn), "expense category click not enabled");
		PageUtility.clickOnElement(expenseCategoryBtn);		
		Assert.assertEquals(actual, PageUtility.getElementText(expenseCategoryBtn),"expense category click failed");		
		}
	public void manageExpenseNew() throws IOException {
		String actual=ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ManageExpenseSheet");
		WaitUtility.waitForElement(driver, manageExpenseBtn);
		Assert.assertTrue(PageUtility.isElementEnabled(manageExpenseBtn),"manage expense button is not clickable");
		PageUtility.clickOnElement(manageExpenseBtn);
		WaitUtility.waitForElement(driver, expenseCategoryBtn);
		Assert.assertTrue(PageUtility.isElementEnabled(expenseCategoryBtn),"Expense category button is not clickable");
		PageUtility.clickOnElement(expenseCategoryBtn);		
		WaitUtility.waitForElement(driver, newBtn);
		Assert.assertTrue(PageUtility.isElementEnabled(newBtn),"New button is not enabled");
		PageUtility.clickOnElement(newBtn);
		String title=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ExpenseCategory");
		PageUtility.enterText(titleField, title);
		WaitUtility.waitForElement(driver, saveBtn);
		Assert.assertTrue(PageUtility.isElementEnabled(saveBtn),"Save button is not enabled");
		PageUtility.clickOnElement(saveBtn);
		Assert.assertEquals(actual, PageUtility.getElementText(saveBtn),"Save failed");
		}

}


