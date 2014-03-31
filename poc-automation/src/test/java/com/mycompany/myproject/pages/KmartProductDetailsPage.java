package com.mycompany.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.HomePageLocators;
import com.mycompany.myproject.locators.KmartHomePageLocators;
import com.mycompany.myproject.locators.KmartProductDetailsPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class KmartProductDetailsPage extends KmartProductDetailsPageLocators
{
	

	
	private final WebDriver webDriver;
	AbstractPage browser;

	
	public KmartProductDetailsPage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}
	
	
	public KmartProductDetailsPage verifyKmartProductDetailsPage()
	{
		
		try {
			browser.waitForObjectToAppear(PRODUCT_IMG);
			browser.verifyObjectOnPage(PRODUCT_ADD_TO_CART);
			browser.verifyObjectOnPage(PRODUCT_QTY_BOX);
			
			GenericFunctionLibrary.logReport("User is on Kmart Product details page", LOG.PASS);
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in on Kmart Product details page", LOG.FAIL);
		}
		
		return new KmartProductDetailsPage(webDriver);
	}

	public KmartShoppingCartPage clickAddToCartAndNavigateToShoppingCartPage()
	{
		try {
			browser.waitForObjectToAppear(PRODUCT_ADD_TO_CART);
			browser.clearAndSendKeys(PRODUCT_QTY_BOX, "5");
			browser.click(PRODUCT_ADD_TO_CART);			
			browser.waitForObjectToAppear(ADD_TO_CART_MODAL);
			
			browser.click(ADD_TO_CART_MODAL_VIEW_CART);
			browser.waitForPageLoaded();
			new KmartShoppingCartPage(webDriver).verifyShoppingCarPage();
			GenericFunctionLibrary.logReport("Product successfully added to cart.", LOG.PASS);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new KmartShoppingCartPage(webDriver);
	}
	
	
}
