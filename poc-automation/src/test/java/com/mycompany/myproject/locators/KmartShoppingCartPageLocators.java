package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class KmartShoppingCartPageLocators
{

	public static String TITLE = "Kmart - Shopping Cart";
	
	public static final By ORDER_SUMMARY = By.id("summaryDiv");
	
	public static final By PROCEED_TO_CHECKOUT_BTN = By.id("proceedToCheckout");
	
	public static final By SYWR_COUPON_LABEL = By.cssSelector("#mcSavings .os_label>a");
	
	public static final By SYWR_COUPON_DETAILS_FLYOUT = By.id("srchToolTip");
	
	public static final By ORDER_SUMMARY_TOTAL_SAVING_LINK = By.partialLinkText("Total Savings");
	
	public static final By TOTA_SAVING_FLYOUT = By.id("srchToolTipCont");
	
	public static final By TOTA_SAVING_AMOUNT = By.cssSelector("div.os_total .savings");
	
	
	
}
