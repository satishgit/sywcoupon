package com.mycompany.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.HomePageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class HomePage extends HomePageLocators
{
	

	
	private final WebDriver webDriver;
	AbstractPage browser;

	
	public HomePage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}
	
	
	public void verifyHomePage()
	{
		
		if(browser.getTitle().contains(HomePageLocators.TITLE))
		{
			GenericFunctionLibrary.logReport("User is on Home page", LOG.PASS);

		}
		else
			GenericFunctionLibrary.logReport("User is on Home page", LOG.FAIL);

		browser.verifyPageTitle(HomePageLocators.TITLE);
		browser.verifyObjectOnPage(STATUS_BOX_CONTAINER);
	}

	public void clickOnMyCouponTab()
	{
		browser.click(HeaderPageLocators.MY_COUPONS_TAB);
	}
	
	public void openKmartApplication()
	{
		browser.openURL("http://www.kmart.com/");
		if(browser.getTitle().contains(""))
		{
			GenericFunctionLibrary.logReport("www.kmart.com loaded sucessfully ", LOG.PASS);
		}
		else
		{
			GenericFunctionLibrary.logReport("Problem in loading www.kmart.com", LOG.FAIL);
			Assert.assertTrue(false);
		}
	}
	
	
}
