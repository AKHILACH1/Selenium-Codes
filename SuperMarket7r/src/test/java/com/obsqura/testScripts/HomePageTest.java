package com.obsqura.testScripts;

import java.io.IOException;


import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;

public class HomePageTest extends Base {
	LoginPage lp;
	HomePage hp;
	
	@Test(groups ="RegressionTest",priority=2)
	public void homeBgColorValidationTest() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.homeBgColorValidation();
		
	}
		
	@Test(groups ="RegressionTest",priority=1)
	public  void manageExpenseTextValidationTest() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.manageExpenseTextValidation();		
	}
	
	@Test(groups ="RegressionTest",priority=3)
	public  void manageUsersTextValidationTest() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.manageUsersTextValidation();		
	}
	@Test
	public  void clickManageUserTest() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickManagerUserTab();
	}
	@Test
	public  void clickManageSlideTest() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickManageSlide();
	}
	@Test
	public  void clickManageLocationTest() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickManageLocationTab();
	}
}
