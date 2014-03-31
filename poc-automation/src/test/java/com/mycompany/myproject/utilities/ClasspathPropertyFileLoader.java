package com.mycompany.myproject.utilities;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

public class ClasspathPropertyFileLoader extends Properties {

    public Properties loadProperties(String propertyFile) throws IOException {
        Properties properties = new Properties();
        InputStream stream = null;
        try {

            stream = getClass().getClassLoader().getResourceAsStream(propertyFile);
            File dir1 = new File(".");
            if (stream == null) {
                stream = new FileInputStream(dir1.getCanonicalFile() +  "/src/test/java/com/mycompany/myproject/config/" + propertyFile);
            }
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return properties;

    }
}
