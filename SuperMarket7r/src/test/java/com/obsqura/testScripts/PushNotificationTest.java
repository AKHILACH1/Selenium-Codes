package com.obsqura.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PushNotificationPage;

public class PushNotificationTest extends Base {
	LoginPage objLogin;
	PushNotificationPage obj;
	@Test 
	public void pushNotificationTest() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		obj=new PushNotificationPage(driver);	
		obj.pushNotificationSend();				
	}
	
	@Test 
	public void pushNotificationResetTest() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		obj=new PushNotificationPage(driver);	
		obj.pushNotificationReset();
	}
	@Test 
	public void pushNotificationLogoutTest() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		obj=new PushNotificationPage(driver);
		obj.pushNotificationAdminLogout();
		
		
	}

}
