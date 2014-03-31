package com.mycompany.myproject.pagefunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.HomePageLocators;
import com.mycompany.myproject.locators.MyCouponsPageLocators;
import com.mycompany.myproject.pages.AbstractPage;
import com.mycompany.myproject.pages.HeaderPage;
import com.mycompany.myproject.pages.MyCouponsPage;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

public class ApplicationNavigationLibrary extends BaseTest
{

	private WebDriver webDriver;
	AbstractPage browser;
	public ApplicationNavigationLibrary(WebDriver webDriver){
		this.webDriver = webDriver;
		browser = new AbstractPage(webDriver);
	}
	
	public MyCouponsPage navigateToCouponCenterPage()
	{
		if(false==browser.getTitle().contains(HomePageLocators.TITLE))
		{
			PageFactory pageFactory = new PageFactory(webDriver);
			pageFactory.LoginRegistrationModal(webDriver).loginAs(TestData.USER_EMAIL, TestData.USER_PASSWORD);
			pageFactory.homePage(webDriver).verifyHomePage();
		}
		
		new HeaderPage(webDriver).clickOnMyCouponTab();

		return new MyCouponsPage(webDriver);
	}
	
	public MyCouponsPage navigateToMyCouponPage()
	{
		this.navigateToCouponCenterPage()
			.clickOnMyCouponTab();
		return new MyCouponsPage(webDriver);
	}
	
	
	
}
