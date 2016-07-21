package org.fundacionjala.pivotal.pages.accounts;

import org.fundacionjala.pivotal.framework.util.CommonMethods;
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

    @FindBy(xpath = ".//*/div[1]/ul/li[1]/div")
    private WebElement accountID;

    public Accounts deleteAccount() {
        //deleteAccountLink.click();
        CommonMethods.clickWebElement(deleteAccountLink);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return new Accounts();
    }

    public String getAccountID() {
        return accountID.getText();
    }

    public String getAccountName() {
        return accountName.getText();
    }

}
