package com.qa.hotspots.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotspots.base.Base;
import com.qa.hotspots.pages.LoginPage;
import com.qa.hotspots.utils.Constants;

public class LoginPageTest {
	WebDriver driver;
	
	Base base;   // create object of base class
	LoginPage loginPage;      //constructor for loginpage. use to call all the method in loginpage
	Properties prop;
	
		@BeforeTest
		public void setUp() {
			base = new Base();
			prop = base.inti_prop();  // it will give me propertis class object
			driver = base.init_driver(prop);
			loginPage = new LoginPage(driver);
	}

		@Test(priority=2)
		public void verifyLoginPageTitleTest() {
			String title = loginPage.getLoginPageTile();
			System.out.println("login page title is: "+ title);
			Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched..."); // 3rd variable to be displayed is message to be displayed if assery verify failed 
		}
		
		@Test(priority=1)
		public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed..."); //2nd variable to be displayed if assert verify failed 
		}
		
		@Test(priority=3)
		public void loginTest() {
			loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
}
