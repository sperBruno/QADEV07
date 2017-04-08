package org.fundacionjala.pivotal.cucumber.stepdefinition.account;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.accounts.Accounts;

import static org.junit.Assert.assertEquals;

/**
 * This Class verifies that the scenarios created for Account work properly.
 *
 * @author Bruno Barrios.
 */
public class AccountAssert {

    private AccountStepDef accountStepDef;

    private Accounts account;

    private String accountNameToBeDeleted;

    /**
     * This class receives the AccountStepDef as a parameter.
     *
     * @param accountStepDef
     */
    public AccountAssert(AccountStepDef accountStepDef) {
        this.accountStepDef = accountStepDef;
    }

    /**
     * This verifies if an account used to create a project is deleted.
     */
    @Then("^I should receive a message of account deleted from a project$")
    public void iShouldReceiveAMessageOfAccountDeletedFromAProject() {
        String expectedMessage = accountStepDef.getAccountName() + " was successfully deleted.";
        assertEquals(expectedMessage, accountStepDef.getAccount().getDeleteAccountMessage());
        accountStepDef.getAccount().getToolBar().clickReturnDashboardLink();
    }

    @Then("^I should get into (.*) Account setting$")
    public void iShouldGetIntoJorgeAccountSetting(String expectedAccount) {
        assertEquals(expectedAccount, accountStepDef.getAccountSetting().getAccountName());
    }

    @Then("^I delete (.*) account$")
    public void iDeleteAccount(String accountName) {
        accountNameToBeDeleted = accountName;
        account = accountStepDef.getAccountSetting().deleteAccount();
    }


    @Then("^I should receive a message of account deleted$")
    public void iShouldReceiveAMessageOfAccountDeleted() {
        String expectedMessage = accountNameToBeDeleted + " was successfully deleted.";
        assertEquals(expectedMessage, account.getDeleteAccountMessage());
        accountStepDef.getAccount().getToolBar().clickReturnDashboardLink();
    }
}
