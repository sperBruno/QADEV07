package com.fundacionjala.pivotal.cucumber.hooks;


import com.fundacionjala.pivotal.api.RequestManager;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectsStepDef;
import com.fundacionjala.pivotal.pages.Setting;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import org.apache.log4j.Logger;

import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.jayway.restassured.path.json.JsonPath.from;

public class ProjectHooks {

    private static final Logger LOGGER = Logger.getLogger(ProjectHooks.class.getName());

    private static final int SUCCESS_STATUS_CODE = 200;

    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String PROJECT_ID = "id";

    private ProjectsStepDef projectsStepDef;

    private ApiResourcesSteps api;

    public ProjectHooks(ApiResourcesSteps api, ProjectsStepDef projectsStepDef) {
        this.api = api;
        this.projectsStepDef = projectsStepDef;
    }

    @After("@project")
    public void afterProjectScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }

    @After("@ProjectSelenium")
    public void tearDown() {
        Setting setting = projectsStepDef.getProject().clickSettingTab();
        String id = "projects/" + setting.getSideBar().clickGeneralSetting().getProjectId();
        LOGGER.info("project id " + id);
        Response response = RequestManager.deleteRequest(id);
        LOGGER.info("status code " + response.getStatusCode());
    }

}
