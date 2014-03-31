package com.mycompany.myproject.common;

import org.openqa.selenium.WebDriver;

/**
 * WebDriver
 *  
 */
public interface WebDriverGenerator {

    /**
     * 
     * @param config
     * @return
     */
    boolean apply(WebDriverConfig config);

    /**
     * WebDriver
     * 
     * @param config
     * @return
     */
    WebDriver generateWebDriver(WebDriverConfig config);
}
