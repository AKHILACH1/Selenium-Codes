package com.obsqura.testScripts;

import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageProductPage;

public class ManageProductTest extends Base{
	ManageProductPage obj;
	LoginPage objLogin;
	
	@Test
	public void ManageProductTestMethod() throws IOException {
		
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		obj=new ManageProductPage(driver);
		
		
	}

}
