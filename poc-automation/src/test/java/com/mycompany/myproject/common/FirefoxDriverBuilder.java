package com.mycompany.myproject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 */
public class FirefoxDriverBuilder implements WebDriverGenerator {

    @Override
    public boolean apply(WebDriverConfig config) {
        return BroswerChecker.isFirefox(config.getBrowser());
    }

    @Override
    public WebDriver generateWebDriver(WebDriverConfig config) {
        DesiredCapabilities firefox = DesiredCapabilities.firefox();

//        firefox.setVersion(config.getBrowserVersion());
//        firefox.setPlatform(Platform.LINUX);
        
        WebDriver webDriver = new FirefoxDriver(firefox);
        return webDriver;
    }

}
 	