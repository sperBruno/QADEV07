package com.fundacionjala.pivotal.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import static com.fundacionjala.pivotal.framework.util.Constants.API_TOKEN;
import static com.fundacionjala.pivotal.framework.util.Constants.CONFIG_PROPERTIES;
import static com.fundacionjala.pivotal.framework.util.Constants.EMAIL;
import static com.fundacionjala.pivotal.framework.util.Constants.LOCAL_BROWSER;
import static com.fundacionjala.pivotal.framework.util.Constants.PASSWORD;
import static com.fundacionjala.pivotal.framework.util.Constants.PROXY_HOST;
import static com.fundacionjala.pivotal.framework.util.Constants.PROXY_PORT;
import static com.fundacionjala.pivotal.framework.util.Constants.REMOTE_ACCESS_KEY;
import static com.fundacionjala.pivotal.framework.util.Constants.REMOTE_BROWSER;
import static com.fundacionjala.pivotal.framework.util.Constants.REMOTE_BROWSER_VERSION;
import static com.fundacionjala.pivotal.framework.util.Constants.REMOTE_PLATFORM;
import static com.fundacionjala.pivotal.framework.util.Constants.REMOTE_TEST_NAME;
import static com.fundacionjala.pivotal.framework.util.Constants.REMOTE_USER;
import static com.fundacionjala.pivotal.framework.util.Constants.URL;
import static com.fundacionjala.pivotal.framework.util.Constants.URL_API;

/**
 * This class is for get the properties defined into properties file
 *
 * @author RosarioGarcia
 */
public class PropertiesInfo {

    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class.getSimpleName());

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
        return getProperty(EMAIL);
    }

    public String getPassword() {
        return getProperty(PASSWORD);
    }

    public String getUrl() {
        return getProperty(URL);
    }

    public String getUrlApi() {
        return getProperty(URL_API);
    }

    public String getApiToken() {
        return getProperty(API_TOKEN);
    }

    public String getSauceUser() {
        return getProperty(REMOTE_USER);
    }

    public String getSauceAccessKey() {
        return getProperty(REMOTE_ACCESS_KEY);
    }

    public String getBrowser() {
        return getProperty(LOCAL_BROWSER);
    }

    public String getRemoteBrowser() {
        return getProperty(REMOTE_BROWSER);
    }

    public String getBrowserVersion() {
        return getProperty(REMOTE_BROWSER_VERSION);
    }

    public String getPlatform() {
        return getProperty(REMOTE_PLATFORM);
    }

    public String getProxy() {
        return String.format("http://%s:%s", getProxyHost(), getProxyPort());
    }

    public String getProxyHost() {
        return getProperty(PROXY_HOST);
    }

    public String getProxyPort() {
        return getProperty(PROXY_PORT);
    }

    public String getRemoteTestName() {
        return getProperty(REMOTE_TEST_NAME);
    }
}
