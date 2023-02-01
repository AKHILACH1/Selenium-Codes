package com.obsqura.testScripts;


import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;
public class LoginTest extends Base{
	LoginPage obj;
	@Test
	public void invalidLogin() throws IOException {
		obj=new LoginPage(driver);
		obj.adminInvalidLogin();	
	}
	
	@Test
	public void validLogin() throws IOException {
		obj=new LoginPage(driver);
		obj.adminLogin();
	
	
}
}