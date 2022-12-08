package com.obsqura.testScripts;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.CheckBoxDemoPage;

public class CheckBoxDemoTest extends Base {
	CheckBoxDemoPage obj;
	@Test
	public void checkBoxVerification() {
		obj= new CheckBoxDemoPage(driver);
		obj.checkBox();
		obj.checkBoxes();
		obj.checkBoxesAllSelectOrUnSelect();
	}
	

}
