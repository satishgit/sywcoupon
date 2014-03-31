package com.mycompany.myproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mycompany.myproject.locators.MyCouponsPageLocators;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class MyCouponsPage extends MyCouponsPageLocators
{
	

	
	private final WebDriver webDriver;
	AbstractPage browser;

	
	public MyCouponsPage(WebDriver webDriver){
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);

	}
	
	
	public MyCouponsPage verifyMyCouponsPage()
	{
		
		try {
			browser.waitForObjectToAppear(COUPON_CENTER_COUPON_LIST_TABEL);
			Assert.assertTrue(browser.getTitle().contains(PAGE_TITLE), "Control is not on My coupons Page");
			System.out.println(browser.verifyObjectOnPage(COUPON_CENTER_TAB));
			System.out.println(browser.verifyObjectOnPage(MY_COUPONS_TAB));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println();
			webDriver.switchTo().defaultContent();
			browser.switchTo(By.name("newsfeed-frame"));

			e.printStackTrace();
		}
		
		//TODO Add more verification checkpoints for my coupon page if required
		GenericFunctionLibrary.logReport("Coupon Center tab loaded", LOG.PASS);
		return new MyCouponsPage(webDriver);
	}

	public void clickOnMyCouponTab()
	{
		browser.click(MY_COUPONS_TAB);
		browser.waitForObjectToAppear(MY_CENTER_COUPON_LIST_TABEL);
	}
	

	public void clickOnCouponCenterTab()
	{
		browser.click(COUPON_CENTER_TAB);
		browser.waitForObjectToAppear(COUPON_CENTER_COUPON_LIST_TABEL);
	}
	
	public int getMyCouponCount()
	{
		return Integer.parseInt(browser.getText(MY_COUPONS_COUNT));
	}
	
	public void verifyMyCouponCount(int couponCount)
	{
		if(Integer.parseInt(browser.getText(MY_COUPONS_COUNT))!= couponCount);
		{
			GenericFunctionLibrary.logReport("My Coupn count not matched in my coupons tab ", LOG.FAIL);
		}
	}

	public MyCouponsPage removeAllCouponsFromMyCoupons()
	{
		
		try {
			clickOnMyCouponTab();
			browser.click(REMOVE_ALL_COUPONS_LINK);
			browser.waitForObjectToAppear(REMOVE_ALL_COUPONS_CONFIRMATION_MODAL);
			browser.click(REMOVE_ALL_CONFIRMATION_YES_BTN);
			Thread.sleep(5000);
			browser.waitForPageLoaded();
			if (getMyCouponCount()==0) {
				GenericFunctionLibrary.logReport("All coupons removed from My Account", LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("Problem in removing all coupons from My Account", LOG.FAIL);
				Assert.assertTrue(false,"After removing all coupons coupon count is not 0");
			}
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in removing all coupons from My Account", LOG.FAIL);
			Assert.assertTrue(false,"Problem in removing all coupons");
		}
		
		return new MyCouponsPage(webDriver);
	}
	
	public MyCouponsPage loadCouponToMyAccountFromCouponCenterTab(String couponName) throws InterruptedException
	{

		try {
	
			if(getMyCouponCount()>0)
				removeAllCouponsFromMyCoupons();
			
			clickOnCouponCenterTab();
			webDriver.switchTo().defaultContent();
			
			for (int i = 0; i < 15; i++) {
				webDriver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN)	;
				webDriver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN)	;
				Thread.sleep(2000);
			}

			browser.switchTo(By.name("newsfeed-frame"));
			System.out.println("My coupon Count Before:"+ browser.findElement(MY_COUPONS_COUNT).getText());
			
			List<WebElement> coupons = browser.findElements(By.cssSelector(".actionWrapper .coupon-title"));
			GenericFunctionLibrary.logReport("Scroll down till end of page and got coupon count - "+ coupons.size(), LOG.PASS);
			
			WebElement couponElement = null;
			
			for (int i = 1; i < coupons.size(); i++) {
				
				if(coupons.get(i).getText().equals(couponName))
				{
					couponElement = coupons.get(i);
					GenericFunctionLibrary.logReport("Successfully Searched coupn on coupon center page. coupon name -" + couponName, LOG.PASS);
					System.out.println("Coupon Found on coupon center page");
				}
			}
			
			if(couponElement==null)
			{
				GenericFunctionLibrary.logReport("Coupn not found on coupon center page. coupon name -" + couponName, LOG.FAIL);
				System.out.println("Coupon not Found on coupon center page");
				GenericFunctionLibrary.logReport("Coupon is not available in coupon center", LOG.FAIL);
				Assert.assertTrue(false, "Coupon is not available in coupon center");
			}
			
			
			WebElement parentOne = couponElement.findElement(By.xpath("..")).findElement(By.xpath("..")).findElement(By.xpath(".."));

			String expectedCouponId = parentOne.getAttribute("id");
			
			WebElement loadMyAccountbtn = browser.findElement(By.cssSelector("#"+ expectedCouponId +" div.cta>a .save-coupon"));
			System.out.println(loadMyAccountbtn.isDisplayed());

			loadMyAccountbtn.click();
			Thread.sleep(5000);
			browser.waitForObjectToAppear(By.cssSelector("#"+ expectedCouponId +" div.couponStateOverlay"));
			
//
//			webDriver.navigate().refresh();
//			
//			WebElement CouponLoadedBtn = browser.findElement(By.cssSelector("#"+ expectedCouponId +" div.cta>a .chosenAlready"));
//
//			Assert.assertTrue(CouponLoadedBtn.isDisplayed());
			
			
			if (webDriver.findElement(By.cssSelector("#"+ expectedCouponId +" div.couponStateOverlay")).getText().contains("Coupon successfully loaded to your Shop Your Way")) {
				GenericFunctionLibrary.logReport("Coupon successfully loaded to your Shop Your Way? account. Coupon Name -" + couponName, LOG.PASS);
			}
			else {
				GenericFunctionLibrary.logReport("Problem in loading coupon to account . Coupon Name -" + couponName, LOG.FAIL);
				Assert.assertTrue(false);
			}
				
			
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in loading coupon to my Account", LOG.FAIL);
			Assert.assertTrue(false);
		}
	    
	    
		return new MyCouponsPage(webDriver);
	}
	

	
	
	public MyCouponsPage validateCouponOnCouponCenterPage(String couponName) throws InterruptedException
	{
		
		clickOnCouponCenterTab();
		webDriver.switchTo().defaultContent();
		
		for (int i = 0; i < 15; i++) {
			webDriver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN)	;
			webDriver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN)	;
			Thread.sleep(2000);
		}

		browser.switchTo(By.name("newsfeed-frame"));
		System.out.println("My coupon Count Before:"+ browser.findElement(MY_COUPONS_COUNT).getText());
		
		List<WebElement> coupons = browser.findElements(By.cssSelector(".actionWrapper .coupon-title"));
		GenericFunctionLibrary.logReport("Scroll down till end of page and got coupon count - "+ coupons.size(), LOG.PASS);
		
		WebElement couponElement = null;
		
		for (int i = 1; i < coupons.size(); i++) {
			
			if(coupons.get(i).getText().equals(couponName))
			{
				couponElement = coupons.get(i);
				GenericFunctionLibrary.logReport("Successfully Searched coupn on coupon center page. coupon name -" + couponName, LOG.PASS);
				System.out.println("Coupon Found on coupon center page");
			}
		}
		
		if(couponElement==null)
		{
			GenericFunctionLibrary.logReport("Coupn not found on coupon center page. coupon name -" + couponName, LOG.FAIL);
			System.out.println("Coupon not Found on coupon center page coupon name:: "+ couponName);
			GenericFunctionLibrary.logReport("Coupon is not available in coupon center", LOG.FAIL);
			Assert.assertTrue(false, "Coupon is not available in coupon center");
		}
		
		
		return new MyCouponsPage(webDriver);
	}
	
	public WebElement validateCouponInMyCouponsTab(String couponName)
	{
		clickOnMyCouponTab();
		
		
		//browser.switchTo(By.name("newsfeed-frame"));
		System.out.println("My coupon Count Before:"+ browser.findElement(MY_COUPONS_COUNT).getText());
		
		List<WebElement> myCoupons = browser.findElements(By.cssSelector(".actionWrapper .coupon-title"));
		
		WebElement couponElement = null;
		
		for (int i = 0; i < myCoupons.size(); i++) {
			
			if(myCoupons.get(i).getText().equals(couponName))
			{
				couponElement = myCoupons.get(i);
			}
		}
		
		if(couponElement==null)
		{
			GenericFunctionLibrary.logReport("Coupn not found on My coupon Tab . coupon name -" + couponName, LOG.FAIL);
			Assert.assertTrue(false, "Coupon is not available in on My ");
		}
		
		return couponElement.findElement(By.xpath("..")).findElement(By.xpath("..")).findElement(By.xpath(".."));
	}
	
	
	public MyCouponsPage removeCouponFromMyCouponsTab(String couponName)
	{
		try {
		
			WebElement couponElement = validateCouponInMyCouponsTab(couponName);

			String couponIdToRemove = couponElement.getAttribute("id");
			
			WebElement removeCouponBtn = browser.findElement(By.cssSelector("#"+ couponIdToRemove +" div.cta>a .remove-coupon"));
			System.out.println(removeCouponBtn.isDisplayed());


			int beforeDelete = getMyCouponCount();
			removeCouponBtn.click();
			Thread.sleep(2000);
			browser.waitForObjectToAppear(By.cssSelector("#"+couponIdToRemove+" .nowRemoved"));
			
			
			webDriver.navigate().refresh();
			browser.switchTo(By.name("newsfeed-frame"));

			if(beforeDelete == getMyCouponCount()+1)
			{
				GenericFunctionLibrary.logReport("Successfully removed coupon from my coupons.coupon name -" + couponName, LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("Problem in removing coupon from my coupons. coupon name -" + couponName, LOG.FAIL);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in removing coupn from my coupons. coupon name -" + couponName, LOG.FAIL);
			Assert.assertTrue(false);
		}
		return new MyCouponsPage(webDriver);
	}


	public MyCouponsPage validateTiCouponOnCouponCenterPage(String couponName) throws InterruptedException {

		return validateCouponOnCouponCenterPage(couponName);
	}


	public MyCouponsPage validateManufatureCouponOnCouponCenterPage(String couponName) throws InterruptedException {

		return validateCouponOnCouponCenterPage(couponName);
	}


	public MyCouponsPage validateHolidayCouponOnCouponCenterPage(String couponName) throws InterruptedException {

		return validateCouponOnCouponCenterPage(couponName);
	}

	
}
