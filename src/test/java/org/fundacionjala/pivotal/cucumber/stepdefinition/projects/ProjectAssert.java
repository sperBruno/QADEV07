package org.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import com.jayway.restassured.response.Response;

import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.pages.setting.Setting;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

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

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    private String endpointProject;

    private Response responseProject;

    private Setting setting;


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

    @Then("^I expect the delete message: (.*)$")
    public void iExpectTheDeleteMessageProjectNameWasSuccessfullyDeleted(String message) {
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
        setting = projectsStepDef.getProject().clickSettingTab();
        endpointProject = PROJECTS_ENDPOINT + setting.getSideBar().clickGeneralSetting().getProjectId();
        responseProject = getRequest(endpointProject);
        assertEquals(expectedValue, projectsStepDef.getProject().getTitle().replace("\n", " "));
    }

    @And("^Validate all setting projects$")
    public void validateAllSettingProjects() {
        projectSettingsStepDef.getValuesMap().keySet().stream().forEach(step -> assertEquals(String.valueOf(projectSettingsStepDef.getGeneralSettingForm().getAssertionMap().get(step)), projectSettingsStepDef.getValuesMap().get(step)));
        projectSettingsStepDef.getSetting().getToolBar().clickReturnDashboardLink();
    }

    @And("^I verify that the account of the created project is (.*)$")
    public void iVerifyThatTheAccountOfTheCreatedProjectIsLuis(String expectedAccount) {
        final String accountIdFieldName = "account_id";
        String accountId = responseProject.jsonPath().get(accountIdFieldName).toString();
        String endpointAccount = "/accounts/" + accountId;
        Response responseAccount = getRequest(endpointAccount);
        final String nameAccount = "name";
        String actualResult = responseAccount.jsonPath().get(nameAccount);
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
        final String projectType = "project_type";
        String actualProjectType = responseProject.jsonPath().get(projectType);
        assertEquals(expectedProjectType, actualProjectType);
    }

    @Then("^I click save button should be show a message say: (.*)$")
    public void iClickSaveButtonShouldBeShowAMessageSay(String message) {
        final String expectResult = projectSettingsStepDef.getGeneralSettingForm().getMassage(message, projectSettingsStepDef.getValuesMap());
        assertEquals(expectResult, projectSettingsStepDef.getGeneralSettingForm().getMessageErrorNameDayText());
    }
}
