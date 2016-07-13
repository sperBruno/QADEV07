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
        Map<SettingSteps, IAutomationStep> strategyMap = new HashMap<>();
        strategyMap.put(TITLE_PROJECTS, () -> generalSettingForm.setProjectTitleTestField(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(DESCRIPTION, () -> generalSettingForm.setProjectDescriptionTestField(values.get(DESCRIPTION).toString()));
        strategyMap.put(PROJECT_START_DATE, () -> generalSettingForm.setProjectWeekStartDayComboBox(values.get(PROJECT_START_DATE).toString()));
        strategyMap.put(PROJECT_TIME_ZONE, () -> generalSettingForm.setProjectTimeZoneComboBox(values.get(PROJECT_TIME_ZONE).toString()));
        strategyMap.put(ITERATION_LENGTH, () -> generalSettingForm.setProjectIterationLengthComboBox(values.get(ITERATION_LENGTH).toString()));
        strategyMap.put(POINT_SCALE, () -> generalSettingForm.setProjectSettingsPointScaleComboBox(values.get(POINT_SCALE).toString()));
        strategyMap.put(INITIAL_VELOCITY, () -> generalSettingForm.setProjectInitialVelocityTestField(values.get(INITIAL_VELOCITY).toString()));
        strategyMap.put(VELOCITY_STRATEGY, () -> generalSettingForm.setProjectVelocityComboBox(values.get(VELOCITY_STRATEGY).toString()));
        strategyMap.put(NUMBER_OF_DONE_ITERATION_SHOW, () -> generalSettingForm.setProjectNumberOfDoneIterationsToShowTestField(values.get(NUMBER_OF_DONE_ITERATION_SHOW).toString()));
        strategyMap.put(PLAN_CURRENT_ITERATION, () -> generalSettingForm.setProjectAutomaticPlanningCheckBox(values.get(PLAN_CURRENT_ITERATION).toString()));
        strategyMap.put(ENABLE_TASKS, () -> generalSettingForm.setProjectEnableTasksCheckbox(Boolean.parseBoolean(values.get(ENABLE_TASKS).toString())));
        strategyMap.put(ALLOW_API_ACCESS, () -> generalSettingForm.setProjectAPIAccessCheckbox(Boolean.parseBoolean(values.get(ALLOW_API_ACCESS).toString())));
        strategyMap.put(REQUIRE_HTTPS_FOR_API_ACESS, () -> generalSettingForm.setProjectUseHttpsCheckBox(Boolean.parseBoolean(values.get(REQUIRE_HTTPS_FOR_API_ACESS).toString())));
        strategyMap.put(ENABLE_RSS, () -> generalSettingForm.setProjectAtomRssCheckBox(Boolean.parseBoolean(values.get(ENABLE_RSS).toString())));
        strategyMap.put(PUBLIC_ACCESS, () -> generalSettingForm.setProjectPublicAccessCheckBox(Boolean.parseBoolean(values.get(PUBLIC_ACCESS).toString())));
        strategyMap.put(ENABLE_INCOMING_EMAIL, () -> generalSettingForm.setProjectEnableIncomingEmailCheckBox(Boolean.parseBoolean(values.get(ENABLE_INCOMING_EMAIL).toString())));
        strategyMap.put(HIDE_EMAIL_ADDRESSES, () -> generalSettingForm.setProjectHideEmailsFromCollaboratorsCheckBox(Boolean.parseBoolean(values.get(HIDE_EMAIL_ADDRESSES).toString())));
        strategyMap.put(BUGSCHORESMAYBEGIVENPOINTS, () -> generalSettingForm.setProjectBugsCheckBox(Boolean.parseBoolean(values.get(BUGSCHORESMAYBEGIVENPOINTS).toString())));
        for (SettingSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }

    public  GeneralSettingForm getGeneralSettingForm() {
        return generalSettingForm;
    }




}
