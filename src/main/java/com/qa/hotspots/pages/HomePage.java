package com.qa.hotspots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotspots.base.Base;
import com.qa.hotspots.utils.Constants;
import com.qa.hotspots.utils.ElementUtil;

public class HomePage extends Base {
	
    private WebDriver driver;
  

	By header = By.cssSelector("h1.private-header__heading"); //home page header 
	By accountName = By.cssSelector("span.account-name ");  
	
	By primaryContactLink = By.id("nav-primary-contacts-branch"); 
	By secondaryContactLink = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}
	
	public String getHomePageHeaderText() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;	
	
	}
	
	public String getLoggedInUser() {
		if(elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	public ContactsPage goToContactPage() {
		clickOnContacts();
		return new ContactsPage(driver);  //encapsulation
		
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementToBeVisible(primaryContactLink, 50);
		elementUtil.doClick(primaryContactLink);
		elementUtil.waitForElementToBeVisible(secondaryContactLink, 10);
		elementUtil.doClick(secondaryContactLink);
	}
}
