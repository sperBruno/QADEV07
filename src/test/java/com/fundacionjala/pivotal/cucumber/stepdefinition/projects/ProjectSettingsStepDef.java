package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.Map;

import com.fundacionjala.pivotal.api.Mapper;
import com.fundacionjala.pivotal.cucumber.stepdefinition.apisteps.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ProjectSettingsStepDef {

    private ApiResourcesSteps apiResourcesSteps;

    private LoginStepDef loginStepDef;
    private Setting setting;
    private GeneralSettingForm generalSettingForm;

    public ProjectSettingsStepDef(ApiResourcesSteps apiResourcesSteps, LoginStepDef loginStepDef) {
        this.apiResourcesSteps = apiResourcesSteps;
        this.loginStepDef =  loginStepDef;
    }

    @When("^I click (.*) settings$")
    public void iClickProjectIdSettings(String projectName) {
        String project =apiResourcesSteps.getResponse().jsonPath().get("id")+"" ;
        System.out.println("El id es"+ project);
        setting = loginStepDef.getDashboard().clickSettingsLink(project);
    }

    @And("^I update general setting for (.*)$")
    public void iUpdateGeneralSettingForProject(String projectsName,  Map<String, Object> values) {
        SideBarSetting sideBar = setting.getSideBar();
        generalSettingForm = sideBar.clickGeneralSetting();
        generalSettingForm.selectStartIterationsOn("Sunday");
        generalSettingForm.clickSaveButton();
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        Assert.assertEquals(messageSay,generalSettingForm.getMessageTest());
    }


}
