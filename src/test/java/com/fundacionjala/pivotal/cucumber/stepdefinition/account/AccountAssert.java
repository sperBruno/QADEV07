package com.fundacionjala.pivotal.cucumber.stepdefinition.account;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by brunobarrios on 7/18/2016.
 */
public class AccountAssert {

    AccountStepDef accountStepDef;

    public AccountAssert(AccountStepDef accountStepDef) {
        this.accountStepDef = accountStepDef;
    }

    @Then("^I should receive a message of account deleted$")
    public void iShouldReceiveAMessageOfAccountDeleted() {
        String expectedMessage = accountStepDef.getAccountName() + " was successfully deleted.";
        assertEquals(expectedMessage, accountStepDef.getAccountName());
    }


}
