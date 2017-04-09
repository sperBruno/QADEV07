package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.framework.util.PropertiesInfo;

import java.util.concurrent.TimeUnit;

/**
 * This Class is login page the pivotal
 *
 * @Mijhaol Villarroel
 */

public class Login extends BasePage {

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    @FindBy(id = "credentials_username")
    private WebElement userNameTestField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTestField;

    @FindBy(css = ".app_signin_action_button")
    private static WebElement signInBtn;

    public void setUserNameTestField(String username) {
        CommonMethods.setWebElement(userNameTestField, username);
    }

    public void setPasswordTestField(String password) {
        CommonMethods.setWebElement(passwordTestField, password);
    }

    public static Dashboard loginAs(String userName, String password) {
        final WebDriver driver = DriverManager.getInstance().getDriver();
        if (driver.getTitle().contains("Pivotal Tracker - Sing in")) {
            return loginAsUser(userName, password);
        }

        //if exist some forms, modal dialogs or masks, refresh
        driver.navigate().refresh();

        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(5, TimeUnit.SECONDS);
            Dashboard dashboard = new Dashboard();
            if (!dashboard.getUserNameText().equalsIgnoreCase(dashboard.getUserName(userName))) {
                //logout
                driver.manage().deleteAllCookies();

                // force redirect to login page
                driver.get("https://www.pivotaltracker.com/signin");

                return loginAsUser(userName, password);
            }
        } catch (WebDriverException e) {
            // force redirect to login page
            driver.get("https://www.pivotaltracker.com/signin");

            return loginAsUser(userName, password);
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(30, TimeUnit.SECONDS);
        }


        return new Dashboard();
    }

    public Dashboard clickSignInButton() {
        CommonMethods.clickWebElement(signInBtn);
        return new Dashboard();
    }

    public static Dashboard loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getEmail(),
                PROPERTIES_INFO.getPassword());
    }

    private static Dashboard loginAsUser(String userName, String password) {
        Login login = new Login();
        login.setUserNameTestField(userName);
        CommonMethods.clickWebElement(signInBtn);
        login.setPasswordTestField(password);
        CommonMethods.clickWebElement(signInBtn);
        return new Dashboard();
    }
}
