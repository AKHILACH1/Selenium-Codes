package com.obsqura.testScripts;
import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageCategoryPage;

public class ManageCategoryTest extends Base{
	LoginPage obj;
	ManageCategoryPage objMcp;
	
	@Test
	public void verifyreset() throws IOException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMcp=new ManageCategoryPage(driver);		
		objMcp.resetButton();
		}
	
	
	
	@Test
	public void verifySubcategoryAdd() throws IOException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMcp=new ManageCategoryPage(driver);		
		objMcp.newSubCategory();
	}
	
	@Test
	public void verifySubCategorySearch() throws IOException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMcp=new ManageCategoryPage(driver);
		objMcp.subCategorySearchButton();	
		}
}
