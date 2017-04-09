package org.fundacionjala.pivotal.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class is for get the properties defined into properties file.
 *
 * @author RosarioGarcia.
 */
public final class PropertiesInfo {

    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class.getSimpleName());

    private static final String CONFIG_PROPERTIES = "gradle.properties";

    private static final String PROXY_PORT = "proxyPort";

    private static final String PROXY_HOST = "proxyHost";

    private static final String REMOTE_TEST_NAME = "remoteTestName";

    private static final String EMAIL = "email";

    private static final String ACCESS_SECURITY = "password";

    private static final String URL = "url";

    private static final String URL_API = "urlApi";

    private static final String API_TOKEN = "apiToken";

    private static final String REMOTE_ACCESS_KEY = "remoteAccessKey";

    private static final String REMOTE_USER = "remoteUser";

    private static final String BROWSER = "browser";

    private static final String REMOTE_BROWSER = "remoteBrowser";

    private static final String REMOTE_BROWSER_VERSION = "remoteBrowserVersion";

    private static final String REMOTE_PLATFORM = "remotePlatform";

    private static final String REMOTE_TEST_HOST_URL = "remoteTestHostUrl";

    private static PropertiesInfo instance;

    private Properties properties;

    /**
     * This is the constructor of Properties info in which the properties file is loaded.
     */
    private PropertiesInfo() {
        loadProperties();
    }

    /**
     * This method will be used to get an instance of Properties info.
     *
     * @return PropertiesInfo.
     */
    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    /**
     * This method is used to load the .properties file.
     * which contains the configurations to project.
     */
    private void loadProperties() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e);
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e);
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                LOGGER.warn("A problem happen while closing", e);
            }
        }
    }

    /**
     * This method will be used to get a property.
     *
     * @param propertyKey to be required.
     * @return property value.
     */
    public String getProperty(String propertyKey) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
    }

    /**
     * This method will be used to get email property.
     *
     * @return email.
     */
    public String getEmail() {
        return getProperty(EMAIL);
    }

    /**
     * This method will be used to get password property.
     *
     * @return password.
     */
    public String getPassword() {
        return getProperty(ACCESS_SECURITY);
    }

    /**
     * This method will be used to get Url property.
     *
     * @return Url.
     */
    public String getUrl() {
        return getProperty(URL);
    }

    /**
     * This method will be used to get UrlApi property.
     *
     * @return UrlApi.
     */
    public String getUrlApi() {
        return getProperty(URL_API);
    }

    /**
     * This method will be used to get ApiToken property.
     *
     * @return ApiToken.
     */
    public String getApiToken() {
        return getProperty(API_TOKEN);
    }

    /**
     * This method will be used to get REmoteUser property.
     *
     * @return REmoteUser.
     */
    public String getRemoteUser() {
        return getProperty(REMOTE_USER);
    }

    /**
     * This method will be used to get RemoteAccessKey property.
     *
     * @return RemoteAccessKey.
     */
    public String getRemoteAccessKey() {
        return getProperty(REMOTE_ACCESS_KEY);
    }

    /**
     * This method will be used to get Browser property.
     *
     * @return Browser.
     */
    public String getBrowser() {
        return getProperty(BROWSER);
    }

    /**
     * This method will be used to get RemoteBrowser property.
     *
     * @return RemoteBrowser.
     */
    public String getRemoteBrowser() {
        return getProperty(REMOTE_BROWSER);
    }

    /**
     * This method will be used to get BrowserVersion property.
     *
     * @return BrowserVersion.
     */
    public String getBrowserVersion() {
        return getProperty(REMOTE_BROWSER_VERSION);
    }

    /**
     * This method will be used to get Platform property.
     *
     * @return Platform.
     */
    public String getPlatform() {
        return getProperty(REMOTE_PLATFORM);
    }

    /**
     * This method will be used to get Proxy property.
     *
     * @return Proxy.
     */
    public String getProxy() {
        return !getProxyHost().isEmpty() ? String.format("http://%s:%s", getProxyHost(), getProxyPort()) : null;
    }

    /**
     * This method will be used to get ProxyHost property.
     *
     * @return ProxyHost.
     */
    public String getProxyHost() {
        return getProperty(PROXY_HOST);
    }

    /**
     * This method will be used to get ProxyPort property.
     *
     * @return ProxyPort.
     */
    public String getProxyPort() {
        return getProperty(PROXY_PORT);
    }

    /**
     * This method will be used to RemoteTestName email property.
     *
     * @return RemoteTestName.
     */
    public String getRemoteTestName() {
        return getProperty(REMOTE_TEST_NAME);
    }

    /**
     * This method will be used to get TestHostUrl property.
     *
     * @return TestHostUrl.
     */
    public String getRemoteTestHostUrl() {
        return getProperty(REMOTE_TEST_HOST_URL);
    }
}
