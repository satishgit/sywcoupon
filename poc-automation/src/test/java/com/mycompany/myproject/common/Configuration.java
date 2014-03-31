package com.mycompany.myproject.common;

import java.util.Properties;
import java.io.File;
import java.io.IOException;

import com.mycompany.myproject.utilities.ClasspathPropertyFileLoader;

public class Configuration {
	private static Properties FramwWorkProperties;
	public static String sProjectLocation;

	
	static {
		try {
			FramwWorkProperties = new ClasspathPropertyFileLoader()
					.loadProperties("framework-configuration.properties");
			File oFile = new File(".project");
			sProjectLocation = oFile.getAbsolutePath();
			sProjectLocation = sProjectLocation.substring(0,
					sProjectLocation.lastIndexOf("\\"));

		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	// URL against which the test is going to run.
	public static final String APP_URL = FramwWorkProperties
			.getProperty("app.url");

	public static final String BROWSER = FramwWorkProperties
			.getProperty("browser");

	public static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(FramwWorkProperties
			.getProperty("pageLoadTimeout"));

	public static final int SCRIPT_TIMEOUT = Integer.parseInt(FramwWorkProperties
			.getProperty("scriptTimeout"));

	public static final int IMPLICITLY_WAIT = Integer.parseInt(FramwWorkProperties
			.getProperty("implicitlyWait"));

	public static final String SCREENSHOT_PATH = FramwWorkProperties
			.getProperty("screenshotpath");

	public static final String USER_ID = FramwWorkProperties
			.getProperty("user.id");

	public static final String USER_PWD = FramwWorkProperties
			.getProperty("user.password");

	public static final String EXECUTION_GROUP = FramwWorkProperties
			.getProperty("executiongroup");

	// MySQL related data
	public static String MYSQL_SERVER_IP = FramwWorkProperties
			.getProperty("mysql.server.ip");
	public static String MYSQL_USER = FramwWorkProperties
			.getProperty("mysql.user");
	public static String MYSQL_PASSWORD = FramwWorkProperties
			.getProperty("mysql.password");
	public static String MYSQL_DATABASE = FramwWorkProperties
			.getProperty("mysql.database");


}
