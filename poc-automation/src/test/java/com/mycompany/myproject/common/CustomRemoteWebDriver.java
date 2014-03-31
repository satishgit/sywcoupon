package com.mycompany.myproject.common;

import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CustomRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot
{

	public CustomRemoteWebDriver(URL remoteAddress, DesiredCapabilities desiredCapabilities) 
	{
		super(remoteAddress,  desiredCapabilities);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException 
	{
		String base64Str = execute(DriverCommand.SCREENSHOT).getValue().toString();
		return target.convertFromBase64Png(base64Str); 
	}
}
