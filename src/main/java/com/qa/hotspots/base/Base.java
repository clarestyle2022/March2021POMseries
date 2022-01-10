package com.qa.hotspots.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hotspots.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * @author ClareWilliams
 */
public class Base {
	
	WebDriver driver;
	Properties prop;
	public ElementUtil elementUtil;
	  
	/* this method is used to initialize the WebDriver on the basis of browser
	 * @parameter browserName
	 * @return driver
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName =prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		
		else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		
		return driver;

	}
	
	
	/* 
	 * this method is used to initialize the properties from config.properties files
	 * @return prop
	 * */
	
	public Properties inti_prop() {
		prop = new Properties();     //written this way, this prop is local variable and is only used in this class but because it is declared in the class it becomes global and can be used in any class
	    try {
			FileInputStream ip = new FileInputStream ("./src/main/java/com/qa/hotspots/config/config.properties");  //add confi file location in bracket. but because i waant anyone to be able to use the code when then copy and paset. remvoce my name path and surround with tray catch.   ./ means this is my current project directory, go to src. go to main/java/config properties
		    prop.load(ip);
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return prop;
	}

}
