package com.mycompany.myproject.testdata;

import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.mycompany.myproject.common.Configuration;

public class TestData {

	public static Map<COUPON_TYPE, Hashtable<String, String>> COUPON_DATA;
	public static String USER_EMAIL;
	public static String USER_PASSWORD;

	public enum COUPON_TYPE {
		MANUFACTURER, TI, HOLIDAY
	}

	static {
		final String fileName = Configuration.sProjectLocation
				+ "/src/test/java/com/mycompany/myproject/testdata/UserData.yaml";
		try {
			YamlReader reader = new YamlReader(new FileReader(fileName));
			 Map data = (Map) reader.read();
			 USER_EMAIL = (String) data.get("email");
			 USER_PASSWORD = (String) data.get("password");
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
