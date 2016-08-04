package org.fundacionjala.pivotal.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.util.PropertiesInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.setCapabilities;
import static org.fundacionjala.pivotal.framework.util.Constants.HTTP_PROXY_HOST;
import static org.fundacionjala.pivotal.framework.util.Constants.HTTP_PROXY_PORT;

/**
 * This class initialize the Remote Selenium Web Driver given the required values in properties file
 *
 * @author Henrry Salinas.
 */
public class BrowserStack implements IDriver {

    private static final Logger LOGGER = Logger.getLogger(BrowserStack.class.getSimpleName());

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        System.getProperties().put(HTTP_PROXY_HOST, PROPERTIES_INFO.getProxyHost());
        System.getProperties().put(HTTP_PROXY_PORT, PROPERTIES_INFO.getProxyPort());
        final String sauceUrl = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub",
                PROPERTIES_INFO.getRemoteUser(), PROPERTIES_INFO.getRemoteAccessKey());
        URL url = null;
        try {
            url = new URL(sauceUrl);
        } catch (MalformedURLException e) {
            LOGGER.warn("The url is not correct" + e);
        }
        return new RemoteWebDriver(url, setCapabilities());
    }
}
