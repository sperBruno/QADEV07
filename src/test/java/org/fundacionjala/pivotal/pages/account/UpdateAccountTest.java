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
public class UpdateAccountTest {
    protected Accounts accountpage;
    protected CreateAccountForm createaccount;
    protected static final String ACCOUNT_NAME = "test account";
    protected static final String NEW_ACCOUNT_NAME = "New Account Name";

    /**
     * @BeforeMethod(groups = {"Functional"}) setup the test.
     */
    @BeforeMethod(groups = {"Functional"})
    public void setup() {
        //Given
        Login.loginAsPrimaryUser();
        accountpage = ToolBar.clickAccountlink();
        createaccount = accountpage.clickNewAccountBtn();
        createaccount.setAccountNameTextField(ACCOUNT_NAME);
        createaccount.clickCreateAccountBtn();
    }

    /**
     * @Test(groups = {"Functional"}) edit account test.
     */
    @Test(groups = {"Functional"})
    public void editAccountTest() {
        //When
        accountpage.editAccount(NEW_ACCOUNT_NAME);
        String actualResultSettings = accountpage.accountNameCreated();

        //Then
        Assert.assertEquals(actualResultSettings, NEW_ACCOUNT_NAME);
    }

    /**
     * @AfterMethod(groups = {"Functional"}) after method for edit.
     */
    @AfterMethod(groups = {"Functional"})
    public void deleteAccount() {
        accountpage.deleteAccount();
    }
}
