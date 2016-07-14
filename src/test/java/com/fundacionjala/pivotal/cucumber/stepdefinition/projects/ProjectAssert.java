package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.HashMap;
import java.util.Map;

import com.fundacionjala.pivotal.api.RequestManager;
import com.fundacionjala.pivotal.pages.*;
import com.jayway.restassured.response.Response;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static com.fundacionjala.pivotal.pages.SettingSteps.*;
import static com.fundacionjala.pivotal.pages.SettingSteps.BUGSCHORESMAYBEGIVENPOINTS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectAssert.class.getSimpleName());

    private Response response;

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    @Then("^A project page with set title (.*) must appear$")
    public void aProjectPageWithSetTitleProjectSeleniumTestMustAppear(String expectedTitle) {
        assertEquals(expectedTitle, projectsStepDef.getProject().getTitle());
    }

    @And("^The description projects should be equals (.*)$")
    public void theDescriptionProjectsShouldBeEqualsA(String expectedValue) {
        assertEquals(expectedValue, projectSettingsStepDef.getGeneralSettingForm().getDescriptionText());
    }

    @After
    public void tearDown() {
        Setting setting = projectsStepDef.getProject().clickSettingTab();
        String id = "projects/" + setting.getSideBar().clickGeneralSetting().getProjectId();
        LOGGER.info("project id " + id);
        response = RequestManager.deleteRequest(id);
        LOGGER.info("status code " + response.getStatusCode());
    }

    @And("^Validate all setting projects$")
    public void theDescriptionProjectsShouldBeEqualsA() {
        executeSteps(projectSettingsStepDef.getValues(), projectSettingsStepDef.getGeneralSettingForm());
        projectSettingsStepDef.getSettings().getToolBar().clickReturnDashboardLink();

    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        assertEquals(messageSay, projectSettingsStepDef.getGeneralSettingForm().getMessageTest());
    }

    private void executeSteps(Map<SettingSteps, Object> values, GeneralSettingForm generalSettingForm) {
        Map<SettingSteps, IAutomationStep2> strategyMap = new HashMap<>();
        strategyMap.put(TITLE_PROJECTS, () -> generalSettingForm.getProjectTitleTestField().equalsIgnoreCase(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(DESCRIPTION, () -> generalSettingForm.getDescriptionText().equalsIgnoreCase(values.get(DESCRIPTION).toString()));
        strategyMap.put(PROJECT_START_DATE, () -> generalSettingForm.getTextProjectWeekStartDaySelect().equalsIgnoreCase(values.get(PROJECT_START_DATE).toString()));
        strategyMap.put(ENABLE_TASKS, () -> generalSettingForm.getEnableProjectsTasks()==Boolean.parseBoolean(values.get(ENABLE_TASKS).toString()));
        strategyMap.put(ITERATION_LENGTH, () -> generalSettingForm.getTextProjectIterationLength().equalsIgnoreCase(values.get(ITERATION_LENGTH).toString()));
        for (SettingSteps step : values.keySet()) {
            assertTrue("Values that setting not is equals",strategyMap.get(step).executeStep());
        }
    }
}
