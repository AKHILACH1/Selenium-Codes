package com.obsqura.SuperMarket7r;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
	public Properties prop ,prop1;
	public FileInputStream fs,fs1;
	@BeforeMethod
	@Parameters("browser")

	public void InitializeBrowser(String browser) throws Exception {
		prop=new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			prop.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		prop1=new Properties();

		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);


		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			prop1.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") +constants.Constants.chrome	);
				//create chrome instance
				driver = new ChromeDriver();
			}
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){
						//set path to Edge.exe
						System.setProperty("webdriver.edge.driver",
								System.getProperty("user.dir") +constants.Constants.edge);
						//create Edge instance
						driver = new EdgeDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
		
		
		//System.setProperty("webdriver.chrome.driver",
				//System.getProperty("user.dir") +constants.Constants.chrome	);
		//driver = (WebDriver) new ChromeDriver();
		driver.get(prop.getProperty("url"));

	}

	public void browserClose() {
		driver.close();
	}

	@AfterMethod
	public void browserQuit() {
		driver.quit();
	}
}
