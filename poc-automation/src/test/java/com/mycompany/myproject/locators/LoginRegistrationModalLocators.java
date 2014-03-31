package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class LoginRegistrationModalLocators
{

	
	public static final By LOGIN_REGISTRATION_POPUP_FORM = By.id("registration-form-page");
	
	public static final By LOGIN_REGISTRATION_POPUP_IFRAME = By.id("registration-form-iframe");
	
	public static final By LOGIN_EMAIL_TF = By.id("email");
	
	public static final By LOGIN_PASSWORD_TF = By.id("password");
	
	public static final By LOGIN_REG_FORM_SIGN_IN_BUTTON = By.id("register-form");

	public static final By SIGN_IN_EMAIL_VALIDATION = By.cssSelector("#email-container span");
	
	public static final String SIGN_IN_EMAIL_VALIDATION_MSG = "Enter your email address";
	
	public static final By SIGN_IN_PASSWORD_VALIDATION = By.cssSelector("#password-container span");
	
	public static final String SIGN_IN_PASSWORD_VALIDATION_MSG = "Enter your password";
	
	public static final By SIGN_MODAL_CLOSE_BUTTON = By.className("modal-close-button");
	
	
	
	// Registration Modal
	
	public static final By JOIN_IN_F_NAME_TF = By.id("first-name");
	
	public static final By JOIN_IN_LAST_NAME_TF = By.id("last-name");
	
	
	public static final By JOIN_IN_F_NAME_VALIDATION = By.cssSelector("#first-name-container span");
	
	public static final String JOIN_IN_F_NAME_VALIDATION_MSG = "Enter your first name";
	
	public static final By JOIN_IN_L_NAME_VALIDATION = By.cssSelector("#last-name-container span");
	
	public static final String JOIN_IN_L_NAME_VALIDATION_MSG = "Enter your last name";
	
	public static final By JOIN_IN_EMAIL_VALIDATION = By.cssSelector("#email-container span");
	
	public static final String JOIN_IN_EMAIL_VALIDATION_MSG = "Enter a valid email address";
	
	public static final By JOIN_IN_PASSWORD_VALIDATION = By.cssSelector("#password-container span");
	
	public static final String JOIN_IN_PWD_VALIDATION_MSG = "Min. 6 characters, 1 letter, 1 number, don't repeat same character 3 times in a row";	
	
}
