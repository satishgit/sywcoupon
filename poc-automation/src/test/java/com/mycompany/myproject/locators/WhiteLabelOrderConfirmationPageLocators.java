package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class WhiteLabelOrderConfirmationPageLocators
{


	public static String TITLE = "ShopYourWay - Checkout Thank You";
	
	public static final By ORDER_CONFIRMATION_MESSAGE = By.cssSelector("div#shoppingcartContents.orderConfirmation div#cart_col1 div.ocpHeader");
	
	public static final By ORDER_CONFIRMATION_NUMBER = By.cssSelector("div#shoppingcartContents.orderConfirmation div#cart_col1 div.ocpHeader span");
	
	public static final By ORDER_CONFIRMATION_ORDER_SUMMARY  = By.id("orderSummary");
	
	
	
		
	
}
