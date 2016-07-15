package com.fundacionjala.pivotal.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class is for get the properties defined into properties file
 *
 * @author RosarioGarcia
 */
public class PropertiesInfo {

    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class.getSimpleName());

    private static final String CONFIG_PROPERTIES = "pivotal.properties";

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

    /**
     * This method is used to load the .properties file
     * which contains the configurations to project
     */
    private void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e.getCause());
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e.getCause());
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

    public String getUrlApi() {
        return getProperty("urlApi");
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
        return String.format("http://%s:%s", getProxyHost(), getProxyPort());
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

    public String getURLAPI() {
        return getProperty("urlApi");
    }
}
