package com.mycompany.myproject.common;

import java.io.IOException;
import java.util.Properties;

import com.mycompany.myproject.utilities.ClasspathPropertyFileLoader;

public  class WebDriverConfigLoader {

    
    
    public static WebDriverConfig load()
    {
    	WebDriverConfig webDriverConfig = new WebDriverConfig();
    	
    	try {
    		
    		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+System.getProperty("test.browser"));
			Properties driverProperties = new ClasspathPropertyFileLoader().loadProperties("driver.properties");
			
			if(null!= System.getProperty("test.browser") )
			{
				webDriverConfig.setBrowser(System.getProperty("test.browser"));
			}
			else
			{
				webDriverConfig.setBrowser(driverProperties.getProperty("browser"));
			}
			
			webDriverConfig.setBrowserVersion(driverProperties.getProperty("browserVersion"));
			
			if (null!= System.getProperty("hub.url")) 
			{
				webDriverConfig.setRemote(true);
				webDriverConfig.setHubUrl(System.getProperty("hub.url"));
				System.out.println("hub url is not null -----------------------");
				
			}
			else
			{
				System.out.println("hub url is null -----------------------");
				webDriverConfig.setRemote(Boolean.parseBoolean(driverProperties.getProperty("remote")));
				webDriverConfig.setHubUrl(driverProperties.getProperty("hubUrl"));

			}

			webDriverConfig.setPageLoadTimeout(Integer.parseInt(driverProperties.getProperty("pageLoadTimeout")));

			webDriverConfig.setScriptTimeout(Integer.parseInt(driverProperties.getProperty("scriptTimeout")));

			webDriverConfig.setImplicitlyWait(Integer.parseInt(driverProperties.getProperty("implicitlyWait")));

			webDriverConfig.setPlatform(driverProperties.getProperty("platform"));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
    	return webDriverConfig;
    	
    }

    
}
