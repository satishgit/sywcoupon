package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class HeaderPageLocators
{
	
	public static final By RECENT_ACTIVITY_TAB = By.partialLinkText("Recent Activity");
	
	public static final By MY_COUPONS_TAB = By.partialLinkText("My Coupons");
	
	public static final By HEADER_SELECTED_TAB = By.id(".tab.selected");
	
	public static final By SIGN_IN_LINK = By.id("open-sign-in-form");
	
	public static final By JOIN_OR_ACTIVATE_LINK = By.id("open-registration-form");
	
	public static final By LOGO_IMAGE = By.id("logo");
	
	public static final By SEARCH_SELECTOR_DROP_DOWN = By.id("search-selector-drop-down");
	
	public static final By  SEARCH_SELECTOR_DROP_DOWN_OPTIONS = By.cssSelector("div#search-selector-drop-down-inner.drop-down-content div.list-container>ul>li");
	 
	public static final By HEADER_SEARCH_PRODUCTS_TF = By.id("search-txt");
	
	public static final By HEADER_SEARCH_IMG_BUTTON = By.id("search-btn");
	
	public static final By PROFILE_LOGO = By.cssSelector("img.lazy-loaded");

	public static final By PROFILE_NAME = By.xpath("#presence span>span.first-name");

	public static final By SIGN_OUT_LINK = By.partialLinkText("Sign-out");


	
	
}
