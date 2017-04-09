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

import static org.fundacionjala.pivotal.framework.util.Constants.FIVE;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * This Class is login page the pivotal.
 *
 * @author Villarroel.
 */
public class Login extends BasePage {

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();
    private static final String SIGING_URL = "https://www.pivotaltracker.com/signin";


    @FindBy(id = "credentials_username")
    private WebElement userNameTestField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTestField;

    @FindBy(css = ".app_signin_action_button")
    private static WebElement signInBtn;

    /**
     * This method will be used to set user name text field.
     *
     * @param username to set.
     */
    public void setUserNameTestField(String username) {
        CommonMethods.setWebElement(userNameTestField, username);
    }

    /**
     * This method will be used to set password text field.
     *
     * @param password to set.
     */
    public void setPasswordTestField(String password) {
        CommonMethods.setWebElement(passwordTestField, password);
    }

    /**
     * This method will be used to control user session to login.
     *
     * @param userName to login.
     * @param password to login.
     * @return Dashboard.
     */
    public static Dashboard loginAs(String userName, String password) {
        final WebDriver driver = DriverManager.getInstance().getDriver();
        if (driver.getTitle().contains("Pivotal Tracker - Sing in")) {
            return loginAsUser(userName, password);
        }

        //if exist some forms, modal dialogs or masks, refresh
        driver.navigate().refresh();

        try {
            driver.manage().timeouts().implicitlyWait(FIVE, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(FIVE, TimeUnit.SECONDS);
            Dashboard dashboard = new Dashboard();
            if (!dashboard.getUserNameText().equalsIgnoreCase(dashboard.getUserName(userName))) {
                //logout
                driver.manage().deleteAllCookies();

                // force redirect to login page
                driver.get(SIGING_URL);

                return loginAsUser(userName, password);
            }
        } catch (WebDriverException e) {
            // force redirect to login page
            driver.get(SIGING_URL);

            return loginAsUser(userName, password);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(WAIT_TIME, TimeUnit.SECONDS);
        }


        return new Dashboard();
    }

    /**
     * This method will click on singin button.
     *
     * @return Dashboard.
     */
    public Dashboard clickSignInButton() {
        CommonMethods.clickWebElement(signInBtn);
        return new Dashboard();
    }

    /**
     * This method will login using properties values.
     *
     * @return Dashboard.
     */
    public static Dashboard loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getEmail(),
                PROPERTIES_INFO.getPassword());
    }

    /**
     * This method will do the login process.
     *
     * @param userName to login
     * @param password to login.
     * @return Dashboard.
     */
    private static Dashboard loginAsUser(String userName, String password) {
        Login login = new Login();
        login.setUserNameTestField(userName);
        CommonMethods.clickWebElement(signInBtn);
        login.setPasswordTestField(password);
        CommonMethods.clickWebElement(signInBtn);
        return new Dashboard();
    }
}
