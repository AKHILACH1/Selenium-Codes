package com.obsqura.utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void clickOnElement(WebElement element) {
		element.click();
		}

		public static WebElement enterText(WebElement element, String value) {
		element.sendKeys(value);
		return element;
		}

		public static String getElementText(WebElement element) {
		return element.getText();
		}

		public static void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
		}

		public static void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}

		public static void selectDropdownbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		}


		public static WebElement enterIntValue(WebElement element, CharSequence[] value) {
		element.sendKeys(value);
		return element;
		}

		public static Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
		}
		
		public static Boolean isElementEnabled(WebElement element) {
			return element.isEnabled();
			
		}
		public static Boolean isEmptyCheck(WebElement element) {
			return element.getText().isEmpty();
			
		}
		
		
		public static String getTitleOfPage(WebDriver driver) {
			return driver.getTitle();
		}
		
		public static Boolean elementIsSelected(WebElement element) {
			return element.isSelected();
		}
		public static void ScrollBy(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,1000)");
		}

		public static void stopPageRefresh(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.stop();");
		}
		
		public static String gettingCurrentUrl(WebDriver driver) {
			return driver.getCurrentUrl();
		}
		public void mediumDelay() throws InterruptedException {
			Thread.sleep(2000);
		}

		public static void pageScroll(int horizontal, int vertical, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");

		}
		
		public static void scrollToTheElement(WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",element);
		}
		
		public static String stylePropertyValidation(WebElement element, String propertyType ) {
			return element.getCssValue(propertyType);
		}
		public static String getCSSValueOfElement(WebElement element, String parameter) {
			return element.getCssValue(parameter);
		}

		public static void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
		}
		
		public static String selectIndexFromDropdown(WebElement element, int indexNumber) {
			Select object = new Select(element);
			object.selectByIndex(indexNumber);
			WebElement selectedElement = object.getFirstSelectedOption();
			return selectedElement.getText();
		}
		public static int selectIndexFromDropdownInteger(WebElement element, int indexNumber) {
			Select object = new Select(element);
			object.selectByIndex(indexNumber);
			WebElement selectedElement = object.getFirstSelectedOption();
			return Integer.parseInt(selectedElement.getText()) ;
		}
		
		public static void selectbyText(WebElement element, String visisbletext) {
			Select select = new Select(element);
			select.selectByVisibleText(visisbletext);
		}
		public static  void sendKeyFunctionforImage(WebElement element, String imageName) {
			element.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\UploadFiles\\" + imageName);
		}

		public static int selectRowFromDynamicTable(List<WebElement> listOfRow, String value) throws Exception {

			int j = 0;
			for (int i = 0; i < listOfRow.size(); i++) {

				if (listOfRow.get(i).getText().equals(value)) {
					j = i;
					break;
				}

				else if (i == listOfRow.size()) {

					throw new ArithmeticException("value not present ");
				}
			}

			return j;

		}
		
		
		
		public String selectValueFromDynamicTable(List<WebElement> listOfRow, String value, String locator) {

			String elementLocator = null;
			for (int i = 0; i < listOfRow.size(); i++) {
				if (listOfRow.get(i).getText().equals(value)) {
					elementLocator = locator;
					break;
				}
			}
			return elementLocator;
		}

		
}
