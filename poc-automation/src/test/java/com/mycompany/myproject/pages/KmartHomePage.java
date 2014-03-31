package com.mycompany.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.HomePageLocators;
import com.mycompany.myproject.locators.KmartHomePageLocators;
import com.mycompany.myproject.locators.KmartProductDetailsPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class KmartHomePage extends KmartHomePageLocators
{
	

	
	private final WebDriver webDriver;
	AbstractPage browser;

	
	public KmartHomePage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}
	
	
	public void verifyKmartHomePage()
	{
		
		if(browser.getTitle().contains(KmartHomePageLocators.TITLE))
		{
			GenericFunctionLibrary.logReport("User is on Kmar Home page", LOG.PASS);

		}
		else
		{
			GenericFunctionLibrary.logReport("User is on Kmart Home page", LOG.FAIL);
			Assert.assertTrue(false);
		}

		browser.verifyObjectOnPage(HEADER_SEARCH_FIELD);
		
	}

	
	public KmartHomePage openKmartApplication()
	{
		browser.openURL("http://www.kmart.com/");
		verifyKmartHomePage();
		return new KmartHomePage(webDriver);
	}
	
	public KmartProductDetailsPage searchProductOnKmartApplication(String productId)
	{
		
		try {
			browser.waitForObjectToAppear(HEADER_SEARCH_FIELD);
			
			browser.clearAndSendKeys(HEADER_SEARCH_FIELD, productId);
			
			browser.click(HEADER_SEARCH_BTN);
			Thread.sleep(2000);
			browser.waitForObjectToAppear(KmartProductDetailsPage.PRODUCT_IMG);
			browser.waitForObjectToAppear(KmartProductDetailsPageLocators.PRODUCT_NAME);
			if (browser.getText(KmartProductDetailsPageLocators.PRODUCT_NAME).contains(productId)) {
				GenericFunctionLibrary.logReport("Successfully searched kmart product id -"+ productId, LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("Product not found on kmart. product id -"+ productId, LOG.FAIL);
			}
			
		} catch (Exception e) {
			
			Assert.assertTrue(false,"Problem in searching product id on kmart site");
		}
		return new KmartProductDetailsPage(webDriver);
	}
	
	public KmartHomePage setLocalAvailabilityZipCode(int zipCode)
	{
		
		try {
			if (browser.isDisplayed(HEADER_EDIT_ZIP_LINK)) {
				browser.waitForObjectToAppear(HEADER_EDIT_ZIP_LINK);
				browser.click(HEADER_EDIT_ZIP_LINK);
				browser.clearAndSendKeys(HEADER_EDIT_ZIP_TF, String.valueOf(zipCode));
				browser.click(HEADER_EDIT_ZIP_GO_BTN);
				browser.waitForPageLoaded();
				browser.waitForObjectToAppear(HEADER_SEARCH_FIELD);
				GenericFunctionLibrary.logReport("Local zip code"+ zipCode +" set successfully", LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("Local zip code to set not available", LOG.PASS);
				System.out.println();
			}
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in setting Local zip code", LOG.FAIL);
			Assert.assertTrue(false,"Problem in setting Local zip code");
			
		}
		
		return new KmartHomePage(webDriver);
	}

	
}
