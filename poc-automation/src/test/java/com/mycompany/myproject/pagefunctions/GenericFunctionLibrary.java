package com.mycompany.myproject.pagefunctions;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.mycompany.myproject.pages.AbstractPage;

public class GenericFunctionLibrary {


	private WebDriver webDriver;
	
	public enum LOG {
		PASS, FAIL
	} 

	public GenericFunctionLibrary(WebDriver webDriver){
		this.webDriver = webDriver;
		AbstractPage browser = new AbstractPage(webDriver);
	}
	
	public static void logReport(String sDescription,LOG LOG)
	{
		String message = "";
		if(LOG.PASS==LOG)
		{
			message = sDescription + "<b>  |<FONT color='Green'>PASS</FONT></b>"; 
		}
		else
		{
			message = sDescription + "<b>  |<FONT color='Red'>FAIL</FONT></b>";
		}
			
		Reporter.log(message);
	}
		
}
