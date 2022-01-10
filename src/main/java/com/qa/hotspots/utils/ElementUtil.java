package com.qa.hotspots.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elementsList = driver.findElements(locator);
		return elementsList;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			System.out.println("locator is : " + locator);
			element = driver.findElement(locator);
			System.out.println("WebElement is created successfully: " + locator);

		} catch (Exception e) {
			System.out.println("some exception got occourred with locator : " + locator);
		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
		
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	
	//clcikWhenReady   can be used instead of waitfor visible
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public WebElement switchFrame (By locator) {
		WebElement frameElement = getElement(locator);
		return frameElement;
		
	}
		

}
