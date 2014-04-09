package com.mycompany.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.SearsProductOptionsPageLocators;
import com.mycompany.myproject.locators.WhiteLabelShoppingCartPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class SearsProductOptionsPage extends SearsProductOptionsPageLocators {

	private final WebDriver webDriver;
	AbstractPage browser;

	public SearsProductOptionsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		browser = new AbstractPage(webDriver);

	}

	public SearsProductOptionsPage verifySearsProductOptionsPage() {

		try {
			if (browser.getTitle().contains(
					SearsProductOptionsPageLocators.TITLE)) {
				GenericFunctionLibrary.logReport(
						"User is on Sears Product options pagepage", LOG.PASS);

			} else {
				GenericFunctionLibrary
						.logReport(
								"Problem in navigating to Sears Product options pagepage",
								LOG.FAIL);
				Assert.assertTrue(false);
			}

			browser.verifyObjectOnPage(PRODUCT_IMAGE);
			browser.verifyObjectOnPage(GOT_TO_CART_BTN);
			browser.verifyObjectOnPage(PRODUCT_ORDER_SUMMARY);
		} catch (Exception e) {
			Assert.assertTrue(false,
					"Problem in navigating to product options page");
		}

		return new SearsProductOptionsPage(webDriver);
	}



	public WhiteLabelShoppingCartPage navigateToSearsShoppingCartPage()
	{
		try {
			
			//set zip code to 60602
			if(browser.isDisplayed(ZIP_CODE_TF))
			{
				browser.clearAndSendKeys(ZIP_CODE_TF, "60602");
				browser.click(GOT_TO_CART_BTN);
				browser.waitForObjectToAppear(CONFIRMED_ZIP_CODE);
			}
			
			browser.waitForObjectToAppear(GOT_TO_CART_BTN);
			browser.click(GOT_TO_CART_BTN);
			browser.waitForObjectToAppear(PROTECTION_MODAL);
			System.out.println();
			if(browser.isDisplayed(PROTECTION_MODAL))
			{
				browser.click(WITHOUT_COVERAGE_BTN);
				browser.waitForPageLoaded();
			}
			browser.waitForObjectToAppear(WhiteLabelShoppingCartPageLocators.PROCEED_TO_CHECKOUT_BTN);
			
		
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
			
		return new WhiteLabelShoppingCartPage(webDriver);
	}
	
}
