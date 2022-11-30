package com.obsqura.TestNgSample;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class LocatorsSample extends Base{
	@Test
	public void LocatorSample() {
		driver.findElement(By.id("glow-ingress-line2"));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("nav-search-submit-button"));
	}
	@Test
	public void idLocator(){
		driver.findElement(By.id("glow-ingress-line1"));
		}
	@Test	
	public void classLocator(){
		driver.findElement(By.className("nav-logo-link"));
		}
	@Test
	public void nameLocator() {
		driver.findElement(By.name("glow-validation-token"));
	}
	@Test
	public void locatorTagAndId() {
		driver.findElement(By.cssSelector("span#glow-ingress-line1"));
		driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	}
	@Test
	public void LocatorTagAndClass() {
		driver.findElement(By.cssSelector("span.hm-icon-label"));
		driver.findElement(By.cssSelector("input.nav-input.nav-progressive-attribute"));
	}
	@Test
	public void LocatorTagAndAttribute() {
		driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));
		driver.findElement(By.cssSelector("form[name=site-search]"));
	}
	@Test
	public void LocatorTagClassAndAttribute() {
		driver.findElement(By.cssSelector("input.nav-input.nav-progressive-attribute[id=twotabsearchtextbox]"));
	}
	/*@Test
	public void testInnerText() {
		driver.findElement(By.cssSelector("span:contains("Returns")"));
	}*/
	@Test
	public void locXpath() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		driver.findElement(By.xpath("//div[@class='navFooterColHead']"));
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
		driver.findElement(By.xpath("//div[@id='nav-tools']"));
		driver.findElement(By.xpath("//div[@id='nav-cart-text-container']"));
		driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
		driver.findElement(By.xpath("//span[@class='nav-icon nav-arrow']"));
	}
	@Test
	public void indexXpath() {
		driver.findElement(By.xpath("(//div[@class='navFooterColHead'])[2]"));
	}
	
	@Test
	public void linkTextSample() {
		driver.findElement(By.linkText("Checkbox Demo")).click();;
		
	}
	@Test
	public void partialLinkText() {
		driver.findElement(By.partialLinkText("Checkbox")).click();
		
	}
	@Test
	public void xpathText() {
		driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']")).click();
	}
	@Test
		public void idTest() {
		driver.findElement(By.id("twotabsearchtextbox"));
	}
	
	@Test
	public void tagAndIdTest() {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	}
	@Test
	public void xpathTest() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
	}
}	
	