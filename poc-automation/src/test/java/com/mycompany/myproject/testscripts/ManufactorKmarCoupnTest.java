package com.mycompany.myproject.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

@Listeners(com.mycompany.myproject.utilities.ScreenshotListener.class)
public class ManufactorKmarCoupnTest extends BaseTest {

	@Test
	public void loadingManufacturerCouponFromCouponCenterTab_TC_60() throws Exception {

		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);

		pageFactory.LoginRegistrationModal(webDriver)
		   .launchApplication()
		   .registerNewUser();


		pageFactory.navigationTo(webDriver)
				   .navigateToCouponCenterPage()
				   .verifyMyCouponsPage()
				   .loadCouponToMyAccountFromCouponCenterTab("Save $.55 on HORMEL®");
				   
		
		pageFactory.kmartHomePage(webDriver)
				   .openKmartApplication()
				   .setLocalAvailabilityZipCode(60602)
				   .searchProductOnKmartApplication("033W337762120001P")
				   .clickAddToCartAndNavigateToShoppingCartPage()
				   .verifyCouponAppliedOnKmartShoppingcartPage("Save $.55 on HORMEL®");
		
		
	}
		
	 
	

}
