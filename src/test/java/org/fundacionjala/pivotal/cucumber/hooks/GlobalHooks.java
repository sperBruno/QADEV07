package org.fundacionjala.pivotal.cucumber.hooks;

import org.apache.commons.lang3.StringUtils;
import org.fundacionjala.pivotal.framework.util.PropertiesInfo;

import cucumber.api.java.Before;

import static org.fundacionjala.pivotal.framework.selenium.DriverManager.getInstance;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.deleteAllProjects;

/**
 * @author  Henrry Salinas.
 *
 * This class stores the global hooks methods required to run the test
 */
public class GlobalHooks {

    private static final String PROPERTIES_FILE_UNFILLED = "Error reading the properties file, one of the next properties is missing: email, api token or password";

    private static boolean BEFORE_ALL_FLAG = false;

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    @Before
    public void beforeAll() {
        if (!BEFORE_ALL_FLAG) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    getInstance().quitDriver();
                    deleteAllProjects();
                }
            });
            if (StringUtils.isEmpty(PROPERTIES_INFO.getEmail()) || StringUtils.isEmpty(PROPERTIES_INFO.getApiToken()) || StringUtils.isEmpty(PROPERTIES_INFO.getPassword())) {
                    System.err.println(PROPERTIES_FILE_UNFILLED);
                    Runtime.getRuntime().exit(1);
            }
            BEFORE_ALL_FLAG = true;
        }
    }
}
