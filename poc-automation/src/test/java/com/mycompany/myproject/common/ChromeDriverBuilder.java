package com.mycompany.myproject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 */
public class ChromeDriverBuilder implements WebDriverGenerator {

    @Override
    public boolean apply(WebDriverConfig config) {
        return BroswerChecker.isChrome(config.getBrowser());
    }

    @Override
    public WebDriver generateWebDriver(WebDriverConfig config) {
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        WebDriver webDriver = new ChromeDriver(chrome);
        return webDriver;
    }

}
