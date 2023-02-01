package com.obsqura.testScripts;
import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.SuperMarket7r.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageSliderPage;


public class ManageSliderTest extends Base{
	LoginPage objLogin;
	ManageSliderPage obj;
	HomePage objHome;
	@Test(groups = { "SmokeTest","RegressionTest"})
	public void verfyTitleTest() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		objHome=new HomePage(driver);
		objHome.clickManageSlide();
		obj=new ManageSliderPage(driver);
		obj.verifyTitleOfPage();
	}
	
	@Test
	public void addNewSliderTest() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.adminLogin();
		objHome=new HomePage(driver);
		objHome.clickManageSlide();
		obj=new ManageSliderPage(driver);
		obj.verifyAddNewSlider();
		
	}
		
		
		


}
