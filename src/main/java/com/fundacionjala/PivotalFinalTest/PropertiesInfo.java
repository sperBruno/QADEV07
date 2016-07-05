package com.fundacionjala.pivotal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is for get the properties defined into properties file
 *
 * @author RosarioGarcia
 */
public class PropertiesInfo {
    private static PropertiesInfo instance;

    private Properties properties;

    private PropertiesInfo() {
        loadProperties();
    }

    public static PropertiesInfo getInstance() {
        if (instance == null) {
            return new PropertiesInfo();
        }
        return instance;
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("pivotal.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public String getEmail() {
        return getProperty("email");
    }

    public String getPassword() {
        return getProperty("password");
    }

    public String getUrl() {
        return getProperty("url");
    }

    public String getBrowser() {
        return getProperty("browser");
    }

    public String getRemoteBrowser() {
        return getProperty("remoteBrowser");
    }

    public String getBrowserVersion() {
        return getProperty("browserVersion");
    }

    public String getPlatform() {
        return getProperty("platform");
    }

    public String getSauceUser() {
        return getProperty("sauceUser");
    }

    public String getSauceAccessKey() {
        return getProperty("sauceAccessKey");
    }

    public String getProxy() {
        return getProperty("proxy");
    }
}
