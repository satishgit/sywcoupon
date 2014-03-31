package com.mycompany.myproject.pages;

import org.openqa.selenium.WebDriver;

import com.mycompany.myproject.pagefunctions.ApplicationNavigationLibrary;

public class PageFactory
{
	
	private final WebDriver webDriver; 
	
	private HomePage homePage;
	private LoginRegistrationModal loginRegistrationModal;
	private HeaderPage headerPage;
	private KmartProductDetailsPage kmartProductDetailsPage;
	private ApplicationNavigationLibrary navigationTo;
	private KmartShoppingCartPage kmartShoppingCartPage;
	private KmartHomePage kmartHomePage;
	
	public PageFactory(WebDriver webDriver)
	{
		this.webDriver = webDriver;
	}
	
	public HomePage homePage(WebDriver webDriver)
	{
		if(homePage == null)
			homePage = new HomePage(webDriver);
		return homePage;
	}
	
	public HeaderPage HeaderPage(WebDriver webDriver)
	{
		if(headerPage == null)
			headerPage = new HeaderPage(webDriver);
		return headerPage;
	}
	
	public LoginRegistrationModal LoginRegistrationModal(WebDriver webDriver)
	{
		if(loginRegistrationModal == null)
			loginRegistrationModal = new LoginRegistrationModal(webDriver);
		return loginRegistrationModal;
	}
	
	public ApplicationNavigationLibrary navigationTo(WebDriver webDriver)
	{
		if(navigationTo == null)
			navigationTo = new ApplicationNavigationLibrary(webDriver);
		return navigationTo;
	}
	
	public KmartProductDetailsPage kmartProductDetailsPage(WebDriver webDriver)
	{
		if(kmartProductDetailsPage == null)
			kmartProductDetailsPage = new KmartProductDetailsPage(webDriver);
		return kmartProductDetailsPage;
	}
	
	public KmartHomePage kmartHomePage(WebDriver webDriver)
	{
		if(kmartHomePage == null)
			kmartHomePage = new KmartHomePage(webDriver);
		return kmartHomePage;
	}
	
	public KmartShoppingCartPage kmartShoppingCartPage(WebDriver webDriver)
	{
		if(kmartShoppingCartPage == null)
			kmartShoppingCartPage = new KmartShoppingCartPage(webDriver);
		return kmartShoppingCartPage;
	}
	
}
