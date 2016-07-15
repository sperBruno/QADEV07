package com.fundacionjala.pivotal.cucumber.hooks;


import com.fundacionjala.pivotal.api.RequestManager;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectsStepDef;
import com.fundacionjala.pivotal.pages.Accounts;
import com.fundacionjala.pivotal.pages.Setting;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import org.apache.log4j.Logger;

import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.fundacionjala.pivotal.framework.util.Constants.DELETE_STATUS_CODE;
import static com.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static com.fundacionjala.pivotal.framework.util.Constants.PROJECT_ID;
import static com.fundacionjala.pivotal.framework.util.Constants.SUCCESS_STATUS_CODE;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.junit.Assert.assertEquals;

public class ProjectHooks {

    private static final Logger LOGGER = Logger.getLogger(ProjectHooks.class.getName());

    private ProjectsStepDef projectsStepDef;

    private ApiResourcesSteps api;

    public ProjectHooks(ApiResourcesSteps api, ProjectsStepDef projectsStepDef) {
        this.api = api;
        this.projectsStepDef = projectsStepDef;
    }

    @After("@project")
    public void afterProjectScenario() {
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }

    @After("@ProjectSelenium")
    public void tearDown() {
        Setting setting = projectsStepDef.getProject().clickSettingTab();
        String id = PROJECTS_ENDPOINT + setting.getSideBar().clickGeneralSetting().getProjectId();

        deleteAccountUser(setting);

        LOGGER.info("project id " + id);
        Response response = RequestManager.deleteRequest(id);
        LOGGER.info("status code " + response.getStatusCode());
        setting.getToolBar().clickReturnDashboardLink();
        LOGGER.info("Into toolbar");
        assertEquals(DELETE_STATUS_CODE,response.getStatusCode());
    }

    private void deleteAccountUser(Setting setting) {
        Accounts account = setting.getSideBar().clickGeneralSetting().clickAccountLink();
        account.getToolBarAccount().clickSettingTab().deleteAccount();
    }
}
