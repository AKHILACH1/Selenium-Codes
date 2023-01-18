package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	manageExpenseBtn.click();
	WaitUtility.waitForElement(driver, expenseCategoryBtn);
	expenseCategoryBtn.click();
	WaitUtility.waitForElement(driver, newBtn);
	newBtn.click();
	String title=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE , "ExpenseCategory");
	titleField.sendKeys(title);
	WaitUtility.waitForElement(driver, newBtn);
	saveBtn.click();
	}

}


