package com.fundacionjala.pivotal.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.fundacionjala.pivotal.framework.util.PropertiesInfo.getInstance;

public class RemoteBrowser implements IDriver {


    private static final String CAPABILITY_NAME = "name";

    private static final String REMOTE_URL_AUTH = "@ondemand.saucelabs.com:80/wd/hub";

    private static final String HTTP_PROXY_HOST = "http.proxyHost";

    private static final String HTTP_PROXY_PORT = "http.proxyPort";

    public WebDriver initDriver() {
        System.getProperties().put(HTTP_PROXY_HOST, getInstance().getProxyHost());
        System.getProperties().put(HTTP_PROXY_PORT, getInstance().getProxyPort());
        URL url=null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, getInstance().getRemoteBrowser());
        caps.setCapability(CapabilityType.VERSION, getInstance().getBrowserVersion());
        caps.setCapability(CapabilityType.PLATFORM, getInstance().getPlatform());
        caps.setCapability(CAPABILITY_NAME, getInstance().getRemoteTestName());
        String sauceUrl = new StringBuilder().append("http://")
                .append(getInstance().getSauceUser())
                .append(":")
                .append(getInstance().getSauceAccessKey())
                .append(REMOTE_URL_AUTH).toString();
        try {
            url = new URL(sauceUrl);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(url, caps);
    }
}
