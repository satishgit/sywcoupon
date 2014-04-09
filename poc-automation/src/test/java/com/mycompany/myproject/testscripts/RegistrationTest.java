package com.mycompany.myproject.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.pages.PageFactory;
import com.mycompany.myproject.testdata.TestData;

@Listeners(com.mycompany.myproject.utilities.ScreenshotListener.class)
public class RegistrationTest extends BaseTest {

	@Test
	public void loginTest_TC_02() throws Exception {

		WebDriver webDriver = getDriver();
		PageFactory pageFactory = new PageFactory(webDriver);

		pageFactory.LoginRegistrationModal(webDriver)
				   .launchApplication()
				   .validateRegistrationModal()
				   .registerNewUser()
				   .verifySywrNumberOnRewardProgram();
		
		pageFactory.HeaderPage(webDriver)
					.signOutFromApplication();
					
	}

	

}
