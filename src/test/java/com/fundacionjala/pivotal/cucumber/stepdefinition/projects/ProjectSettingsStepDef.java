package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.HashMap;
import java.util.Map;

import com.fundacionjala.pivotal.cucumber.stepdefinition.apisteps.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.GeneralSettingForm;
import com.fundacionjala.pivotal.pages.IAutomationStep;
import com.fundacionjala.pivotal.pages.Setting;
import com.fundacionjala.pivotal.pages.SettingSteps;
import com.fundacionjala.pivotal.pages.SideBarSetting;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.fundacionjala.pivotal.pages.SettingSteps.*;

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
    public void iUpdateGeneralSettingForProject(String projectsName,  Map<SettingSteps, Object> values) {
        SideBarSetting sideBar = setting.getSideBar();
        generalSettingForm = sideBar.clickGeneralSetting();
        executeSteps(values, generalSettingForm);
        generalSettingForm.clickSaveButton();
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        Assert.assertEquals(messageSay,generalSettingForm.getMessageTest());
    }

    private void executeSteps(Map<SettingSteps, Object> values, GeneralSettingForm generalSettingForm) {
        Map<SettingSteps, IAutomationStep> strategyMap = new HashMap<SettingSteps, IAutomationStep>();
        strategyMap.put(TITLE_PROJECTS, () -> generalSettingForm.setProjectTitleTestField(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(DESCRIPTION, () -> generalSettingForm.setProjectDescriptionTestField(values.get(DESCRIPTION).toString()));
        strategyMap.put(PROJECT_START_DATE, () -> generalSettingForm.selectStartIterationsOn(values.get(PROJECT_START_DATE).toString()));
        strategyMap.put(PROJECT_TIME_ZONE, () -> generalSettingForm.selectStartIterationsOn(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(ITERATION_LENGTH, () -> generalSettingForm.selectStartIterationsOn(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(POINT_SCALE, () -> generalSettingForm.selectStartIterationsOn(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(INITIAL_VELOCITY, () -> generalSettingForm.selectStartIterationsOn(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(NUMBER_OF_DONE_ITERATION_SHOW, () -> generalSettingForm.selectStartIterationsOn(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(PLAN_CURRENT_ITERATION, () -> generalSettingForm.selectStartIterationsOn(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(ENABLE_TASKS, () -> generalSettingForm.setProjectEnableTasksCheckbox(Boolean.parseBoolean(values.get(ENABLE_TASKS).toString())));
//        ALLOW_API_ACCESS;
//        REQUIRE_HTTPS_FOR_API_ACESS
//                ENABLE_RSS
//                PUBLIC_ACCESS
//                        ENABLE_INCOMING_EMAIL
//                        HIDE_EMAIL_ADDRESSES

        for (SettingSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }


}
