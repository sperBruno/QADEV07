package org.fundacionjala.pivotal.pages.accounts;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * This class represents Account page and its characteristics.
 *
 * @author Bruno Barrios
 */
public class Accounts extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Accounts.class.getName());

    private final ToolBarAccount toolBarAccount;

    @FindBy(id = "notice")
    private WebElement deleteAccountMessage;

    @FindBy(xpath = "//a[contains(.,'Manage Account')]")
    private WebElement manageAccountBtn;

    @FindBy(id = "new_account_link")
    private WebElement createNewAccountLink;

    @FindBy(id = "account_name")
    private WebElement accountTextBox;

    @FindBy(id = "add_account_button")
    private WebElement createNewAccountBtn;

    /**
     * This class instances a ToolBarAccount.
     */
    public Accounts() {
        toolBarAccount = new ToolBarAccount();
    }

    /**
     * This method is used to get into an Account properties and settings.
     *
     * @return {@link ToolBarAccount}
     */
    public ToolBarAccount manageAccount() {
        clickWebElement(manageAccountBtn);
        return new ToolBarAccount();
    }

    /**
     * This method is used to catch the message that is displayed after deleting an
     * account.
     *
     * @return the message of deleting an account.
     */
    public String getDeleteAccountMessage() {
        LOGGER.info("Message delete account " + deleteAccountMessage.getText());
        return deleteAccountMessage.getText();
    }

    /**
     * @return {@link CreateAccountForm}
     */
    public CreateAccountForm clickNewAccountBtn() {
        clickWebElement(createNewAccountLink);
        return new CreateAccountForm();
    }

    /**
     * This method will be used to get account button.
     *
     * @return manage account button.
     */
    public WebElement getManageAccountBtn() {
        return manageAccountBtn;
    }

    /**
     * This method will be used to ToolBarAccount.
     *
     * @return ToolBarAccount.
     */
    public ToolBarAccount getToolBarAccount() {
        return toolBarAccount;
    }

    /**
     * This method will be used to get tool bar.
     *
     * @return ToolBar.
     */
    public ToolBar getToolBar() {
        return new ToolBar();
    }
}
