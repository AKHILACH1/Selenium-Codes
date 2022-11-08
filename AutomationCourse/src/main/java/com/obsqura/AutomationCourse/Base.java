package com.obsqura.AutomationCourse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base 
	{
	public WebDriver driver;
	public void InitializeBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Akhila\\obsquraJava\\AutomationCourse\\src\\main\\java\\Resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}
	public void browserCommands() {
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String title=driver.getTitle();
		if(expectedTitle.equals(title))
		{
			System.out.println("Titles are equal");
		}
		else {
			System.out.println("Titles are not equal");
		}
		
	}
	public void browserClose() {
		driver.close();
	}
	
	public void getUrl() {
		String url=driver.getCurrentUrl();
	
	
	}
	public void PageSource() {
		String pageSource=driver.getPageSource();
		System.out.println(pageSource);
	}
	public void browserQuit() {
		driver.quit();
	}
	
	public static void main(String args[]){
		Base obj=new Base();
		obj.InitializeBrowser();
		obj.browserCommands();
		//obj.browserClose();
		obj.getUrl();
		obj.PageSource();
		obj.browserQuit();
	
		
	}

	}
