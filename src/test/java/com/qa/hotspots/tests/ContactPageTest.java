package com.qa.hotspots.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hotspots.base.BaseTest;
import com.qa.hotspots.pages.ContactsPage;
import com.qa.hotspots.pages.HomePage;
import com.qa.hotspots.utils.Constants;

public class ContactPageTest extends BaseTest {

	HomePage homepage;
	ContactsPage contactsPage;

	@BeforeClass
	public void contactsSetup() {
		homepage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homepage.goToContactPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is : " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void creatContactTest() {
		contactsPage.createContact("janevffhite@hotmail.com", "Jjjanet", "White", "SDET Manager"); // hard coding or below is the right way
		//contactsPage.createContact(prop.getProperty("email"), prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("JobTitle"));  // working but not title- wait for visible

	}
}