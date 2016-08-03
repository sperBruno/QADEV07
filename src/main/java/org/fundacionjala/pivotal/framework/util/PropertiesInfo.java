package org.fundacionjala.pivotal.framework.util;

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

    private static final String CONFIG_PROPERTIES = "gradle.properties";

    private static final String PROXY_PORT = "proxyPort";

    private static final String PROXY_HOST = "proxyHost";

    private static final String REMOTE_TEST_NAME = "remoteTestName";

    private static final String EMAIL = "email";

    private static final String PASSWORD = "password";

    private static final String URL = "url";

    private static final String URL_API = "urlApi";

    private static final String API_TOKEN = "apiToken";

    private static final String REMOTE_ACCESS_KEY = "remoteAccessKey";

    private static final String REMOTE_USER = "remoteUser";

    private static final String LOCAL_BROWSER = "localBrowser";

    private static final String REMOTE_BROWSER = "remoteBrowser";

    private static final String REMOTE_BROWSER_VERSION = "remoteBrowserVersion";

    private static final String REMOTE_PLATFORM = "remotePlatform";

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
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
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
        return !getProxyHost().isEmpty() ? String.format("http://%s:%s", getProxyHost(), getProxyPort()) : null;
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
