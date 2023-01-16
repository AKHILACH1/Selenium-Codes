package com.obsqura.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;

	public static void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForInvisibilityOfElementLocated(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(target));
	}

	public static void waitForElementClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
		
	}
	
	public static void waitForElementToBeSelected(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(target));
	}
	public static void waitForVisibilityOfElementLocated(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(target));
	}
	public static void waitForElementSelectionStateToBe(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementSelectionStateToBe(target, false));
	}
	public static void waitFortextToBe(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBe(target," "));
	}
	public static void waitForframeToBeAvailableAndSwitchToIt(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(target));
	}
	public static void waitForpresenceOfAllElementsLocatedBy(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(target));
	}
	public static void waitForpresenceOfElementsLocatedBy(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(target));
	}
}
