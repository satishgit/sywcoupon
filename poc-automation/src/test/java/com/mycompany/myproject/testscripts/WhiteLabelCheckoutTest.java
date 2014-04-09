package com.mycompany.myproject.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

@Listeners(com.mycompany.myproject.utilities.ScreenshotListener.class)
public class WhiteLabelCheckoutTest extends BaseTest {

	@Test
	public void whiteLabelCheckoutTest_TC_50() throws Exception {

//		String couponName = "$20 in Points on $100 Tools Purchase.";
//		String productId = "00923465000";
		
		String couponName = "$10 back in points on $50 or more";
		String productId = "011W432981840001";
		String sywrNumber ="";
		
		// Initiate browser
		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);

		// Login to application 
		pageFactory.LoginRegistrationModal(webDriver)
				   .launchApplication()
				   .loginAs("auto_1396204406808@syw.com", TestData.USER_PASSWORD)
				   .verifyHomePage();
		//Get SYWR number for verification in checkout
		sywrNumber = pageFactory.homePage(webDriver).verifySywrNumberOnRewardProgram();
		
		// Find given coupon on coupon cnter page and Load into my account		
		pageFactory.navigationTo(webDriver)
		   .navigateToCouponCenterPage()
		   .verifyMyCouponsPage()
		   .loadCouponToMyAccountFromCouponCenterTab(couponName);

		//Capture coupon name to verify on shopping cart page
		String couponNumber = pageFactory.myCouponsPage(webDriver).getAppliedCouponPromoCode(couponName);
		
		
		// Apply coupon and Verify on shopping cart
		pageFactory.homePage(webDriver)
					.searchProduct(productId)
					.verifySYWProductDetailsPage(productId)
					.clickAddToCartAndNavigateToShoppingCartPage()
		//			.updateWhiteLabelSHoppingCartQuantity(2)
					.applySYWCouponCode(couponName)
					.veifyCouponNumberOnShoppingCartPage(couponNumber);
		
		// Verify earned points on shopping cart page
		pageFactory.whiteLabelShoppingCartPage(webDriver).verifyEarnPointsOnShoppingCartPage();
		
		// Verify total saving on shopping cart page
		pageFactory.whiteLabelShoppingCartPage(webDriver).verifySavingsLinkCouponShoppingCartPage(couponName);				
				
		
		// Get shopping cart product details for validating in checkout pages
		ArrayList<String> products = pageFactory.whiteLabelShoppingCartPage(webDriver)
												.verifyShoppingCartPageAndgetProductDetails();
		
		
		// Navigate to Shipping page and verify
		pageFactory.whiteLabelShoppingCartPage(webDriver)
				   .clickProceedToCheckOut()
				   .verifyShippingAddressPage(products,couponName);
		
		// Navigate to payment page Form shipping page and verify
		pageFactory.whiteLabelCheckoutPage(webDriver)
				.navigateToPaymentPage()
				.verifyPaymentPage(products,couponName, sywrNumber);
		
		String cardDetails = pageFactory.whiteLabelCheckoutPage(webDriver).getPaymentDetailsFromPaymentPage();

		
		//Navigate to review order page and verify
		pageFactory.whiteLabelCheckoutPage(webDriver)
				   .selectDefaultSavedPaymentTypeAndNavigateToReviewPage()
				   	.verifyReviewPage(products,couponName);
		
		
		pageFactory.whiteLabelCheckoutPage(webDriver)
					.placeOrderFromReviewPage()
					.verifyOrderConfirmationPage(products,cardDetails,"auto_1396204406808@syw.com");
		
	}

}
