package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class AccountSetting extends BasePage {

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    public Accounts deleteAccount() {
        deleteAccountLink.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return new Accounts();
    }
}
