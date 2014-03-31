package com.mycompany.myproject.testdata;

import java.io.FileReader;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.mycompany.myproject.common.Configuration;

public class UserData {

	public String email;
	public String password;
	
	public UserData(String sFileName) throws Exception {
		final String fileName = Configuration.sProjectLocation + sFileName;
		 YamlReader reader = new YamlReader(new FileReader(fileName));
		 UserData userData = reader.read(UserData.class);
	}
	
	public static void main(String[] args) throws Exception {
		
	      final String fileName = Configuration.sProjectLocation + "/src/test/java/com/mycompany/myproject/testdata/UserData.yaml";

		 YamlReader reader = new YamlReader(new FileReader(fileName));
		 
			 	UserData contact = reader.read(UserData.class);
			    System.out.println(contact.email);
			    System.out.println(contact.password);
			    System.out.println("-----------------------------");
	}
}
