package org.fundacionjala.pivotal.pages.accounts;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class AccountSetting extends BasePage {

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    @FindBy(css = ".account_name>span")
    private WebElement accountName;

    public Accounts deleteAccount() {
        deleteAccountLink.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return new Accounts();
    }

    public String getAccountName() {
        return accountName.getText();
    }

}
