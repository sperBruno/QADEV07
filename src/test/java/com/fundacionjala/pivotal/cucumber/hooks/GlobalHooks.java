package com.fundacionjala.pivotal.cucumber.hooks;

import com.fundacionjala.pivotal.exceptions.PropertiesInfoReadException;
import com.fundacionjala.pivotal.framework.selenium.DriverManager;

import cucumber.api.java.Before;

import static com.fundacionjala.pivotal.framework.util.Constants.EMPTY_STRING;
import static com.fundacionjala.pivotal.framework.util.PropertiesInfo.getInstance;

/**
 * Created by HENRRY on 18/07/2016.
 */
public class GlobalHooks {
    private boolean BEFORE_ALL_FLAG = false;

    @Before
    public void beforeAll() {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                DriverManager.getInstance().quitDriver();
            }
        });
        if (!BEFORE_ALL_FLAG) {
            if (EMPTY_STRING.equals(getInstance().getEmail()) || EMPTY_STRING.equals(getInstance().getApiToken()) || EMPTY_STRING.equals(getInstance().getPassword())) {
                try {
                    throw new PropertiesInfoReadException("Error reading the properties file");
                } catch (PropertiesInfoReadException e) {
                    e.printStackTrace();
                }
            }
            BEFORE_ALL_FLAG = true;
        }
    }
}
