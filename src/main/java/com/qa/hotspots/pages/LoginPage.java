package com.qa.hotspots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotspots.base.Base;

public class LoginPage extends Base {
	
	private WebDriver driver;    //private for loging class so no one esle can access 
	
		//1. By locators-- OR (object respository) 
	By username =By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn"); 
	By signUpLink = By.linkText("Sign up");
	By dashboard = By.xpath("//*[contains(text(),\"Go to my dashboard\")]");
	
	//2. create constructor of page class 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	
	//3. page actions
	public String getLoginPageTile() {
		return driver.getTitle();	
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);    // use this keyword to let system diffctiate between by username and by.id uwername
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
		driver.findElement(this.dashboard).click();
	
		
		return new HomePage(driver);    //this will take you to new home page. this is called page chanining
	}
}


