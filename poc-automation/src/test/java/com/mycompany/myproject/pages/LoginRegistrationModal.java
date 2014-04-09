package com.mycompany.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mycompany.myproject.common.Configuration;
import com.mycompany.myproject.locators.HeaderPageLocators;
import com.mycompany.myproject.locators.HomePageLocators;
import com.mycompany.myproject.locators.LoginRegistrationModalLocators;
import com.mycompany.myproject.pagefunctions.ApplicationFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class LoginRegistrationModal extends LoginRegistrationModalLocators {

	private WebDriver webDriver;
	
	AbstractPage browser;
	ApplicationFunctionLibrary functionLibrary;

	public LoginRegistrationModal(WebDriver webDriver) {
		this.webDriver = webDriver;
		 browser = new AbstractPage(webDriver);
		functionLibrary = new ApplicationFunctionLibrary(webDriver);
	}

	public void enterEmailAddress(String email) {
		browser.clearAndSendKeys(LOGIN_EMAIL_TF, email);
	}

	public void enterPassword(String password) {
		browser.clearAndSendKeys(LOGIN_PASSWORD_TF, password);
	}

	public void clickSignInButton() {
		browser.click(LOGIN_REG_FORM_SIGN_IN_BUTTON);
	}

	public void clickJoinButtonOnRegistrationModal() throws Exception{
		browser.click(LOGIN_REG_FORM_SIGN_IN_BUTTON);
		Thread.sleep(10000);
		browser.waitForObjectToAppear(HeaderPageLocators.PROFILE_NAME);

	}

	public HomePage registerNewUser()
	{
		try {

			new HeaderPage(webDriver).openJoinOrActivateForm();

			if (browser.isDisplayed(LOGIN_REGISTRATION_POPUP_IFRAME)) {
				browser.switchTo(LOGIN_REGISTRATION_POPUP_IFRAME);
			}
			String sEmail = "auto_"+ System.currentTimeMillis()+"@syw.com";
			System.out.println("email: " +sEmail);
			
			browser.clearAndSendKeys(JOIN_IN_F_NAME_TF, "SYWAuto");
			browser.clearAndSendKeys(JOIN_IN_LAST_NAME_TF, "Test");
			browser.clearAndSendKeys(LOGIN_EMAIL_TF,  sEmail);
			Thread.sleep(2000);
			browser.clearAndSendKeys(LOGIN_PASSWORD_TF, "sears123");
			
			clickJoinButtonOnRegistrationModal();
			

			
			if(browser.getText(By.className("account-into-section")).contains("SYWAuto"))
			{
				GenericFunctionLibrary.logReport("New user registered sucessfully. Email: "+sEmail +" and password: sears123" , LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("Problem in New user registration", LOG.FAIL);
				Assert.assertTrue(false);
			}
			
			browser.waitForObjectToAppear(HeaderPageLocators.PROFILE_NAME);
		

		}catch(Exception e)
		{
			GenericFunctionLibrary.logReport("Problem in New user registration", LOG.FAIL);
			Assert.assertTrue(false);
		}
		return new HomePage(webDriver);
	}
	
	public LoginRegistrationModal validateRegistrationModal()
	{

		try {
			new HeaderPage(webDriver).openJoinOrActivateForm();


			if (browser.isDisplayed(LOGIN_REGISTRATION_POPUP_IFRAME)) {
				browser.switchTo(LOGIN_REGISTRATION_POPUP_IFRAME);
			}
			clickJoinButtonOnRegistrationModal();
			
			Assert.assertEquals(browser.getText(JOIN_IN_F_NAME_VALIDATION), JOIN_IN_F_NAME_VALIDATION_MSG);
			Assert.assertEquals(browser.getText(JOIN_IN_L_NAME_VALIDATION), JOIN_IN_L_NAME_VALIDATION_MSG);
			Assert.assertEquals(browser.getText(JOIN_IN_EMAIL_VALIDATION), JOIN_IN_EMAIL_VALIDATION_MSG);
			Assert.assertEquals(browser.getText(JOIN_IN_PASSWORD_VALIDATION), JOIN_IN_PWD_VALIDATION_MSG);
			
			
			GenericFunctionLibrary.logReport("Successfully validated Registration modal fields", LOG.PASS);
			
			webDriver.switchTo().defaultContent();
			
			System.out.println(browser.isDisplayed(SIGN_MODAL_CLOSE_BUTTON));
			browser.click(SIGN_MODAL_CLOSE_BUTTON);
			browser.waitForObjectToAppear(HeaderPageLocators.SIGN_IN_LINK);
			
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in validated registration modal fields", LOG.FAIL);
			Assert.assertTrue(false);
		}

		
		return new LoginRegistrationModal(webDriver);
	}
	
	
	public LoginRegistrationModal validateLoginModal()
	{
		try {
			new HeaderPage(webDriver).openSignInForm();

			if (browser.isDisplayed(LOGIN_REGISTRATION_POPUP_IFRAME)) {
				browser.switchTo(LOGIN_REGISTRATION_POPUP_IFRAME);
			}
			clickSignInButton();
			
			if(browser.getText(SIGN_IN_EMAIL_VALIDATION).equals(SIGN_IN_EMAIL_VALIDATION_MSG) && 
					browser.getText(SIGN_IN_PASSWORD_VALIDATION).equals(SIGN_IN_PASSWORD_VALIDATION_MSG))
			
			{
				GenericFunctionLibrary.logReport("Successfully validated Sign In Email and Password fields", LOG.PASS);
			}
			else
			{
				GenericFunctionLibrary.logReport("Problem in validated Sign In Email and Password fields", LOG.FAIL);
				Assert.assertTrue(false);
			}
			webDriver.switchTo().defaultContent();
			
			System.out.println(browser.isDisplayed(SIGN_MODAL_CLOSE_BUTTON));
			browser.click(SIGN_MODAL_CLOSE_BUTTON);
			browser.waitForObjectToAppear(HeaderPageLocators.SIGN_IN_LINK);
			
		} catch (InterruptedException e) {
			GenericFunctionLibrary.logReport("Problem in validated Sign In Email and Password fields", LOG.FAIL);
			Assert.assertTrue(false);
		}

		return new LoginRegistrationModal(webDriver);
	}
	
	public HomePage loginAs(String email, String password) 
	{

		try {
			new HeaderPage(webDriver).openSignInForm();
			browser.waitForObjectToAppear(LOGIN_REGISTRATION_POPUP_IFRAME_CONTAINER);
			browser.switchTo(LOGIN_REGISTRATION_POPUP_IFRAME);
			
			if (browser.isDisplayed(LOGIN_REGISTRATION_POPUP_IFRAME_CONTAINER)) {
				browser.switchTo(LOGIN_REGISTRATION_POPUP_IFRAME);
			}

			// clear and type email address
			enterEmailAddress(email);
			
			//clear and type password
			enterPassword(password);
			
			//click on Sign in button
			clickSignInButton();
			
			browser.waitForObjectToAppear(HomePageLocators.STATUS_BOX_CONTAINER);
			browser.waitForObjectToAppear(HomePageLocators.PROFILE_LOGO);
			if (browser.isDisplayed(HomePageLocators.PROFILE_LOGO)) {
				GenericFunctionLibrary.logReport("User successfully logged in using email: " + email + " and password: " + password , LOG.PASS);
			} 
			else
			{
				GenericFunctionLibrary.logReport("Problem in login using email: " + email + " and password: " + password , LOG.FAIL);
				Assert.assertTrue(false, "Problem in login");
			}
			
			browser.verifyObjectOnPage(HomePageLocators.PROFILE_LOGO);
			
			if (browser.isDisplayed(By.cssSelector("#rewards-drop-down div.section-close"))) {
				browser.click(By.cssSelector("#rewards-drop-down div.section-close"));
			}

						
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Problem in login to application", LOG.FAIL);
			Assert.assertTrue(false, e.toString());
		}
		return new HomePage(webDriver);
	}

	public LoginRegistrationModal launchApplication() {
		webDriver.get(Configuration.APP_URL);
		webDriver.manage().deleteAllCookies();
		if(browser.getTitle().contains("ShopYourWay.com: Online shopping for Electronics, Movies, Music and more"))
			GenericFunctionLibrary.logReport("Successfully opened application login page.", LOG.PASS);
		else
		{
			GenericFunctionLibrary.logReport("Problem in launching application", LOG.FAIL);
			Assert.assertTrue(false,"Problem in launching application");
		}
		
		return new LoginRegistrationModal(webDriver);
	}

}
