package com.obsqura.testScripts;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageUserPage;

public class ManageUserTest extends Base{
	LoginPage lp;
	HomePage hp;
	ManageUserPage mup;
	@Test
	public void verifyManageUserTest() throws Exception {
		lp= new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickManagerUserTab();
		mup=new ManageUserPage(driver);
		mup.clickOnDownArrowBtn();
	}
	@Test
	public void verifyManageUserPswTest() throws Exception {
		lp= new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickManagerUserTab();
		mup=new ManageUserPage(driver);
		mup.clickOnDownArrowBtnPsw();
	}

}
