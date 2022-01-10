package com.qa.hotspots.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSUtil {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		System.out.println(jsUtil.getTitleByJS);
		
		
		//methods not avaliable in selenium 
		jsUtil.generateAlert("this is my pop up");  // this will generate alert popup
		jsUtil.refreshBrowserByJS();  // to refresh page or history.go(0)
		
		String pageText = jsUtil.getPageInnerText();   // get all text in web page
		System.out.println(pageText);
		if(pageText.contains("companies & contacts")){
			System.out.println("pass");
		}
		
		System.out.println(jsUtil.getBrowserInfo());
		
		WebElement login = driver.findElement(By.xpath("//input[@class =\"btn btn-small\"]"));
		jsUtil.flash(login); // this will flash hilight the login button 100x  it shows you where the driver is when interaction wiht your auto script 
		
		
		jsUtil.clickElementByJS(login); //clikc
		
		
		jsUtil.sendKeysUsingJSWithID("username", "clarestyle1");   //send keys example
		jsUtil.sendKeysUsingJSWithID("password", "orange");
		
		
		jsUtil
		
		
		
		
		

	}

}
