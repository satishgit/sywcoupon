package com.mycompany.myproject.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest extends WebDriverFactory {

//	private static List<WebDriver> webDrivers = Collections
//			.synchronizedList(new ArrayList<WebDriver>());
//	private static ThreadLocal<WebDriver> driverForThread = new ThreadLocal<WebDriver>() {
//
//		@Override
//		protected WebDriver initialValue() {
//			WebDriver driver;
//
//			WebDriverConfig config = WebDriverConfigLoader.load();
//			driver = createWebDriver(config);
//			webDrivers.add(driver);
//			return driver;
//		}
//	};
//
//	@AfterSuite
//	public static void tearDown() {
//		for (WebDriver driver : webDrivers) {
//			driver.quit();
//		}
//	}
//
////	@BeforeTest
////	public static void launchApplication()
////	{
////		getDriver().get(Configuration.APP_URL);
////	}
////	
//	@AfterMethod
//	public static void clearCookies() {
//
//		System.out.println(getDriver().manage().getCookies());
//
//		getDriver().manage().deleteAllCookies(); 
////		getDriver().close();
//		
////		try {
////			System.out.println("--------  Cookie cleared -------");
////			System.out.println(getDriver().manage().getCookies());
////			getDriver().get("http://www.shopyourway.com/?sid=39");
////			System.out.println(getDriver().manage().getCookies());
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////
////			System.out.println(e.toString());}
//		
//	}
//
	

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	public void init()
	{
		WebDriverConfig config = WebDriverConfigLoader.load();
		driver = createWebDriver(config);
		
		//driver = new FirefoxDriver();
		System.out.println("-----------------------------------------");
	}
	
	
	@AfterMethod
	public void closeTest()
	{
		System.out.println("=================================================");
		driver.close();
		driver.quit();
	}
}