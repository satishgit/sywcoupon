package com.mycompany.myproject.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.GetText;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mycompany.myproject.common.BaseTest;
import com.mycompany.myproject.common.WebDriverConfig;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary;
import com.mycompany.myproject.pagefunctions.GenericFunctionLibrary.LOG;

public class AbstractPage extends BaseTest {
	public WebDriver webDriver ;

	public AbstractPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void click(By by) {
		webDriver.findElement(by).click();
	}
	
	public void sendKeys(By by,String sText) {
		webDriver.findElement(by).sendKeys(sText);
	}
	
	public void clearAndSendKeys(By by,String sText) {
		webDriver.findElement(by).clear();
		sendKeys(by, sText);
	}
	
	public void openURL(String url) {
		webDriver.get(url);
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	public WebElement findElement(By by) {
		return webDriver.findElement(by);
	}
	
	
	public List<WebElement> findElements(By by) {
		return webDriver.findElements(by);
	}
	
	public WebDriver switchTo(By by) {
		return webDriver.switchTo().frame(findElement(by));
	}
	
	public void maximizeWindow(String url) {
		webDriver.manage().window().maximize();
	}
	
	
	public void verifyObject(By by) {

	}

	public boolean waitForObjectOnPage(By by) {
		WebElement webElement = waitForObjectToAppear(by);
		if (null == webElement) {
			Assert.assertTrue(false, "Element : " + by.toString()
					+ " is not present");
			return false;
		} else
			return true;
	}

	public WebElement waitForObjectToAppear(By by) {
		WebElement webElement = null;
		try {
			try {
				Thread.sleep(1000);
				//System.out.println(System.currentTimeMillis());
				webElement = webDriver.findElement(by);
			} catch (Exception e) {
			}
			if(webElement==null)
			{
				webDriver.manage().timeouts().implicitlyWait(new WebDriverConfig().getImplicitlyWait(), TimeUnit.SECONDS);
			}
			//System.out.println(System.currentTimeMillis()); 
			webElement = webDriver.findElement(by);
		} catch (Exception e) {
		}
		return webElement;
	}

	public void waitForPageLoaded() {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
	}

	public String getInnerText(By by) {
		//TODO add logic to get inner text
		return "";
	}

	public String getText(By by) {
		return findElement(by).getText();
	}

	
	public void verifyPageTitle(String pageTitle) {
	
		Assert.assertTrue(webDriver.getTitle().contains(pageTitle),
				"Page title verification");
	}

	public boolean isDisplayed(By by) {
		return findElement(by).isDisplayed();
	}

	public boolean verifyObjectOnPage(By by) {
		WebElement webElement = findElement(by);
		try {
			webElement = waitForObjectToAppear(by);
			if(webElement != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			GenericFunctionLibrary.logReport("Object:"+ webElement +"  Not Present on Page.", LOG.FAIL);
			return false;
		}
		
	}

}
