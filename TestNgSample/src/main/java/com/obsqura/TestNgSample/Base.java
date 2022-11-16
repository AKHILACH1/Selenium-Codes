package com.obsqura.TestNgSample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public WebDriver driver;

	@BeforeTest
	public void InitializeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Akhila\\obsquraJava\\TestNgSample\\src\\main\\java\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
	}

	public void browserClose() {
		driver.close();
	}

	@AfterTest
	public void browserQuit() {
		driver.quit();
	}

}
