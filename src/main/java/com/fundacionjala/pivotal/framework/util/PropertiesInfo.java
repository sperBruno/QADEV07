package com.fundacionjala.pivotal.framework.util;

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
            instance = new PropertiesInfo();
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
        return getProperty("localBrowser");
    }

    public String getRemoteBrowser() {
        return getProperty("remoteBrowser");
    }

    public String getBrowserVersion() {
        return getProperty("remoteBrowserVersion");
    }

    public String getPlatform() {
        return getProperty("remotePlatform");
    }

    public String getSauceUser() {
        return getProperty("remoteUser");
    }

    public String getSauceAccessKey() {
        return getProperty("remoteAccessKey");
    }

    public String getProxy() {
        return new StringBuilder().append("http://")
                .append(getProxyHost())
                .append(":")
                .append(getProxyPort()).toString();
    }

    public String getProxyHost() {
        return getProperty("proxyHost");
    }

    public String getProxyPort() {
        return getProperty("proxyPort");
    }

    public String getRemoteTestName() {
        return getProperty("remoteTestName");
    }

    public String getApiToken() {
        return getProperty("apiToken");
    }

}
