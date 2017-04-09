package org.fundacionjala.pivotal.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.pages.BasePage;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * This method will be used to perform actions on AccountSettings.
 *
 * @author Bruno Barrios
 */
public class AccountSetting extends BasePage {

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    @FindBy(css = ".account_name>span")
    private WebElement accountName;

    @FindBy(xpath = "//h4[text()='ID']/following-sibling::div")
    private WebElement accountID;

    /**
     * This method will be used to delete account.
     *
     * @return Accounts page.
     */
    public Accounts deleteAccount() {
        clickWebElement(deleteAccountLink);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return new Accounts();
    }

    /**
     * This method will be used to get AccountId.
     *
     * @return AccountId.
     */
    public String getAccountID() {
        return accountID.getText();
    }

    /**
     * This method will get the account name.
     *
     * @return account name.
     */
    public String getAccountName() {
        return accountName.getText();
    }

}
