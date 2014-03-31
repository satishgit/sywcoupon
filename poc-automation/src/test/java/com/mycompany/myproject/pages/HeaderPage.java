package com.mycompany.myproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.LoginRegistrationModalLocators;
import com.mycompany.myproject.locators.MyCouponsPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class HeaderPage extends HeaderPageLocators
{
	private WebDriver webDriver;
	AbstractPage browser;
	
	public HeaderPage(WebDriver webDriver){
		this.webDriver = webDriver;
	browser = new AbstractPage(webDriver);
	}
	
	
	public void openSignInForm() throws InterruptedException
	{
		browser.click(SIGN_IN_LINK);
		Thread.sleep(5000);
		browser.waitForObjectToAppear(LoginRegistrationModalLocators.LOGIN_REGISTRATION_POPUP_IFRAME);

	}

	public void clickOnMyCouponTab()
	{
		browser.click(MY_COUPONS_TAB);
		browser.waitForObjectToAppear(MyCouponsPageLocators.COUPON_CENTER_COUPON_LIST_TABEL);
		browser.switchTo(By.name("newsfeed-frame"));
		
		browser.waitForObjectToAppear(MyCouponsPageLocators.COUPON_CENTER_COUPON_LIST_TABEL);
	}

	public void signOutFromApplication()
	{
		try {
			webDriver.switchTo().defaultContent();
		} catch (Exception e) {
		}
		
		browser.waitForObjectToAppear(PROFILE_LOGO);
		browser.click(PROFILE_LOGO);
		//browser.waitForObjectToAppear(SIGN_OUT_LINK);
		//browser.click(SIGN_OUT_LINK);
		//browser.waitForObjectToAppear(SIGN_IN_LINK);
 		//Assert.assertEquals(browser.getTitle(), "ShopYourWay.com: Online shopping for Electronics, Movies, Music and more");
		//GenericFunctionLibrary.logReport("Successfully Logged out from application",LOG.PASS);
	}
	
	public void openJoinOrActivateForm() throws Exception
	{
		browser.click(JOIN_OR_ACTIVATE_LINK);
		Thread.sleep(5000);

	}
	
	public void enterSearchItemInsearchField(String searchItem)
	{
		browser.clearAndSendKeys(HEADER_SEARCH_PRODUCTS_TF, searchItem);
	}
	
	public void clickSearchImageButton()
	{
		browser.click(HEADER_SEARCH_IMG_BUTTON);
	}
	

	public void selectSearchType(String searchType)
	{
		List<WebElement> searchTypeOptions =  webDriver.findElements(SEARCH_SELECTOR_DROP_DOWN_OPTIONS);
		boolean searchOptionFound = false;
		
		for (WebElement webElement : searchTypeOptions) {
			if (webElement.getText().equalsIgnoreCase(searchType)) {
				webElement.click();
				searchOptionFound = true;
				break;
			}
		}
		
		if (false==searchOptionFound) {
			GenericFunctionLibrary.logReport("Search type:"+searchType + " not found in header search type", LOG.FAIL);
		}
	}
	
	
	public void searchItem(String searchType,String searchItem)
	{
		selectSearchType(searchType);
		enterSearchItemInsearchField(searchItem);
		clickSearchImageButton();
		
		//TODO
		// Add verification for search item
		// return search result page type
	}	
	

}
