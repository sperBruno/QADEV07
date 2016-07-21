package org.fundacionjala.pivotal.cucumber.stepdefinition.account;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import org.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectsStepDef;
import org.fundacionjala.pivotal.pages.accounts.AccountSetting;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.accounts.CreateAccountForm;
import org.fundacionjala.pivotal.pages.setting.Setting;

import static org.fundacionjala.pivotal.framework.selenium.DriverManager.getInstance;

/**
 * This class is used to execute the steps of Account scenarios.
 * Created by brunobarrios on 7/18/2016.
 */
public class AccountStepDef {

    private static final Logger LOGGER=Logger.getLogger(AccountStepDef.class.getName());
    public static final String PIVOTAL_URL = "https://www.pivotaltracker.com";
    private static final String SETTINGS = "/settings";
    private static final String ACCOUNTS = "/accounts";
    private Accounts account;
    private LoginStepDef loginStepDef;
    private ProjectsStepDef projectsStepDef;
    private String accountName;
    private AccountSetting accountSetting;
    private Setting setting;
    private Map<String, String> accountData=new HashMap<String,String>();

    /**
     * This class receives LoginStepDef and ProjectStepDef as a parameters.
     *
     * @param loginStepDef
     * @param projectsStepDef
     */
    public AccountStepDef(LoginStepDef loginStepDef, ProjectsStepDef projectsStepDef) {
        this.loginStepDef = loginStepDef;
        this.projectsStepDef = projectsStepDef;
    }

    /**
     * This method is used to get into the account page from dashboard.
     */
    @Given("^I get into account Page$")
    public void iGetIntoAccountPage() {
        account = loginStepDef.getDashboard().selectAccountOption();
    }

    /**
     * This method will delete an account inside of a project.
     */
    @And("^I delete the account of the project$")
    public void iDeleteTheAccountOfTheProject() {
        setting = projectsStepDef.getProject().clickSettingTab();
        account = setting.getSideBar().clickGeneralSetting().clickAccountLink();
        AccountSetting accountSetting = account.getToolBarAccount().clickSettingTab();
        accountName = accountSetting.getAccountName();
        accountSetting.deleteAccount();
    }

    @And("^I create a new account with name (.*)$")
    public void iCreateANewAccountWithName(String newAccountName) {
        CreateAccountForm createAccountForm = account.clickNewAccountBtn();
        createAccountForm.setAccountNameTextField(newAccountName);
        Accounts accounts=createAccountForm.clickCreateAccountBtn();
        accountSetting =accounts.getToolBarAccount().clickSettingTab();
        accountName = accountSetting.getAccountName();
        String id = accountSetting.getAccountID();
        LOGGER.info("id account" + id);
        accountData.put(newAccountName,id );

    }

    @Given("^I delete (.*) account$")
    public void iDeleteAccount(String accountName) {
        String endpoint = PIVOTAL_URL + ACCOUNTS + accountData.get(accountName) + SETTINGS;
        account = accountSetting.deleteAccount();
    }

    public AccountSetting getAccountSetting() {
        return accountSetting;
    }

    public Accounts getAccount() {
        return account;
    }

    public String getAccountName() {
        return accountName.toString();
    }
}
