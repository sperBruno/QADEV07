package org.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.DeleteProjectAlert;
import org.fundacionjala.pivotal.pages.setting.GeneralSettingForm;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.fundacionjala.pivotal.pages.setting.SettingSteps;
import org.fundacionjala.pivotal.pages.setting.SideBarSetting;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ProjectSettingsStepDef {

    private LoginStepDef loginStepDef;

    private Setting setting;

    private GeneralSettingForm generalSettingForm;

    private Map<SettingSteps, Object> valuesMap;

    private Dashboard dashboard;

    public ProjectSettingsStepDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    @When("^I click (.*) settings$")
    public void iClickProjectIdSettings(String name) {
        String project = Mapper.getPropertiesProject(name);
        setting = loginStepDef.getDashboard().clickSettingsLink(project);
    }

    @And("^I update general setting for .*$")
    public void iUpdateGeneralSettingForProject(Map<SettingSteps, Object> values) {
        this.valuesMap = values;
        SideBarSetting sideBar = setting.getSideBar();
        generalSettingForm = sideBar.clickGeneralSetting();
        valuesMap.keySet().forEach(step ->
                generalSettingForm.getStrategyStepMap(valuesMap).get(step).executeStep()
        );
        generalSettingForm.clickSaveButton();
    }

    public GeneralSettingForm getGeneralSettingForm() {
        return new GeneralSettingForm();
    }

    @And("^I click on delete project button$")
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

    public Setting getSetting() {
        return setting;
    }
}
