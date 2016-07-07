package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.framework.util.PropertiesInfo.*;

public class Login extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement userNameTestField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTestField;

    @FindBy(className = "app_signup_submit_button_button")
    private WebElement singInButton;

    @FindBy(css = ".app_signin_action_button")
    private WebElement buttonNext;

    private static Dashboard dashboard;

    public Login() {
        dashboard = new Dashboard();
    }

    public void setUserNameTestField(String username) {
        userNameTestField.clear();
        userNameTestField.sendKeys(username);
    }

    public void setPasswordTestField(String password) {
        passwordTestField.clear();
        passwordTestField.sendKeys(password);
    }

    public static Dashboard loginAS(String userName, String password) {
        if (!dashboard.getUserNameText().equals(userName)) {
            //Dashboard.logout();
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
        buttonNext.click();
        return new Dashboard();
    }

    public static Dashboard loginAsPrimaryUser() {
        return loginAS(getInstance().getEmail(),
                getInstance().getPassword());
    }
}
