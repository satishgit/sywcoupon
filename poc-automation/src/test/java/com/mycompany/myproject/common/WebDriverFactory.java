package com.mycompany.myproject.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * 
 */
public class WebDriverFactory {

    private static List<WebDriverGenerator> builders      = new ArrayList<WebDriverGenerator>();

    private static WebDriverConfig        defaultConfig = null;

    public static ThreadLocal<WebDriver> threadCache   = new ThreadLocal<WebDriver>();

    static {
        init();
    }

    /**
     * 
     * @return
     */
    public static WebDriver getCurrentWebDriver() {
        return getCurrentWebDriver(true);
    }

    /**
     * 
     */
    public static WebDriver getCurrentWebDriver(boolean createForce) {
        WebDriver webDriver = threadCache.get();
        if (webDriver == null && createForce) {
            webDriver = createWebDriver(defaultConfig);
            threadCache.set(webDriver);
        }
        return webDriver;
    }

    public static WebDriver createWebDriver(WebDriverConfig config) {
        if (config != null) {
            for (WebDriverGenerator builder : builders) {
                if (builder.apply(config)) {
                    WebDriver driver = builder.generateWebDriver(config);
                    driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait() > 0 ? config.getImplicitlyWait() : 30,
                                                              TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    return driver;
                }
            }
        }
        throw new RuntimeException("can't create webdriver with the config:" + config);

    }

    public static void clear() {
        threadCache.remove();
    }

    /**
     * 
     */
    private static void init() {
        registerBuilder(new RemoteWebDriverBuilder());
        registerBuilder(new IEWebDriverBuilder());
        registerBuilder(new ChromeDriverBuilder());
        registerBuilder(new FirefoxDriverBuilder());
        loadDefaultConfig();
    }

    /**
     * 
     */
    private static void loadDefaultConfig() {
        defaultConfig = WebDriverConfigLoader.load();

    }

    private static void registerBuilder(WebDriverGenerator builder) {
        builders.add(builder);
    }

}
