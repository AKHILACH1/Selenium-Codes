package com.obsqura.testScripts;



import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageLocationPage;

public class ManageLocationTest extends Base {
	LoginPage objLogin;
	ManageLocationPage obj;
	HomePage hp;
	@Test
	public void  ManageLocTest() throws Exception  {
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		hp=new HomePage(driver);
		hp.clickManageLocationTab();
		obj=new ManageLocationPage(driver);
		obj.getActiveInactiveText();
	}

}
