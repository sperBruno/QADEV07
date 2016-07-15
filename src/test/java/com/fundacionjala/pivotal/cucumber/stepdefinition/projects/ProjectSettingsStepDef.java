package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.Map;

import com.fundacionjala.pivotal.api.Mapper;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.*;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ProjectSettingsStepDef {

    private ApiResourcesSteps apiResourcesSteps;

    private LoginStepDef loginStepDef;

    private Setting setting;

    private GeneralSettingForm generalSettingForm;

    private Map<SettingSteps, Object> valuesMap;

    private Dashboard dashboard;

    public ProjectSettingsStepDef(ApiResourcesSteps apiResourcesSteps, LoginStepDef loginStepDef) {
        this.apiResourcesSteps = apiResourcesSteps;
        this.loginStepDef = loginStepDef;
    }

    @When("^I click Project1.name settings$")
    public void iClickProjectIdSettings() {
        String project = apiResourcesSteps.getResponse().jsonPath().get("id") + "";
        setting = loginStepDef.getDashboard().clickSettingsLink(project);
    }

    @And("^I update general setting for .*$")
    public void iUpdateGeneralSettingForProject(Map<SettingSteps, Object> values) {
        this.valuesMap = values;
        SideBarSetting sideBar = setting.getSideBar();
        generalSettingForm = sideBar.clickGeneralSetting();
        valuesMap.keySet().stream().forEach((step) -> {
            generalSettingForm.getStrategyStepMap(valuesMap).get(step).executeStep();
        });
        generalSettingForm.clickSaveButton();
    }

    public GeneralSettingForm getGeneralSettingForm() {
        return new GeneralSettingForm();
    }

    @And("^I Delete a .*$")
    public void iDeleteAProject() {
        SideBarSetting sideBar = setting.getSideBar();
        generalSettingForm = sideBar.clickGeneralSetting();
        DeleteProjectAlert deleteAlert = getGeneralSettingForm().clickLinkDeleteProject();
        dashboard = deleteAlert.clickDeleteBtn();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public Map<SettingSteps, Object> getValuesMap() {
        return valuesMap;
    }

    public Response getResponse() {
        return apiResourcesSteps.getResponse();
    }
}
