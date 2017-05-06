package org.fundacionjala.pivotal.pages.account;

import org.fundacionjala.pivotal.pages.Login;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.accounts.CreateAccountForm;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Joaquin Gonzales on 5/5/2017.
 */
public class DeleteAccountTest {

    protected Accounts accountpage;
    protected CreateAccountForm createaccount;
    protected static final String ACCOUNT_NAME = "test account";

    /**
     * @BeforeMethod(groups = {"Functional"}) Method to setup the testing.
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
     * @Test(groups = {"Functional"}) method that test the Delet account function.
     */
    @Test(groups = {"Functional"})
    public void deleteAccount() {
        //When
        accountpage.deleteAccount();
        String expectedResult = ACCOUNT_NAME + " was successfully deleted.";

        String actualResult = accountpage.getDeleteAccountMessage();
        //Then
        Assert.assertEquals(expectedResult, actualResult);
    }
}
