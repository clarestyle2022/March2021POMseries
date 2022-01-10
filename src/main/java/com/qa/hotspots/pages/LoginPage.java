package com.qa.hotspots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotspots.base.Base;
import com.qa.hotspots.utils.Constants;
import com.qa.hotspots.utils.ElementUtil;

public class LoginPage extends Base {
	
	private WebDriver driver;    //private for loging class so no one esle can access 
	
	
		//1. By locators-- OR (object respository) 
	By username =By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn"); 
	By signUpLink = By.linkText("Sign up");
	//By dashboard = By.xpath("//*[contains(text(),\"Go to my dashboard\")]");
	
	//2. create constructor of page class 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);	
	}
	
	//3. page actions
	public String getLoginPageTile() {
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 120);
	}
	
	public boolean verifySignUpLink() {
		return elementUtil.doIsDisplayed(signUpLink);
		
	}
	
	public HomePage doLogin(String username, String password) {
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);
		//elementUtil.doClick(this.dashboard);
	
		return new HomePage(driver);    //this will take you to new home page. this is called page chanining
	}
}


