package org.fundacionjala.pivotal.framework.util;

import java.util.ArrayList;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.accounts.AccountSetting;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.accounts.CreateAccountForm;

import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.fundacionjala.pivotal.framework.selenium.DriverManager.getInstance;
import static org.fundacionjala.pivotal.framework.util.Constants.ATTRIBUTE_ID;
import static org.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotal.framework.util.Constants.WORKSPACES_ENDPOINT;


/**
 * This class groups the generic methods.
 *
 * @ Mijhail Villarroel
 */
public final class CommonMethods {

    private static final WebDriverWait WEB_DRIVER_WAIT = getInstance().getWait();

    private static final Logger LOGGER = Logger.getLogger(CommonMethods.class.getSimpleName());

    /**
     * This a private constructor.
     */
    private CommonMethods() {
    }

    /**
     * This Method return false o true if the element be present.
     *
     * @param webElement element.
     * @return True or false.
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
     * This method set a Web Element.
     *
     * @param webElement to be found.
     * @param text       to set.
     */
    public static void setWebElement(WebElement webElement, String text) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This Method do click in element.
     *
     * @param webElement to be found.
     */
    public static void clickWebElement(WebElement webElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This Method set a check box element.
     *
     * @param webElement to be found.
     * @param enable     the state.
     */
    public static void setCheckBox(WebElement webElement, boolean enable) {
        if (enable) {
            unCheckBox(webElement);
        } else {
            checkBox(webElement);
        }
    }

    /**
     * This Method set a unchecked box element.
     *
     * @param webElement to be found.
     */
    private static void unCheckBox(WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * This Method set a check box element.
     *
     * @param webElement to be found.
     */
    private static void checkBox(WebElement webElement) {
        if (webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * Select 1 element the list.
     *
     * @param webElementSelect to be found.
     * @param element          name.
     */
    public static void selectAElementComboBox(WebElement webElementSelect, String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }

    /**
     * Convert a Select element.
     *
     * @param webElement to be found.
     * @return an option.
     */
    public static Select convertASelect(WebElement webElement) {
        return new Select(webElement);
    }

    /**
     * Delete all Project create by API.
     */
    public static void deleteAllProjects() {
        ArrayList<Map<String, ?>> jsonAsArrayList = JsonPath.from(getRequest(PROJECTS_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.isEmpty()) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(PROJECTS_ENDPOINT + object.get(ATTRIBUTE_ID).toString());
            }
        }
    }

    /**
     * Delete all Project workspace by API.
     */
    public static void deleteAllWorkspaces() {
        ArrayList<Map<String, ?>> jsonAsArrayList = JsonPath.from(getRequest(WORKSPACES_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.isEmpty()) {
            for (Map<String, ?> object : jsonAsArrayList) {
                deleteRequest(WORKSPACES_ENDPOINT + object.get(ATTRIBUTE_ID).toString());
            }
        }
    }

    /**
     * Delete all account.
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

    /**
     * This method will be used to quit the app.
     *
     * @param message to be displayed when quiting the app.
     */
    public static void quitProgram(String message) {
        LOGGER.info("Element null " + message);
        Runtime.getRuntime().runFinalization();
    }
}
