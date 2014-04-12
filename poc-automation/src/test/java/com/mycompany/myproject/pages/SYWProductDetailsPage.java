package com.mycompany.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.SYWProductDetailsPageLocators;
import com.mycompany.myproject.locators.SearsProductOptionsPageLocators;
import com.mycompany.myproject.locators.WhiteLabelShoppingCartPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class SYWProductDetailsPage extends SYWProductDetailsPageLocators
{
	

	
	private final WebDriver webDriver;
	AbstractPage browser;

	
	public SYWProductDetailsPage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}
	
	public SYWProductDetailsPage verifySYWProductDetailsPage(String productID)
	{
		verifySYWProductDetailsPage();

		if(browser.getText(PRODUCT_INFO).contains(productID))
		{
			GenericFunctionLibrary.logReport("User landed on product details page", LOG.PASS);
		}
		Assert.assertEquals(browser.getText(PRODUCT_INFO).contains(productID), true);
		
		return new SYWProductDetailsPage(webDriver);
	}
	
	public SYWProductDetailsPage verifySYWProductDetailsPage()
	{
		
		try {
			browser.waitForObjectToAppear(PRODUCT_IMG);
			browser.verifyObjectOnPage(PRODUCT_ADD_TO_CART);
			
			GenericFunctionLibrary.logReport("User is on Shop Your way Product details page", LOG.PASS);
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem on verifying Shop your way Product details page", LOG.FAIL);
		}
		
		return new SYWProductDetailsPage(webDriver);
	}

	
	
	
	public WhiteLabelShoppingCartPage clickAddToCartAndNavigateToShoppingCartPage()
	{
		try {
			String productName = getProductName();
			
			browser.waitForObjectToAppear(PRODUCT_ADD_TO_CART);
			browser.click(PRODUCT_ADD_TO_CART);		
			Thread.sleep(2000);
			browser.waitForObjectToAppear(GO_TO_CART_LOADING_DIAGOG);
			if (null!=browser.waitForObjectToAppear(GO_TO_CART_LOADING_DIAGOG)) {
				browser.waitForObjectToAppear(SearsProductOptionsPageLocators.GOT_TO_CART_BTN);
			}
			
			if(browser.isDisplayed(ITEM_ADDED_DIAGOG_CHECKOUT_BTN))
			{
				browser.click(ITEM_ADDED_DIAGOG_CHECKOUT_BTN);
				browser.waitForPageLoaded();

			}
			else if (browser.getTitle().contains(SearsProductOptionsPageLocators.TITLE))
			{
				browser.waitForPageLoaded();
				new SearsProductOptionsPage(webDriver)
						.verifySearsProductOptionsPage(productName)
						.navigateToSearsShoppingCartPage();
			}
			
			GenericFunctionLibrary.logReport("Product successfully added to cart.", LOG.PASS);

			
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in adding Product to cart.", LOG.FAIL);
		}
		
		return new WhiteLabelShoppingCartPage(webDriver);
	}

	public String getProductName() {

		browser.waitForObjectToAppear(PRODUCT_NAME);
		
		return browser.getText(PRODUCT_NAME);
	}
	
	
}
