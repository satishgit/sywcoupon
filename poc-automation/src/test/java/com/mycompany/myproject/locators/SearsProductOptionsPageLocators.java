package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class SearsProductOptionsPageLocators
{

	public static final String TITLE = "ShopYourWay - Product Options";
	
	public static final By PRODUCT_IMAGE = By.cssSelector("a.PO_image");
	
	public static final By GOT_TO_CART_BTN = By.partialLinkText("Go to Cart");
	
	public static final By ZIP_CODE_TF = By.id("install_zip");
	
	public static final By ZIP_SUBMIT_GO_BTN = By.id("zip_submit");
	
	public static final By CONFIRMED_ZIP_CODE = By.id("confirmedZipCode");
	
	public static final By CHANGE_LOCATION_BTN = By.id("change_location");
	
	public static final By CHANGE_ZIP_LINK = By.cssSelector("a.zipChangeLnk");
	
	
	
	
	public static final By PRODUCT_ORDER_SUMMARY = By.cssSelector("form#productOptionsDetails div.PO_Summary");
	
	public static final By PROTECTION_MODAL = By.cssSelector("div.shcModal");
	
	public static final By  WITHOUT_COVERAGE_BTN = By.cssSelector("#POPAnoOpt>button");
	
	
	
	
	
	
	
	
}
