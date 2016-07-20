package org.fundacionjala.pivotal.cucumber.stepdefinition.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import org.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectsStepDef;
import org.fundacionjala.pivotal.pages.accounts.AccountSetting;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.setting.Setting;

/**
 * This class is used to execute the steps of Account scenarios.
 * Created by brunobarrios on 7/18/2016.
 */
public class AccountStepDef {

    private Accounts account;

    private LoginStepDef loginStepDef;

    private ProjectsStepDef projectsStepDef;

    private String accountName;

    /**
     * This class receives LoginStepDef and ProjectStepDef as a parameters.
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
    public void iGetIntoAccountPage()  {
        account = loginStepDef.getDashboard().selectAccountOption();
    }

    /**
     * This method will delete an account inside of a project.
     */
    @And("^I delete the account of the project$")
    public void iDeleteTheAccountOfTheProject() {
        Setting setting = projectsStepDef.getProject().clickSettingTab();
        account = setting.getSideBar().clickGeneralSetting().clickAccountLink();
        AccountSetting accountSetting = account.getToolBarAccount().clickSettingTab();
        accountName = accountSetting.getAccountName();
        accountSetting.deleteAccount();
    }

    public Accounts getAccount() {
        return account;
    }

    public ProjectsStepDef getProjectsStepDef() {
        return projectsStepDef;
    }

    public String getAccountName() {
        return accountName.toString();
    }

    public Accounts getAccountPage() {
        return new Accounts();
    }

    @And("^I create an account with name (.*)$")
    public void iCreateAnAccountWithNameFelipe(String accountName) {

    }
}
