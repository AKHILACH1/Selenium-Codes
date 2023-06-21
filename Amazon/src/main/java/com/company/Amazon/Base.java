package com.company.Amazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static void main(String[] args) throws InterruptedException{
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(ops);
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("Apple iPhone 14 Pro Max (128 GB) - Space Black");
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		Thread.sleep(5000);
		String text=driver.findElement(By.xpath("//h2//a//span[contains(text(),'Apple iPhone 14 Pro Max (128 GB) - Space Black')]//ancestor::h2//parent::div//parent::div//child::div[3]//a//span[@class='a-price-whole']")).getText();
		System.out.println(text);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();

	}
}