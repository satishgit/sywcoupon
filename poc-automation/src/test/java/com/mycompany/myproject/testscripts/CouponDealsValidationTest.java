package com.mycompany.myproject.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

@Listeners(com.mycompany.myproject.utilities.ScreenshotListener.class)
public class CouponDealsValidationTest extends BaseTest {

	@Test
	public void couponDealsValidationTest_TC_03() throws Exception {

		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);

		pageFactory.LoginRegistrationModal(webDriver)
				   .launchApplication()
				   .loginAs("auto_1396168341362@syw.com", TestData.USER_PASSWORD);
				   // .loginAs("auto_1396220402140@syw.com", TestData.USER_PASSWORD);


		pageFactory.navigationTo(webDriver)
				   .navigateToCouponCenterPage()
				   .validateTiCouponOnCouponCenterPage("$15 in Points on $100 Sporting Goods Purchase.") // Vaalidate TI coupns on coupn center page
				   .validateHolidayCouponOnCouponCenterPage("$10 in Points On $75 in Clothing") // validate Holiday coupon on coupon center page
				   .validateManufatureCouponOnCouponCenterPage("Save $.55 on HORMEL®"); //validate Manufactor coupon on coupon center page
				   
		pageFactory.HeaderPage(webDriver)
				   .signOutFromApplication();
	}
		

	//@Test
	public void myCouponsValidationTest_TC_12() throws Exception {

		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);

		pageFactory.LoginRegistrationModal(webDriver)
				   .launchApplication()
				  .loginAs(TestData.USER_EMAIL, TestData.USER_PASSWORD);
				    //.loginAs("auto_1396220402140@syw.com", TestData.USER_PASSWORD);


		pageFactory.navigationTo(webDriver)
				   .navigateToCouponCenterPage()
				   .loadCouponToMyAccountFromCouponCenterTab("$15 in Points on $100 Sporting Goods Purchase.") // Vaalidate TI coupns on coupn center page
				   .validateCouponInMyCouponsTab("$15 in Points on $100 Sporting Goods Purchase.");
	
		pageFactory.HeaderPage(webDriver)
				   .signOutFromApplication();
	}
	
}
