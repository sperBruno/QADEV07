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

    /**
     * This method will be used to set Account name.
     *
     * @param accountName to be set.
     */
    public void setAccountNameTextField(String accountName) {
        setWebElement(accountNameTextField, accountName);
    }

    /**
     * This method will click on create account button.
     *
     * @return Accounts page.
     */
    public Accounts clickCreateAccountBtn() {
        createNewAccountBtn.click();
        return new Accounts();
    }

    /**
     * This method will be used to get error messages that can appear when creating an account.
     *
     * @return the error message.
     */
    public String getErrorMessageAtCreateAccount() {
        String errorMessage = "";
        if (isElementPresent(errorMessageAtCreateAccount)) {
            errorMessage = errorMessageAtCreateAccount.getText();
        }
        return errorMessage;
    }

}
