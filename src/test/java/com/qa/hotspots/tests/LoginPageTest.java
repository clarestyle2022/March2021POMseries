package com.qa.hotspots.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.hotspots.base.BaseTest;
import com.qa.hotspots.utils.Constants;

public class LoginPageTest extends BaseTest{
	
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
		
		public void moblile() {
			
		}
		
	
}
