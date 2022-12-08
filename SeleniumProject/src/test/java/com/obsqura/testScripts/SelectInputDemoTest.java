package com.obsqura.testScripts;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.SelectInputDemoPage;

public class SelectInputDemoTest extends Base {
	SelectInputDemoPage obj;
	@Test
	public void selectCheck() {
		obj=new SelectInputDemoPage(driver);
		obj.SelectByIndex();
		obj.SelectByValue();
		obj.selectByVisibleTextByAnyInput();
		obj.selectByVisibleTextSample();
		obj.multipleSample();
		obj.multipleSample1();
		obj.listSample();
	}

}
