package com.mycompany.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.HomePageLocators;
import com.mycompany.myproject.locators.SYWProductDetailsPageLocators;
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
	
	
	public HomePage verifyHomePage()
	{
		
		if(browser.getTitle().contains(HomePageLocators.TITLE))
		{
			GenericFunctionLibrary.logReport("User is on Home page", LOG.PASS);

		}
		else
			GenericFunctionLibrary.logReport("User is on Home page", LOG.FAIL);

		browser.verifyPageTitle(HomePageLocators.TITLE);
		browser.verifyObjectOnPage(STATUS_BOX_CONTAINER);
		
		return new HomePage(webDriver);
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


	public void navigateToProductDetailsPage() {

		//This url is hard coded for temporary purpose to initiate whilte label checkout. can be open by product search
		browser.openURL("http://www.shopyourway.com/kenmore-24-built-in-dishwasher-black/162446626");
		
		
		
	}


	public SYWProductDetailsPage searchProduct(String productID) {
		
		try {
			Thread.sleep(9000);
			webDriver.manage().window().maximize(); 
			webDriver.switchTo().defaultContent();
			//webDriver.switchTo().frame("search-form");
			Thread.sleep(5000);
			browser.waitForObjectToAppear(HeaderPageLocators.HEADER_SEARCH_PRODUCTS_TF);
			browser.clearAndSendKeys(HeaderPageLocators.HEADER_SEARCH_PRODUCTS_TF, productID);
			browser.click(HeaderPageLocators.HEADER_SEARCH_IMG_BUTTON);
			browser.waitForObjectToAppear(SYWProductDetailsPageLocators.PRODUCT_IMG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SYWProductDetailsPage(webDriver);
	}

	
	
	public String verifySywrNumberOnRewardProgram() {
		
		
		if(false == browser.isDisplayed(HeaderPageLocators.REWARDS_PROGRAM_ACCOUNT_SECTION))
		{
			browser.waitForObjectToAppear(HeaderPageLocators.HEADER_REWARDS_LINK);
			browser.click(HeaderPageLocators.HEADER_REWARDS_LINK);
		}
		
		browser.waitForObjectToAppear(HeaderPageLocators.REWARDS_PROGRAM_ACCOUNT_SECTION);
		browser.waitForObjectToAppear(HeaderPageLocators.REWARDS_PROGRAM_MEMBERSHIP_INFO);
		String s = browser.getText(HeaderPageLocators.REWARDS_PROGRAM_MEMBERSHIP_INFO);

		if(browser.getText(HeaderPageLocators.REWARDS_PROGRAM_MEMBERSHIP_INFO)!="")
		{
			System.out.println("Verified 16 digit SYWR number on reward program." +s.substring(0,s.indexOf("PIN")) );
			GenericFunctionLibrary.logReport("Verified 16 digit SYWR number on reward program." + s.substring(0,s.indexOf("PIN")) , LOG.PASS);
			browser.click(HeaderPageLocators.REWARDS_PROGRAM_OVERLAY_CLOS_BTN);
		}
			
		return s.substring(0,s.indexOf("PIN"));
	}
	
	
}
