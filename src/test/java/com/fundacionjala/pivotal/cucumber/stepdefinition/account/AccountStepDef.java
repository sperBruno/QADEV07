package com.fundacionjala.pivotal.cucumber.stepdefinition.account;

import java.util.Map;

import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectsStepDef;
import com.fundacionjala.pivotal.pages.AccountSetting;
import com.fundacionjala.pivotal.pages.Accounts;
import com.fundacionjala.pivotal.pages.CreateProject;
import com.fundacionjala.pivotal.pages.Project;
import com.fundacionjala.pivotal.pages.ProjectSteps;
import com.fundacionjala.pivotal.pages.Setting;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

/**
 * Created by brunobarrios on 7/18/2016.
 */
public class AccountStepDef {

    private static Logger LOGGER = Logger.getLogger(AccountStepDef.class.getName());
    private static Setting SETTING;

    private LoginStepDef loginStepDef;

    private ProjectsStepDef projectsStepDef;

    private String accountName;
    Accounts account;
    private Map<ProjectSteps, Object> valuesMap;

    public AccountStepDef(LoginStepDef loginStepDef, ProjectsStepDef projectsStepDef) {
        this.loginStepDef = loginStepDef;
        this.projectsStepDef = projectsStepDef;
    }
//
//    @And("^I delete the of the project$")
//    public void iDeleteTheAccountOfTheProject() {
//        SETTING = StoriesStepsDef.getProject().clickSettingTab();
//         account = SETTING.getSideBar().clickGeneralSetting().clickAccountLink();
//        AccountSetting accountSetting = account.getToolBarAccount().clickSettingTab();
//        accountName = account.getDeleteAccountMessage();
//        accountSetting.deleteAccount();
//    }

    public String getAccountName() {
        return accountName;
    }

    public Accounts getAccountPage() {
        return new Accounts();
    }

    @Given("^I get into account Page$")
    public void iGetIntoAccountPage() throws Throwable {
        account = loginStepDef.getDashboard().selectAccountOption();
    }

    @And("^I delete the account of the project$")
    public void iDeleteTheAccountOfTheProject() {
        Accounts a = account.manageAccount().clickSettingTab().deleteAccount();
    }
}
