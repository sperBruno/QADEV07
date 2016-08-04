package org.fundacionjala.pivotal.framework.util;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.accounts.AccountSetting;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.accounts.CreateAccountForm;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.fundacionjala.pivotal.framework.selenium.DriverManager.getInstance;
import static org.fundacionjala.pivotal.framework.util.Constants.CAPABILITY_NAME;
import static org.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotal.framework.util.Constants.ATTRIBUTE_ID;
import static org.fundacionjala.pivotal.framework.util.Constants.WORKSPACES_ENDPOINT;


/**
 * This class groups the generic methods
 *
 * @ Mijhail Villarroel
 */
public final class CommonMethods {

    private static final WebDriverWait WEB_DRIVER_WAIT = getInstance().getWait();

    private static final Logger LOGGER = Logger.getLogger(CommonMethods.class.getSimpleName());

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    private CommonMethods() {
    }

    /**
     * This Method return false o true if the element be present.
     *
     * @param webElement element
     * @return True or false
     */
    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            LOGGER.error("Web element not found", e);
            return false;

        }
    }

    /**
     * This method set a Web Element
     *
     * @param webElement
     * @param text
     */
    public static void setWebElement(WebElement webElement, String text) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This Method do click in element
     *
     * @param webElement
     */
    public static void clickWebElement(WebElement webElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This Method set a check box element
     *
     * @param webElement
     * @param enable
     */
    public static void setCheckBox(WebElement webElement, boolean enable) {
        if (enable) {
            unCheckBox(webElement);
        } else {
            checkBox(webElement);
        }
    }

    /**
     * This Method set a unchecked box element
     *
     * @param webElement
     */
    private static void unCheckBox(WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * This Method set a check box element
     *
     * @param webElement
     */
    private static void checkBox(WebElement webElement) {
        if (webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * Select 1 element the list
     *
     * @param webElementSelect
     * @param element
     */
    public static void selectAElementComboBox(WebElement webElementSelect, String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }

    /**
     * Convert a Select element
     *
     * @param webElement
     * @return
     */
    public static Select convertASelect(WebElement webElement) {
        return new Select(webElement);
    }

    /**
     * Delete all Project create by API
     */
    public static void deleteAllProjects() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(getRequest(PROJECTS_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.isEmpty()) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(PROJECTS_ENDPOINT + object.get(ATTRIBUTE_ID).toString());
            }
        }
    }

    /**
     * Delete all Project workspace by API
     */
    public static void deleteAllWorkspaces() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(getRequest(WORKSPACES_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.isEmpty()) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(WORKSPACES_ENDPOINT + object.get(ATTRIBUTE_ID).toString());
            }
        }
    }

    /**
     * Delete all account
     */
    public static void deleteAccounts() {
        DriverManager.getInstance().getDriver().get("https://www.pivotaltracker.com/accounts");
        Accounts accounts = new Accounts();
        try {
            while (isElementPresent(accounts.getManageAccountBtn())) {
                AccountSetting accountSetting = accounts.manageAccount().clickSettingTab();
                accounts = accountSetting.deleteAccount();
            }
            CreateAccountForm createAccountForm = accounts.clickNewAccountBtn();
            createAccountForm.setAccountNameTextField("SYSTEM");
            createAccountForm.clickCreateAccountBtn();
            DriverManager.getInstance().getDriver().get("https://www.pivotaltracker.com/dashboard");
        } catch (NullPointerException e) {
            LOGGER.error("Element null", e);
            throw new NoSuchElementException("Element not found");
        }
        DriverManager.getInstance().getDriver().get("https://www.pivotaltracker.com/dashboard");
    }

    public static void quitProgram(String message) {
        LOGGER.info("Element null " + message);
        Runtime.getRuntime().runFinalization();
    }

    public static Capabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, PROPERTIES_INFO.getRemoteBrowser());
        caps.setCapability(CapabilityType.VERSION, PROPERTIES_INFO.getBrowserVersion());
        caps.setCapability(CapabilityType.PLATFORM, PROPERTIES_INFO.getPlatform());
        caps.setCapability(CAPABILITY_NAME, PROPERTIES_INFO.getRemoteTestName());
        return caps;
    }
}
