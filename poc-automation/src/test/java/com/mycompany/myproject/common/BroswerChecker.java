package com.mycompany.myproject.common;

/**
 * 
 */
 public class BroswerChecker {

    public static boolean isIE(String broswer) {
        return broswer != null && (broswer.equalsIgnoreCase("internet explorer") || broswer.equalsIgnoreCase("iexplorer") || broswer.equalsIgnoreCase("IE"));
    }

    public static boolean isFirefox(String broswer) {
        return broswer != null && broswer.equalsIgnoreCase("firefox");
    }

    public static boolean isChrome(String broswer) {
        return broswer != null && broswer.equalsIgnoreCase("chrome");
    }
}
