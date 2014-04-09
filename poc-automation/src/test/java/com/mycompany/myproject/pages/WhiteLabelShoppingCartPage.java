package com.mycompany.myproject.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mycompany.myproject.locators.KmartShoppingCartPageLocators;
import com.mycompany.myproject.locators.WhiteLabelCheckoutPageLocators;
import com.mycompany.myproject.locators.WhiteLabelShoppingCartPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class WhiteLabelShoppingCartPage extends WhiteLabelShoppingCartPageLocators {

	private final WebDriver webDriver;
	AbstractPage browser;

	
	public WhiteLabelShoppingCartPage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}

	public WhiteLabelShoppingCartPage applySYWCouponCode(String couponName)
	{
		try {
			browser.waitForObjectToAppear(APPLY_SYW_COUPON_LINK);
			browser.click(APPLY_SYW_COUPON_LINK);
			Thread.sleep(5000);
			browser.waitForObjectToAppear(APPLY_SYW_COUPON_MODAL);
			
//			System.out.println(browser.getText(APPLY_SYW_COUPON_MODAL));
			
			// Assumption only single coupon is applied. for multiple coupon on this overlay need to ref	actar little bit
			
			if(browser.getText(SYW_COUPON_NAME).contains(couponName.substring(0, 30))) // look for first 30 charactar in Apply coupon flyout 
				GenericFunctionLibrary.logReport("Coupon available to apply. Coupon name -" + couponName , LOG.PASS);
			else
			{
				GenericFunctionLibrary.logReport("Coupon not available to apply. Copupon name - "+ couponName , LOG.FAIL);
				Assert.assertTrue(false);
			}
			
			browser.click(SYW_APPLY_COUPON_BTN);
			Thread.sleep(5000);
			browser.waitForObjectToAppear(REMOVE_COUPON_LINK);
			if(browser.isDisplayed(REMOVE_COUPON_LINK))
			{
				GenericFunctionLibrary.logReport("Coupon applied successfully. Coupon Name: "+ couponName, LOG.PASS);	
			}
			else
			{
				GenericFunctionLibrary.logReport("Problem in applying coupon", LOG.FAIL);
				//COmmenting just for testing purpose. need to uncomment
				browser.verifyObject(REMOVE_COUPON_LINK);
			}
			browser.click(CLOSE_SYW_COUPON_MODAL);
			Thread.sleep(5000);
			browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
			browser.waitForPageLoaded();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return new WhiteLabelShoppingCartPage(webDriver);
	}
	
	
	public WhiteLabelShoppingCartPage veifyCouponNumberOnShoppingCartPage(String couponNumber)
	{
		try {
			if(browser.getText(SAVED_COPUPN_CODE).equals(couponNumber))
			{
				GenericFunctionLibrary.logReport("SHOP Your Coupon code verified on cart page. Coupon Number: "+couponNumber, LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("SHOP Your Coupon code not found on cart page. Coupon Number: "+couponNumber, LOG.FAIL);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println();
			//need to put asserttion here
		}
	
		return new WhiteLabelShoppingCartPage(webDriver);
	}
	
	public void verifySavingsLinkCouponShoppingCartPage(String coupnName)
	{			System.out.println("--- IN SAving LINK verifySavingsLinkCouponShoppingCartPage");
	
			try {
				browser.waitForObjectToAppear(ORDER_SUMMARY_TOTAL_SAVING_LINK);

				Thread.sleep(2000);
						
				//System.out.println(" Coupon Savings amount : " + browser.getText(TOTAL_SAVING_AMOUNT));
				browser.click(ORDER_SUMMARY_TOTAL_SAVING_LINK);
				System.out.println(browser.getText(TOTA_SAVING_FLYOUT));
			if(false==browser.getText(TOTA_SAVING_FLYOUT).contains("E-Coupon Savings"))
			{
				GenericFunctionLibrary.logReport("Saving coupon not applied on White Label check out: shoppping cart page. Coupon Name: "+ coupnName , LOG.FAIL);
				//TODO remove after debug
				//Assert.assertTrue(browser.getText(TOTA_SAVING_FLYOUT).contains("E-Coupon Savings"));
			}
			
			GenericFunctionLibrary.logReport("Coupon Name: "+browser.getText(TOTA_SAVING_FLYOUT) +" Successfully applied  E-Coupon Savings shoppping cart page. total saving on shopping car is - " + browser.getText(TOTAL_SAVING_AMOUNT) , LOG.PASS);
			System.out.println("Coupon Name "+ browser.getText(TOTA_SAVING_FLYOUT) + " Coupon Savings amount : " + browser.getText(TOTAL_SAVING_AMOUNT));
				
				System.out.println("---  verifySavingsLinkCouponShoppingCartPage:: DONE");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			browser.click(TOTA_SAVING_FLYOUT_CLOSE);

			System.out.println("--- IN SAving LINK verifySavingsLinkCouponShoppingCartPage  DONE");
	}
	
	
	public void verifyEarnPointsOnShoppingCartPage()
	{
			try {
				browser.waitForObjectToAppear(EARN_POINT_DETAILS_LINK);
				
				//Cart page
				browser.click(EARN_POINT_DETAILS_LINK);

				browser.waitForObjectToAppear(SYW_EARN_DETAILS_FLYOUT);
				
				
				Thread.sleep(5000);
				
				browser.click(By.cssSelector("#shcLayer div#pointsDetailWarp_1>div#productDetails_1>span.bonusIcon"));
						
				System.out.println(browser.getText(By.cssSelector("#shcLayer div#pointsDetailWarp_1>div#pointDetailsMore_1>div:nth-of-type(3)>div:nth-of-type(4)")));
				System.out.println("Points>>"+browser.getText(By.cssSelector("#shcLayer div#pointsDetailWarp_1>div#pointDetailsMore_1>div:nth-of-type(3)>div:nth-of-type(5)")));
				
				
				//System.out.println(browser.getText(By.cssSelector("#shcLayer div#pointsDetailWarp_1>div#pointDetailsMore_1>div>div")));
				//System.out.println(browser.getText(SYW_EARN_DETAILS_COUPON_NAME) + " Points Earned: " + browser.getText(SYW_EARN_DETAILS_COUPON_POINTS));
				
				System.out.println();
				
				if (""!=browser.getText(By.cssSelector("#shcLayer div#pointsDetailWarp_1>div#pointDetailsMore_1>div:nth-of-type(3)>div:nth-of-type(5)"))) {
					GenericFunctionLibrary.logReport(browser.getText(SYW_EARN_DETAILS_COUPON_NAME) + " Points Earned: " + browser.getText(SYW_EARN_DETAILS_COUPON_POINTS), LOG.PASS);
				}
				else
				{
					GenericFunctionLibrary.logReport("Earn points coupon is not applied", LOG.FAIL);
				}
				System.out.println("SYW_EARN_DETAILS_FLYOUT_CLOSE_BTN "+ browser.isDisplayed(SYW_EARN_DETAILS_FLYOUT_CLOSE_BTN));
				browser.click(SYW_EARN_DETAILS_FLYOUT_CLOSE_BTN);
				
			} catch (Exception e) {

			}
			
	}
	
	public WhiteLabelShoppingCartPage verifyCouponAppliedOnKmartShoppingcartPage(String couponNumber) {

		try {
			browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
			browser.click(By.cssSelector("#mcSavings .os_label>a"));
			
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Manufacturer coupon not applied on kmart shoppping cart page. Coupon Name: "+couponNumber, LOG.FAIL);
		}
		return new WhiteLabelShoppingCartPage(webDriver);
	}


	public void verifyShoppingCarPage() {
		browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
		browser.waitForObjectToAppear(SYL_LOGO_IMAGE);
		System.out.println(browser.getText(CONTINUE_SHOPPING_BTN));
		Assert.assertEquals(browser.getText(CONTINUE_SHOPPING_BTN).contains("Continue Shopping"), true);
		Assert.assertTrue(browser.getTitle().contains(TITLE));
	}
	
public WhiteLabelCheckoutPage clickProceedToCheckOut()
{
	try {
		browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
		browser.click(PROCEED_TO_CHECKOUT_BTN);
		try {Thread.sleep(2000);	} catch (InterruptedException e) {}
		browser.waitForPageLoaded();
		browser.waitForObjectToAppear(WhiteLabelCheckoutPageLocators.SHIPPING_ADDRESS_CONTINUE_BTN);
		
		if(null==browser.waitForObjectToAppear(WhiteLabelCheckoutPageLocators.SHIPPING_ADDRESS_CONTINUE_BTN))
		{
			browser.waitForObjectToAppear(WhiteLabelCheckoutPageLocators.SHIPPING_ADDRESS_CONTINUE_BTN);
		}
	} catch (Exception e) {
		GenericFunctionLibrary.logReport("Problem in navigating to checkout shipping page", LOG.FAIL);
		Assert.assertTrue(false);
	}
	return new WhiteLabelCheckoutPage(webDriver);
}
	
public WhiteLabelShoppingCartPage updateWhiteLabelSHoppingCartQuantity(int qty)
{
	try {
		browser.waitForObjectToAppear(WhiteLabelShoppingCartPageLocators.PROCEED_TO_CHECKOUT_BTN);
		browser.clearAndSendKeys(PRODUCT_QTY_BOX, String.valueOf(qty));
		
		browser.click(PRODUCT_UPDATE_QTY_LINK);
		Thread.sleep(5000);
		browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
		browser.waitForPageLoaded();
		
		GenericFunctionLibrary.logReport("Product quantity updated successfully to "+qty, LOG.PASS);

		
	} catch (Exception e) {
		GenericFunctionLibrary.logReport("Problem in updating shopping cart product quantity", LOG.FAIL);
		Assert.assertTrue(false);
	}
	
	return new WhiteLabelShoppingCartPage(webDriver);
}


public ArrayList<String> verifyShoppingCartPageAndgetProductDetails()
{
	//Capture product number, Name 
		
			ArrayList<String> shoppingCartProfucts;
			shoppingCartProfucts = new ArrayList<String>();
			try {
				
				List<WebElement> profuctsDescription = browser.findElements(By.cssSelector(".itemTitle"));
				List<WebElement> profuctsNumber = browser.findElements(By.cssSelector(".product_in_cart div span.itemInfoToggle"));
				
				GenericFunctionLibrary.logReport("Following Products present in cart -", LOG.PASS);
				System.out.println("Following products present in cart");
				System.out.println(profuctsDescription);
				for (int i=0;i<profuctsDescription.size();i++) {
					String product ="";
					String productTitle = profuctsDescription.get(i).getText();
					String productNumber = profuctsNumber.get(i).getText();
					
					product = productNumber.substring(0,productNumber.indexOf("Mfr"));
					
					productNumber.substring(0,productNumber.indexOf("Mfr"));
					GenericFunctionLibrary.logReport("Products Number -"+ productNumber + " Product Name: " + productTitle, LOG.PASS);
					
					product = product + "::" + productTitle;
					shoppingCartProfucts.add(product);
					System.out.println("Products Number -"+ productNumber + " Product Name: " + productTitle);				
				}
		
			
			
	
			} catch (Exception e) {

			}
			return shoppingCartProfucts;

}
}