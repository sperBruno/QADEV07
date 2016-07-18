package com.fundacionjala.pivotal.framework.util;

/**
 * This class will let us to use constants variables through the classes.
 * Created by brunobarrios on 7/13/2016.
 */
public final class Constants {

    public static final int IMPLICIT_PROJECT_WAIT = 30;

    public static final int IMPLICIT_WAIT_TIME = 15;

    public static final int WAIT_TIME = 30;

    public static final int LOAD_PAGE_TIME = 40;

    public static final int IMPLICIT_FAIL_WAIT_TIME = 8;

    public static final int DELETE_STATUS_CODE = 204;

    public static final int SUCCESS_STATUS_CODE = 200;

    public static final String PROJECTS_ENDPOINT = "/projects/";

    public static final String PROJECT_ID = "id";

    public static final String DASHBOARD = "Dashboard";

    public static final String TOKEN_HEADER = "X-TrackerToken";

    public static final String REGEX_INSIDE_BRACKETS = "[\\[]+[\\w.]+[^\\(]+\\]";

    public static final String REGEX_HALF_BRACKET = "[";

    public static final String REGEX_BRACKETS = "^\\[|\\]|\\.";

    public static final String REGEX_UNTIL_PROJECT = "^(\\/.*?\\/.*?\\/)";

    public static final String EMPTY_STRING = "";

    public static final String REGEX_SLASH = "/";

    public static final String PROJECT_1 = "Project1";

    public static final String CONFIG_PROPERTIES = "pivotal.properties";

    public static final String PROXY_PORT = "proxyPort";

    public static final String PROXY_HOST = "proxyHost";

    public static final String REMOTE_TEST_NAME = "remoteTestName";

    public static final String EMAIL = "email";

    public static final String PASSWORD = "password";

    public static final String URL = "url";

    public static final String URL_API = "urlApi";

    public static final String API_TOKEN = "apiToken";

    public static final String REMOTE_ACCESS_KEY = "remoteAccessKey";

    public static final String REMOTE_USER = "remoteUser";

    public static final String LOCAL_BROWSER = "localBrowser";

    public static final String REMOTE_BROWSER = "remoteBrowser";

    public static final String REMOTE_BROWSER_VERSION = "remoteBrowserVersion";

    public static final String REMOTE_PLATFORM = "remotePlatform";

    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    public static final String DRIVER_PATH = "lib/chromedriver.exe";

    public static final String WEBDRIVER_CHROME_PROPERTY = "webdriver.chrome.driver";

    public static final String CAPABILITY_NAME = "name";

    public static final String HTTP_PROXY_HOST = "http.proxyHost";

    public static final String HTTP_PROXY_PORT = "http.proxyPort";


    private Constants() {
    }
}
