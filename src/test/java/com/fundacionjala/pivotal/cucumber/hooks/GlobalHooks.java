package com.fundacionjala.pivotal.cucumber.hooks;

import com.fundacionjala.pivotal.exceptions.PropertiesInfoReadException;
import com.fundacionjala.pivotal.framework.selenium.DriverManager;
import com.fundacionjala.pivotal.framework.util.PropertiesInfo;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.Before;

/**
 * Created by HENRRY on 18/07/2016.
 */
public class GlobalHooks {
    private boolean BEFORE_ALL_FLAG = false;

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    @Before
    public void beforeAll() throws PropertiesInfoReadException {
        if (!BEFORE_ALL_FLAG) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    DriverManager.getInstance().quitDriver();
                }
            });
            if (StringUtils.isBlank(PROPERTIES_INFO.getEmail()) || StringUtils.isBlank(PROPERTIES_INFO.getApiToken()) || StringUtils.isBlank(PROPERTIES_INFO.getPassword())) {
                throw new PropertiesInfoReadException("Error reading the properties file");
            }
            BEFORE_ALL_FLAG = true;
        }
    }
}
