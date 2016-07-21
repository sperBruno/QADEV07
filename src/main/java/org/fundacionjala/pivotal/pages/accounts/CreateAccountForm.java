package org.fundacionjala.pivotal.pages.accounts;

import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.setWebElement;

/**
 * Created by brunobarrios on 7/21/2016.
 */
public class CreateAccountForm extends BasePage {

    private String errorMessage;

    @FindBy(css = "input[id='account_name']")
    private WebElement accountNameTextField;

    @FindBy(css = "input[id='add_account_button']")
    private WebElement createNewAccountBtn;

    @FindBy(css = "li[id='error']")
    private WebElement errorMessageAtCreateAccount;

    public void setAccountNameTextField(String accountName) {
        setWebElement(accountNameTextField, accountName);
    }

    public AccountSetting clickCreateAccountBtn() {
        clickWebElement(createNewAccountBtn);
        return new AccountSetting();
    }

    public void validateErrorMessageAtCreateAccount() {
        if (CommonMethods.isElementPresent(errorMessageAtCreateAccount)) {
            errorMessage = errorMessageAtCreateAccount.getText();
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
