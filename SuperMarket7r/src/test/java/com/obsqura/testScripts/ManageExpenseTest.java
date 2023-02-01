package com.obsqura.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageExpensePage;

public class ManageExpenseTest extends Base{
	ManageExpensePage obj;
	LoginPage objLogin;
	
	@Test
	public void manageExpenseTestMethod() throws IOException {
		
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		obj=new ManageExpensePage(driver);
		obj.manageExpenseMethod();
				
	}

	@Test
	public void manageExpenseTestNew() throws IOException {
		
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		obj=new ManageExpensePage(driver);
		obj.manageExpenseNew();
		
	}

}



 