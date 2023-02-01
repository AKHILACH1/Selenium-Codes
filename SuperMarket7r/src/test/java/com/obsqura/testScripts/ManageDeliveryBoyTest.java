package com.obsqura.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageDeliveryBoyPage;
import com.obsqura.utilities.DataProviderUtility;

public class ManageDeliveryBoyTest extends Base{
	LoginPage obj;
	ManageDeliveryBoyPage objMd;
	@Test
	public void verifyDeliveryboyPsw() throws IOException, InterruptedException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMd=new ManageDeliveryBoyPage(driver);
		objMd.passwordDetails();
		objMd.addDeliVeryBoyDetails();			
	}
	@Test
	public void verifyDeliveryboynameSearch() throws IOException, InterruptedException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMd=new ManageDeliveryBoyPage(driver);
		objMd.passwordDetails();
		objMd.searchByName();
		
	}
	@Test
	public void verifyAddDeliveryBoyTest() throws IOException, InterruptedException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMd=new ManageDeliveryBoyPage(driver);
		objMd.passwordDetails();		
	}
	
	@Test(dataProvider="NewDeliveryBoyRecord",dataProviderClass=DataProviderUtility.class)
	public void VerifyCreateNewDeliveryBoy(String name,String email,String phoneNumber) throws IOException {
		obj=new LoginPage(driver);
		obj.adminLogin();
		objMd=new ManageDeliveryBoyPage(driver);
		objMd.createNewDeliveryBoy(name, email, phoneNumber);
	}
	

}
