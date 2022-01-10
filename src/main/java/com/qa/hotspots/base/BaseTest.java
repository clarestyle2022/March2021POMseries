package com.qa.hotspots.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.hotspots.pages.LoginPage;

public class BaseTest {
	
    public WebDriver driver;
	
	public Base base;  
	public LoginPage loginPage;      
	public Properties prop;
	
		@BeforeTest
		public void setUp() {
			base = new Base();
			prop = base.inti_prop();  
			driver = base.init_driver(prop);
			loginPage = new LoginPage(driver);
		}
		
			@AfterTest
			public void tearDown() {
				//driver.quit();
			}
	
}
