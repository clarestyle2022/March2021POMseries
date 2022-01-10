package com.qa.hotspots.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hotspots.base.BaseTest;
import com.qa.hotspots.pages.HomePage;
import com.qa.hotspots.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	@BeforeClass
	public void homeSetUP() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void verifyHomePageTile() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page tile is " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title does not matched");
	}

	@Test(priority = 1)
	public void veriyHomePageHeader() {
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home page header is " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page header is not present");
	}

	@Test(priority = 2)
	public void verifyLoggedInUserTest() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user is: " + loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "logged in user is not matched");
	}

}
