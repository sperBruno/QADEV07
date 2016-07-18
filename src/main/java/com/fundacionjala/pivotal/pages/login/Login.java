package com.fundacionjala.pivotal.pages.login;

import com.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fundacionjala.pivotal.framework.util.PropertiesInfo;

import static com.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static com.fundacionjala.pivotal.framework.util.CommonMethods.setWebElement;

public class Login extends BasePage {

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    @FindBy(id = "credentials_username")
    private WebElement userNameTestField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTestField;

    @FindBy(className = "app_signup_submit_button_button")
    private WebElement singInButton;

    @FindBy(css = ".app_signin_action_button")
    private WebElement buttonNext;

    public void setUserNameTestField(String username) {
        setWebElement(userNameTestField, username);
    }

    public void setPasswordTestField(String password) {
        setWebElement(passwordTestField, password);
    }

    public static Dashboard loginAs(String userName, String password) {
        Dashboard dashboard = new Dashboard();
        if (!dashboard.getUserNameText().equalsIgnoreCase(userName)) {
            PivotalHome pivotalHome = new PivotalHome();
            Login login = pivotalHome.clickSingInLink();
            login.setUserNameTestField(userName);
            login.clickSignInButton();
            login.setPasswordTestField(password);
            return login.clickSignInButton();
        }
        return dashboard;
    }

    public void clickNextButton() {
        buttonNext.click();
    }

    public Dashboard clickSignInButton() {
        clickWebElement(buttonNext);
        return new Dashboard();
    }

    public static Dashboard loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getEmail(),
                PROPERTIES_INFO.getPassword());
    }
}
