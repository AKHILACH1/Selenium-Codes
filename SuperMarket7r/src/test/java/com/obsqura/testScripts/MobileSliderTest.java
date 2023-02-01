package com.obsqura.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.MobileSliderPage;

public class MobileSliderTest extends Base{
	LoginPage lp;
	HomePage hp;
	MobileSliderPage msp;
	@Test(groups = { "SmokeTest", "RegressionTest" })
	public void verifySlideInformationEntry() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickMobileSliderTab();
		msp=new MobileSliderPage(driver);
		msp.NewButtonEntry();
		
	}
	@Test(groups = { "SmokeTest", "RegressionTest" })
	public void verifyStatus() throws IOException {
		lp=new LoginPage(driver);
		lp.adminLogin();
		hp=new HomePage(driver);
		hp.clickMobileSliderTab();
		msp=new MobileSliderPage(driver);
		msp.chkStatusBtnPresent();
		
	}

}
