package org.fundacionjala.pivotal.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.pages.BasePage;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
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

    public Accounts deleteAccount() {
        clickWebElement(deleteAccountLink);
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
