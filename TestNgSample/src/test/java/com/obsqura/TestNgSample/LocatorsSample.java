package com.obsqura.TestNgSample;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class LocatorsSample extends Base{
	@Test
	public void LocatorSample() {
		
		driver.findElement(By.id("glow-ingress-line2"));
		driver.findElement(By.id("twotabsearchtextbox"));
	}

}

	