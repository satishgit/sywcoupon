package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class MyCouponsPageLocators
{

	public static final String PAGE_TITLE = "My Coupons | ShopYourWay";  
	
	public static final By MY_COUPONS_TAB = By.cssSelector(".tabs .myCoupons>a");
	
	public static final By MY_COUPONS_COUNT = By.cssSelector(".tabs .myCoupons>a .couponCount");
	
	public static final By COUPON_CENTER_TAB = By.cssSelector(".tabs .shcCoupons");
	
	public static final By REMOVE_ALL_COUPONS_LINK = By.cssSelector("a.couponRemoveAll");
	
	public static final By REMOVE_ALL_COUPONS_CONFIRMATION_MODAL = By.id("theModalConfirm");
	
	public static final By REMOVE_ALL_CONFIRMATION_YES_BTN = By.id("confirmRemoveAll");
	
	
	
	public static final By COUPON_CENTER_COUPON_LIST_TABEL = By.cssSelector("div#coupon-container1.coupon-container ul.coupon-list");
	
	public static final By MY_CENTER_COUPON_LIST_TABEL = By.cssSelector("div.appcontent section.coupon-container ul.coupon-list");
	
	public static final By LOGIN_FORM_SIGN_IN_BUTTON   = By.id("register-form");
	
}
