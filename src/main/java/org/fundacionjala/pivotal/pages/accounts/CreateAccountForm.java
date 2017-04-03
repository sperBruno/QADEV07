package org.fundacionjala.pivotal.pages.accounts;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.isElementPresent;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.setWebElement;

/**
 * Created by brunobarrios on 7/21/2016.
 */
public class CreateAccountForm extends BasePage {

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(id = "add_account_button")
    private WebElement createNewAccountBtn;

    @FindBy(id = "error")
    private WebElement errorMessageAtCreateAccount;

    public void setAccountNameTextField(String accountName) {
        setWebElement(accountNameTextField, accountName);
    }

    public Accounts clickCreateAccountBtn() {
        createNewAccountBtn.click();
        return new Accounts();
    }

    public String getErrorMessageAtCreateAccount() {
        String errorMessage = "";
        if (isElementPresent(errorMessageAtCreateAccount)) {
            errorMessage = errorMessageAtCreateAccount.getText();
        }
        return errorMessage;
    }

}
