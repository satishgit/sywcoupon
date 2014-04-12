package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class SYWProductDetailsPageLocators
{

	
	public static final By PRODUCT_IMG = By.id("img.product-large-image-holder");
	
	public static final By PRODUCT_NAME = By.cssSelector("h1.product-name");
	
	public static final By PRODUCT_INFO = By.cssSelector(".product-external-info");
	
	public static final By PRODUCT_ADD_TO_CART = By.cssSelector("div.add-to-cart-section div.add-to-cart-button>span");
	
	public static final By GO_TO_CART_LOADING_DIAGOG = By.cssSelector("div#go-to-cart-dialog-container.light-modal div.modal-content div.content-container");
	
	public static final By ITEM_ADDED_DIAGOG_CHECKOUT_BTN = By.cssSelector("#add-to-cart-dialog-container span.view-cart-button");
	
	public static final By SYWR_POINTS = By.cssSelector("div.points-for-item>span.product-rewards-points");
	
	
	
	
	
	
	
		
	
}
