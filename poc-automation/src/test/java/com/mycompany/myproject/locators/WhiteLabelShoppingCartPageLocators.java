package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class WhiteLabelShoppingCartPageLocators
{

	public static String TITLE = "ShopYourWay - Shopping Cart";
	
	
	public static final By SYL_LOGO_IMAGE = By.cssSelector("img.syw-logo");
	
	public static final By CONTINUE_SHOPPING_BTN = By.cssSelector("#presence");
	
	
	
	public static final By ORDER_SUMMARY = By.id("summaryDiv");
	
	public static final By CART_PRODUCT_INFO = By.cssSelector("table.sci_productInfo");
	
	public static final By PROCEED_TO_CHECKOUT_BTN = By.id("proceedToCheckout");
	
	public static final By PRODUCT_QTY_BOX = By.id("quantity_1");
	
	public static final By PRODUCT_UPDATE_QTY_LINK = By.partialLinkText("Update");
	
	
	
	
	public static final By APPLY_SYW_COUPON_LINK = By.cssSelector("div#myClippedDeals>a.dccmLaunchClippedDeals");
	
	public static final By APPLY_SYW_COUPON_MODAL = By.cssSelector("div#dcClipperModalContentWrp");
	
	public static final By SYW_COUPON_NAME = By.cssSelector("div#dcClipperModalContentWrp ul#dcmcDealsWrp li.dcmcIndvDealWrp ul li.dcmcTitle");
	
	public static final By SYW_APPLY_COUPON_BTN = By.cssSelector("div#dcClipperModalContentWrp li.dcmcIndvDealWrp ul li.dcmcButton a.shcBtn");
	
	public static final By REMOVE_COUPON_LINK = By.cssSelector("div#dcClipperModalContentWrp  li.dcmcIndvDealWrp ul li.dcmcRemove a");
	
	public static final By CLOSE_SYW_COUPON_MODAL = By.cssSelector("div#dcClipperModalContentWrp span#dcmcCloseModal");
	
	public static final By SAVED_COPUPN_CODE = By.cssSelector("div.promoSaved>span.promoTitle");
	
	
	public static final By ORDER_SUMMARY_TOTAL_SAVING_LINK = By.partialLinkText("Total Savings");
	
	public static final By TOTA_SAVING_FLYOUT = By.id("srchToolTipCont");
	
	public static final By TOTA_SAVING_FLYOUT_CLOSE = By.cssSelector("#srchToolTipClose>span#clsBtn");
	
	
	
	public static final By TOTAL_SAVING_AMOUNT = By.cssSelector("div#totalSavings>div.os_total .savings");
	
	public static final By EARN_POINT_DETAILS_LINK = By.cssSelector("a.pointsDetails");
	
	public static final By SYW_EARN_DETAILS_FLYOUT = By.cssSelector("div#shcLayer.sywrTTinfoNew");
	
	public static final By SYW_EARN_DETAILS_FLYOUT_CLOSE_BTN = By.cssSelector("#shcLayer span.close");
	
	
	
	public static final By SYW_EARN_DETAILS_COUPON_NAME = By.xpath(".//*[@id='pointDetailsMore_1']/div[3]/div[4]");
	
	public static final By SYW_EARN_DETAILS_COUPON_POINTS = By.xpath(".//*[@id='pointDetailsMore_1']/div[3]/div[5]");
	
	
	
	public static final By TOTAL_BONUS_POINTS  = By.cssSelector("div#bonusPointsTTContent.bonusPointWrapper div.pointDetails div.totals div div");
	
	
}
