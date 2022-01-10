package com.qa.hotspots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotspots.base.Base;
import com.qa.hotspots.utils.Constants;
import com.qa.hotspots.utils.ElementUtil;

public class ContactsPage extends Base {
	private WebDriver driver;

	
	By header = By.cssSelector("h1.private-header__heading");
	By createContactPrimary = By.xpath("//span[text()= 'Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field=\"firstname\"]");
	By lastName = By.xpath("//input[@data-field=\"lastname\"]");
	By jobTile = By.xpath("//textarea[@data-field =\"jobtitle\"]");
	By createContatSecondary = By.xpath("(//span[text()= 'Create contact'])[last()]");  //same xpather as primary but 'last'indicates it will go to the last (2of2)
	By switchtoFormFrame = (By.xpath("//iframe[@data-host-create-panel-type = \"CONTACT\"]"));
	
	/*
	 * WebElement frameElement = driver.findElement(By.
	 * xpath("//iframe[@data-host-create-panel-type = \"CONTACT\"]"));
	 * driver.switchTo().frame(frameElement);
	 */
	

public ContactsPage(WebDriver driver) {
	this.driver = driver;
	elementUtil = new ElementUtil(this.driver);
}

public String getContactsPageTitle() {
	return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
}

public String getContactsPageHeader() {
	elementUtil.waitForElementToBeVisible(header, 10);
	return elementUtil.doGetText(header);
}


public void createContact(String email, String firstName, String lastName, String jobTitle) {
	
	//elementUtil.waitForElementToBeVisible(createContactPrimary, 10);
	//elementUtil.doClick(createContactPrimary);   or
	elementUtil.clickWhenReady(createContactPrimary, 10);
	
	WebElement frameElement = driver.findElement(By.xpath("//iframe[@data-host-create-panel-type = \"CONTACT\"]"));
	driver.switchTo().frame(frameElement);

	elementUtil.waitForElementToBeVisible(this.email, 60);
	elementUtil.doSendKeys(this.email, email);
	elementUtil.doSendKeys(this.firstName, firstName);
	elementUtil.doSendKeys(this.lastName, lastName);
	
	elementUtil.waitForElementToBeVisible(this.jobTile, 10);
	elementUtil.doSendKeys(this.jobTile, jobTitle);

	
	elementUtil.clickWhenReady(createContatSecondary, 10);    //this methid can also be used instead of waitto be vidible method/ can do the same for sendkey
	
}


}
