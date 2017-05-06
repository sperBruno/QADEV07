package org.fundacionjala.pivotal.pages.account;

import org.fundacionjala.pivotal.pages.Login;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.accounts.CreateAccountForm;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Joaquin Gonzales on 5/5/2017.
 */
public class AddAccountTest {

    private Accounts accountpage;
    public static final String ACCOUNT_NAME = "test account";

    /**
     * @BeforeMethod(groups = {"Functional"}) Set up before to run the test case.
     * Given
     */
    @BeforeMethod(groups = {"Functional"})
    public void setup() {
        Login.loginAsPrimaryUser(); }

    /**
     * @BeforeMethod(groups = {"Functional"}) Method to test the account creation.
     */
    @Test(groups = {"Functional"})
    public void createAccountTest() {
        //When
        accountpage = ToolBar.clickAccountlink();
        CreateAccountForm createaccount = accountpage.clickNewAccountBtn();
        createaccount.setAccountNameTextField(ACCOUNT_NAME);
        createaccount.clickCreateAccountBtn();
        String actualResultAccountSettings = accountpage.accountNameCreated();
        String actualResultAccountCreatedTitle = accountpage.getAccountName();

        //Then
        Assert.assertEquals(actualResultAccountCreatedTitle, ACCOUNT_NAME);
        Assert.assertEquals(actualResultAccountSettings, ACCOUNT_NAME);
    }

    /**
     * @AfterMethod(groups = {"Functional"}) method to remove the account.
     */
    @AfterMethod(groups = {"Functional"})
    public void deleteAccountTest() {
        accountpage.deleteAccount();
    }
}
