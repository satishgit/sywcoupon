package com.mycompany.myproject.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

@Listeners(com.mycompany.myproject.utilities.ScreenshotListener.class)
public class AddingMultipleProductsToCartTest extends BaseTest {

	@Test
	public void loginTest_TC_01() throws Exception {

		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);
		ArrayList<String> productsNuber = new ArrayList<>();
						  productsNuber.add("07129000000P");
						  productsNuber.add("00959732000");
						  productsNuber.add("00923465000");	
		

		pageFactory.LoginRegistrationModal(webDriver)
				   .launchApplication()
				   .loginAs(TestData.USER_EMAIL, TestData.USER_PASSWORD)
				   .verifyHomePage()
				   .addProductsToShoppingCart(productsNuber);
		
					
	}

}
