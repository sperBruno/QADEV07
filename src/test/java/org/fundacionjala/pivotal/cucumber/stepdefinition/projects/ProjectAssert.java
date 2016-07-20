package org.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.pages.setting.Setting;

import static org.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.fundacionjala.pivotal.framework.util.Constants.ERROR_ACCOUNT_MESSAGE_TEXT;
import static org.fundacionjala.pivotal.framework.util.Constants.ERROR_PROJECT_TITLE_TEXT;
import static org.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static org.junit.Assert.assertEquals;

/**
 * This class is used to validate all the scenarios related to a Project.
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectAssert.class.getName());

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    private Response responseProject;

    private String endpointProject;

    /**
     * This class receives ProjectStepDef and ProjectSettingsStepDef as parameters.
     *
     * @param projectsStepDef
     * @param projectSettingsStepDef
     */
    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    /**
     * This class is used to validate whether the project description is equals as an expected
     * project description.
     *
     * @param expectedValue is the expected description of the project
     */
    @And("^The description projects should be equals (.*)$")
    public void theDescriptionProjectsShouldBeEqualsA(String expectedValue) {
        assertEquals(expectedValue, projectSettingsStepDef.getGeneralSettingForm().getDescriptionText());
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        assertEquals(messageSay, projectSettingsStepDef.getGeneralSettingForm().getMessageTest());
    }

    @Then("^I expect a message Delete say (.*)$")
    public void iExpectAMessageDeleteSayProject1Name(String message) {
        final String expectMessage = Mapper.getPropertiesProject(message);
        assertEquals(expectMessage, projectSettingsStepDef.getDashboard().getMessageTextDelete());
    }

    /**
     * This class is used to validate whether the project name is equals as expected project name.
     *
     * @param expectedValue is the expected project name or title.
     */
    @Then("^The project title should be equals (.*)$")
    public void theProjectTitleShouldBeEqualsProjectSeleniumTest(String expectedValue) {
        Setting setting = projectsStepDef.getProject().clickSettingTab();
        endpointProject = PROJECTS_ENDPOINT + setting.getSideBar().clickGeneralSetting().getProjectId().toString();
        LOGGER.info("project id " + endpointProject.toString());
        responseProject = getRequest(endpointProject);
        LOGGER.info("title project end point" + responseProject.jsonPath().get("name"));
        LOGGER.info("title project locator" + projectsStepDef.getProject().getTitle());
        assertEquals(expectedValue, projectsStepDef.getProject().getTitle());
    }

    @And("^Validate all setting projects$")
    public void validateAllSettingProjects() {
        projectSettingsStepDef.getValuesMap().keySet().stream().forEach((step) -> {
            assertEquals(String.valueOf(projectSettingsStepDef.getGeneralSettingForm().getAssertionMap().get(step)), projectSettingsStepDef.getValuesMap().get(step));
        });
        projectSettingsStepDef.getSetting().getToolBar().clickReturnDashboardLink();
    }

    @And("^I verify that the account of the created project is (.*)$")
    public void iVerifyThatTheAccountOfTheCreatedProjectIsLuis(String expectedAccount) {


        String accountId = responseProject.jsonPath().get("account_id").toString();
        String endpointAccount = "/accounts/" + accountId;
        Response responseAccount = getRequest(endpointAccount);
        String actualResult = responseAccount.jsonPath().get("name");
        LOGGER.info("Account is :" + actualResult);
        assertEquals(expectedAccount, actualResult);
    }

    @Then("^A message That says (.*) should appears$")
    public void aMessageThatSaysProjectNameCanTBeBlankShouldAppears(String expectedMessage) {
        if (ERROR_PROJECT_TITLE_TEXT.equals(expectedMessage)) {
            assertEquals(expectedMessage, projectsStepDef.getCreateProject().getProjectTitleMessage());
        } else if (ERROR_ACCOUNT_MESSAGE_TEXT.equals(expectedMessage)) {
            assertEquals(expectedMessage, projectsStepDef.getCreateProject().getAccountMessage());
        }
        projectsStepDef.getCreateProject().clickCancelCreateProjectBtn();
    }

    @And("^I validate that the created Project is (.*)$")
    public void iValidateThatTheCreatedProjectIsPublic(String expectedProjectType) {
        String actualProjectType = responseProject.jsonPath().get("project_type");
        LOGGER.info("Project Type: " + actualProjectType);
        assertEquals(expectedProjectType, actualProjectType);
    }
}
