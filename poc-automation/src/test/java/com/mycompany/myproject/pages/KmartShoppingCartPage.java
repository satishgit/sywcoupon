package com.mycompany.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.locators.KmartShoppingCartPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class KmartShoppingCartPage extends KmartShoppingCartPageLocators {

	private final WebDriver webDriver;
	AbstractPage browser;

	
	public KmartShoppingCartPage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}


	public KmartShoppingCartPage verifyCouponAppliedOnKmartShoppingcartPage(String couponName) {

		try {
			browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
			browser.click(By.cssSelector("#mcSavings .os_label>a"));

			if(false==browser.getText(SYWR_COUPON_DETAILS_FLYOUT).contains("Save $.55 on HORMEL®"))
			{
				GenericFunctionLibrary.logReport("Manufacturer coupon not applied on kmart shoppping cart page. Coupon Name: "+couponName, LOG.FAIL);
				Assert.assertTrue(browser.getText(SYWR_COUPON_DETAILS_FLYOUT).contains("Save $.55 on HORMEL®"));
			}
			
			browser.click(ORDER_SUMMARY_TOTAL_SAVING_LINK);
			if(false==browser.getText(TOTA_SAVING_FLYOUT).contains("Save $.55 on HORMEL®"))
			{
				GenericFunctionLibrary.logReport("Manufacturer coupon not applied on kmart shoppping cart page. Coupon Name: "+couponName, LOG.FAIL);
				Assert.assertTrue(browser.getText(SYWR_COUPON_DETAILS_FLYOUT).contains("Save $.55 on HORMEL®"));
			}
			
			GenericFunctionLibrary.logReport("Coupon Name: "+couponName +" Successfully applied Manufacturer coupon on kmart shoppping cart page. total saving on shopping car is - " + browser.getText(TOTA_SAVING_AMOUNT) , LOG.PASS);
			
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Manufacturer coupon not applied on kmart shoppping cart page. Coupon Name: "+couponName, LOG.FAIL);
		}
		return new KmartShoppingCartPage(webDriver);
	}


	public void verifyShoppingCarPage() {
		browser.waitForObjectToAppear(PROCEED_TO_CHECKOUT_BTN);
		Assert.assertTrue(browser.getTitle().contains(TITLE));
	}
	

}
