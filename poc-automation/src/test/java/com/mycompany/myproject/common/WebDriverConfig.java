package com.mycompany.myproject.common;


/**
 * WebDriver
 * 
 */
public class WebDriverConfig {

    private String  platform;

    private String  browser;

    private String  browserVersion;

    private boolean remote;

    private String  hubUrl;

    private int     pageLoadTimeout;
    
    private int     scriptTimeout;
    
    private int     implicitlyWait;

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the browser
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * @param browser the browser to set
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }


    /**
     * @return the remote
     */
    public boolean isRemote() {
        return remote;
    }

    /**
     * @param remote the remote to set
     */
    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    /**
	 * @return the browserVersion
	 */
    public String getBrowserVersion() {
		return browserVersion;
	}

	/**
	 * @param browserVersion the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	/**
	 * @return the pageLoadTimeout
	 */
	public int getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	/**
	 * @param pageLoadTimeout the pageLoadTimeout to set
	 */
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	/**
	 * @return the scriptTimeout
	 */
	public int getScriptTimeout() {
		return scriptTimeout;
	}

	/**
	 * @param scriptTimeout the scriptTimeout to set
	 */
	public void setScriptTimeout(int scriptTimeout) {
		this.scriptTimeout = scriptTimeout;
	}

	/**
	 * @return the implicitlyWait
	 */
	public int getImplicitlyWait() {
		return implicitlyWait;
	}

	/**
	 * @param implicitlyWait the implicitlyWait to set
	 */
	public void setImplicitlyWait(int implicitlyWait) {
		this.implicitlyWait = implicitlyWait;
	}

	/**
     * @return the hubUrl
     */
    public String getHubUrl() {
        return hubUrl;
    }

    /**
     * @param hubUrl the hubUrl to set
     */
    public void setHubUrl(String hubUrl) {
        this.hubUrl = hubUrl;
    }


}
