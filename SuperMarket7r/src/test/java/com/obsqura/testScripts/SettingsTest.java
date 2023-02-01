package com.obsqura.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;

import com.obsqura.pages.SettingsPage;

public class SettingsTest extends Base {
	LoginPage obj;
	SettingsPage stObj;
	@Test
	public void settingsLogout() throws IOException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		stObj=new SettingsPage(driver);
		stObj.verifyLogout();
	}

}
