package com.mycompany.myproject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 */
public class IEWebDriverBuilder implements WebDriverGenerator {

    @Override
    public boolean apply(WebDriverConfig config) {
        if (config.getBrowser() == null) return false;

        if (config.isRemote()) return false;

        return BroswerChecker.isIE(config.getBrowser());
    }

    @Override
    public WebDriver generateWebDriver(WebDriverConfig config) {
        DesiredCapabilities internetExplorer = DesiredCapabilities.internetExplorer();
        internetExplorer.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        WebDriver webDriver = new InternetExplorerDriver(internetExplorer);
        return webDriver;
    }

}
