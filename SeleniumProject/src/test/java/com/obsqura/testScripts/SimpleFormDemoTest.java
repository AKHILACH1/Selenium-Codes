package com.obsqura.testScripts;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.SimpleFormDemoPage;

public class SimpleFormDemoTest extends Base {
	SimpleFormDemoPage obj;

	@Test
	public void enterMsgAndSingleInputField() {
		obj=new SimpleFormDemoPage(driver);
		obj.verifyEnterMessageField();
		obj.twoInputFields();
	}
}
