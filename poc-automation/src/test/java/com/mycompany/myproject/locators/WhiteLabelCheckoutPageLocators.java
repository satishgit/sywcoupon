package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class WhiteLabelCheckoutPageLocators
{

	public static String TITLE = "ShopYourWay Checkout";
	
	public static final By SHIPPING_ADDRESS_CONTINUE_BTN = By.cssSelector("#ShipForm2 button.continue");
	
	public static final By PAYMENT_SECURITY_CODE_TF = By.cssSelector("#securityCodeSavedCC");
	
	public static final By PAYMENT_CHOOSE_AN_ADDRESS_LINK = By.partialLinkText("Choose an Address");
	
	public static final By PAYMENT_CHOOSE_THIS_ADDRESS_LINK = By.partialLinkText("Choose This Address");
	
	public static final By PAYMENT_CHOOSE_ANOTHER_ADDRESS_LINK = By.partialLinkText("Choose Another Address");
	
	public static final By PAYMENT_REVIEW_ORDER_BTN = By.cssSelector("div#reviewButton>button>span");
	
	public static final By PAYMENT_PLACE_ORDER_NOW_BTN =By.cssSelector("#orderButton>button>span");
	
	public static final By REVIEW_PLACE_ORDER_NOW_BTN =By.cssSelector("#placeOrderBtn>span");
	
	
	public static final By EARN_POINT_DETAILS_LINK = By.cssSelector(".sywMainDetails");
	
	public static final By SYW_EARN_DETAILS_FLYOUT = By.cssSelector("div#shcLayer.sywrTTinfoNew");

	public static final By ORDER_SUMMARY_TOTAL_SAVING_LINK = By.partialLinkText("Total Savings");
	
	public static final By TOTA_SAVING_FLYOUT = By.id("srchToolTipCont");
	
	public static final By TOTAL_SAVING_AMOUNT = By.cssSelector("div#totalSavings>div.os_total .savings");
	
	public static final By CHECKOUT_BREADCRUMB_REVIEW_SELECTED = By.cssSelector("#REVIEW.selected>a");
	
	public static final By CHECKOUT_REVIEW_SHIPPING_ITEM = By.cssSelector(".shippingItem .items_title");
	
	public static final By CHECKOUT_PAYMENT_PAGE_SAVED_CARD_NUMBER = By.cssSelector(".savedCCNumber>strong");
	
	public static final By CHECKOUT_PAYMENT_PAGE_MASKED_SYWR_NUMBER = By.cssSelector("span#sywrgCardNumber");
	
	public static final By CHECKOUT_PAGE_ACTIVE_BAR = By.cssSelector("h2.selected");
	
	public static final By CHECKOUT_SHIPPIN_PAGE_SHIPPING_ITEM = By.cssSelector(".itemName>strong");
	
	public static final By SYW_EARN_DETAILS_FLYOUT_CLOSE_BTN = By.cssSelector("#shcLayer .close");
	
	public static final By TOTA_SAVING_FLYOUT_CLOSE = By.cssSelector("#checkoutToolTip #clsBtn");
		
	
	
	
	
	
	
	
		
	
}
