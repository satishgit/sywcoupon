package com.mycompany.myproject.locators;

import org.openqa.selenium.By;

public class KmartHomePageLocators
{

	public static final String TITLE = "Kmart - Deals on Furniture, Toys, Clothes, Tools, Tablets & TVs";
	
	public static final By VERTICAL_SEARCH_SELECTION_DEOP_DOWN = By.cssSelector("select.vertSearchSelect");
	
	public static final By HEADER_SEARCH_FIELD = By.id("keyword");
	
	public static final By HEADER_SEARCH_BTN = By.id("goBtn");
	
	public static final By HEADER_EDIT_ZIP_LINK = By.cssSelector("#userAddress>a");
	
	public static final By HEADER_EDIT_ZIP_TF = By.id("addressField");
	
	public static final By HEADER_EDIT_ZIP_GO_BTN = By.cssSelector("#customerLocation .labeledField>button");
	
	
	
	
}
