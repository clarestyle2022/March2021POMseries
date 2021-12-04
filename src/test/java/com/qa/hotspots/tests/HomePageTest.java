package com.qa.hotspots.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotspots.base.Base;
import com.qa.hotspots.pages.HomePage;
import com.qa.hotspots.pages.LoginPage;
import com.qa.hotspots.utils.Constants;

public class HomePageTest {

WebDriver driver;
Properties prop;
	
	Base base;   
	LoginPage loginPage; 
	HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		base = new Base();
		prop = base.inti_prop();
		driver = base.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=3)
	public void verifyHomePageTile() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page tile is "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title does not matched");
	}
	
	@Test(priority=1)
	public void veriyHomePageHeader() {
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home page header is "+ header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page header is not present");
	}
	
	
	@Test(priority=2)
	public void verifyLoggedInUserTest() {
	String loggedInUser = homePage.getLoggedInUser();
	System.out.println("Logged in user is: " + loggedInUser);
	Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "logged in user is not matched"); 
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
