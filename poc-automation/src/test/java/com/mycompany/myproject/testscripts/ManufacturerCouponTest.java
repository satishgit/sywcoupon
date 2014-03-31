package com.mycompany.myproject.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

@Listeners(com.mycompany.myproject.utilities.ScreenshotListener.class)
public class ManufacturerCouponTest extends BaseTest {

	@Test
	public void loadingManufacturerCouponFromCouponCenterTab_TC_60() throws Exception {

		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);

		pageFactory.LoginRegistrationModal(webDriver)
				   .launchApplication()
				   .loginAs(TestData.USER_EMAIL, TestData.USER_PASSWORD);


		pageFactory.navigationTo(webDriver)
				   .navigateToCouponCenterPage()
				   .verifyMyCouponsPage()
				   .loadCouponToMyAccountFromCouponCenterTab("$5 off your next Apparel purchase of $35 or more")
				   .removeCouponFromMyCouponsTab("$5 off your next Apparel purchase of $35 or more");
				   
		pageFactory.HeaderPage(webDriver)
				   .signOutFromApplication();
	}
		
	 
	

}
