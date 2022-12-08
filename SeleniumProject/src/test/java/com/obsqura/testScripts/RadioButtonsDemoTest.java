package com.obsqura.testScripts;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.RadioButtonsDemoPage;

public class RadioButtonsDemoTest extends Base {
	RadioButtonsDemoPage obj;
	@Test
	public void radiobuttonCheck() {
		obj=new RadioButtonsDemoPage(driver);
		obj.checkRadioButtonMale();
		obj.checkRadioButtonFemale();
		obj.checkRadioButtonNone();
		obj.RadioButtonGenderGpMale();
		obj.checkRadioButtonFemale();
	}

}
