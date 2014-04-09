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
	private SYWProductDetailsPage sYWProductDetailsPage;
	private WhiteLabelShoppingCartPage whiteLabelShoppingCartPage;
	private SearsProductOptionsPage searsProductOptionsPage;
	private MyCouponsPage myCouponsPage;
	private WhiteLabelCheckoutPage whiteLabelCheckoutPage;
	
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
	
	public SYWProductDetailsPage sYWProductDetailsPage(WebDriver webDriver)
	{
		if(sYWProductDetailsPage == null)
			sYWProductDetailsPage = new SYWProductDetailsPage(webDriver);
		return sYWProductDetailsPage;
	}
	
	public SearsProductOptionsPage searsProductOptionsPage(WebDriver webDriver)
	{
		if(searsProductOptionsPage == null)
			searsProductOptionsPage = new SearsProductOptionsPage(webDriver);
		return searsProductOptionsPage;
	}
	
	public WhiteLabelShoppingCartPage whiteLabelShoppingCartPage(WebDriver webDriver)
	{
		if(whiteLabelShoppingCartPage == null)
			whiteLabelShoppingCartPage = new WhiteLabelShoppingCartPage(webDriver);
		return whiteLabelShoppingCartPage;
	}
	
	public MyCouponsPage myCouponsPage(WebDriver webDriver)
	{
		if(myCouponsPage == null)
			myCouponsPage = new MyCouponsPage(webDriver);
		return myCouponsPage;
	}
	
	public WhiteLabelCheckoutPage whiteLabelCheckoutPage(WebDriver webDriver)
	{
		if(whiteLabelCheckoutPage == null)
			whiteLabelCheckoutPage = new WhiteLabelCheckoutPage(webDriver);
		return whiteLabelCheckoutPage;
	}
}
