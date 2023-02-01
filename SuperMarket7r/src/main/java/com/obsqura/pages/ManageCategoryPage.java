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

public class ManageCategoryPage {
	WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[12]/a")
	private WebElement manageCategoryMenu;
	
	@FindBy(xpath = "//li[@class='nav-item']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subCategoryMenu;
	
	@FindBy(xpath = "//div[@class='col-sm-12']/a[2]")
	private WebElement searchButtonMain;
	
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement selectCategory;
	
	@FindBy(xpath = "//select[@id='un']//child::option[text()='Grocery & Staples']")
	private WebElement categories;
	
	@FindBy(xpath = "//div[@class='col-sm-6 form-group']//child::input[@class='form-control']")
	private WebElement subCategoryField;
	
	@FindBy(xpath = "//div[@class='card-body']//child::button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement resetButton;
	
	@FindBy(xpath = "//div[@class='col-sm-6']//child::h1[@class='m-0 text-dark']")
	private WebElement subCategoryPage;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody/tr[1]//td[4]/a[1]/span[1]")
	private WebElement statusButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	
	@FindBy(xpath = "//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath = "//div[@class='form-group']//select[@class='form-control selectpicker']")
	private WebElement catField;
	
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCatField;
	
	@FindBy(xpath = "//div[@class=' form-group']//child::input[@id='main_img']")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newCatAddedAlert;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	private WebElement searchedDetails;
	
	
	public void newSubCategory() throws IOException {
		String imageInput,subcat;
		boolean addNewCat;
		imageInput=ExcelUtility.getString(1, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE, "ManageCategory");
		subcat=ExcelUtility.getString(3, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE, "ManageCategory");
		WaitUtility.waitForElement(driver,manageCategoryMenu);
		PageUtility.clickOnElement(manageCategoryMenu);
		WaitUtility.waitForElement(driver,subCategoryMenu);
		PageUtility.clickOnElement(subCategoryMenu);
		WaitUtility.waitForElement(driver,newButton);
		PageUtility.clickOnElement(newButton);
		WaitUtility.waitForElement(driver,catField);
		PageUtility.clickOnElement(catField);
		WaitUtility.waitForElement(driver, categories);				
		PageUtility.selectIndexFromDropdown(categories,Integer.parseInt(ExcelUtility.getNumeric(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE ,"ManageCategory")));
		PageUtility.elementIsSelected(categories);
		WaitUtility.waitForElement(driver,subCatField);
		PageUtility.clickOnElement(subCatField);
		PageUtility.enterText(subCatField,subcat);
		WaitUtility.waitForElement(driver,chooseFileBtn);
		PageUtility.enterText(chooseFileBtn,imageInput);		
		WaitUtility.waitForElement(driver,saveBtn);
		PageUtility.clickOnElement(saveBtn);
		addNewCat=PageUtility.isElementDisplayed(newCatAddedAlert);
		Assert.assertTrue(addNewCat, "New subcategory not added");
	}

	public void subCategorySearchButton() throws IOException {
		String input,category;
		boolean isSearchedDetail;
		category=ExcelUtility.getString(2, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE, "ManageCategory");
		input=ExcelUtility.getString(3, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE, "ManageCategory");
		WaitUtility.waitForElement(driver,manageCategoryMenu);
		PageUtility.clickOnElement(manageCategoryMenu);
		WaitUtility.waitForElement(driver,subCategoryMenu);
		PageUtility.clickOnElement(subCategoryMenu);
		WaitUtility.waitForElement(driver,searchButtonMain);
		PageUtility.clickOnElement(searchButtonMain);
		WaitUtility.waitForElement(driver,selectCategory);
		PageUtility.clickOnElement(selectCategory);		
		PageUtility.enterText(selectCategory,category);
		WaitUtility.waitForElement(driver,subCategoryField);
		PageUtility.enterText(subCategoryField,input);
		WaitUtility.waitForElement(driver,searchButton);
		PageUtility.clickOnElement(searchButton);
		isSearchedDetail=PageUtility.isElementDisplayed(searchedDetails);
		Assert.assertTrue(isSearchedDetail, "Search details not shown");
	}
	public void resetButton() {
		boolean isSubCatPage,isReset;
		PageUtility.clickOnElement(manageCategoryMenu);
		PageUtility.clickOnElement(subCategoryMenu);
		PageUtility.clickOnElement(searchButtonMain);
		isReset=PageUtility.isElementDisplayed(resetButton);
		Assert.assertTrue(isReset,"Reset button not displayed");
		PageUtility.clickOnElement(resetButton);
		isSubCatPage=PageUtility.isElementDisplayed(subCategoryPage);
		Assert.assertTrue(isSubCatPage, "SubCategory page not displayed");
		
	}
	

}
