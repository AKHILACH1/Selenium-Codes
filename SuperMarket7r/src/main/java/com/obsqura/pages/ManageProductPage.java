package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class ManageProductPage {
	public WebDriver driver;
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[text()=' New']")
	WebElement newManageProduct;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageProductTable;
	
	@FindBy(xpath = "//h4[@class='card-title']//b")
	WebElement noOfProduct;
	
	@FindBy(id = "title")
	WebElement productInformationTitle;
	
	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement productType;
	
	@FindBy(id = "cat_id")
	WebElement productInformationCategory;
	
	@FindBy(xpath="//span//select[@id='sub_id']")
	WebElement subCategory;
	
	@FindBy(id = "purpose")
	WebElement priceType;
	
	@FindBy(id = "purpose1")
	WebElement priceTypePiece;
	
	@FindBy(xpath="//div//label[text()='Minimum Piece ']")
	WebElement minimumPiece;
	
	@FindBy(id = "m_weight")
	WebElement weightValue;
	
	@FindBy(id = "w_unit")
	WebElement weightUnit;
	
	@FindBy(id = "max_weight")
	WebElement maximumQuantityCanOrder;
	
	@FindBy(id = "w_price")
	WebElement price;
	
	@FindBy(id = "w_stock")
	WebElement stockAvailability;
	
	@FindBy(xpath = "//div//label[2]//input[@name='stock']")
	WebElement stockRadioButton;
	
	@FindBy(xpath = "//div//label[2]//input[@name='featured']")
	WebElement featuredRadioButton;
	
	@FindBy(xpath = "//div//label[2]//input[@name='combo']")
	WebElement comboPackRadioButton;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5[text()=' Alert!']")
	WebElement alertSuccess;
	
	@FindBy(id="main_img")
	WebElement chooseImageFile;
	
	public void clickNew() {
		PageUtility.clickOnElement(newManageProduct);
		
	
	}


}
