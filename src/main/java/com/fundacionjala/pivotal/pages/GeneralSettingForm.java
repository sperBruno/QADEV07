package com.fundacionjala.pivotal.pages;

import java.util.HashMap;
import java.util.Map;

import com.fundacionjala.pivotal.framework.util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.fundacionjala.pivotal.framework.util.CommonMethods.*;
import static com.fundacionjala.pivotal.framework.util.CommonMethods.selectAElementComboBox;
import static com.fundacionjala.pivotal.pages.SettingSteps.*;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class GeneralSettingForm extends BasePage {
    @FindBy(id = "project_name")
    private WebElement projectTitleTestField;

    @FindBy(id = "project_description")
    private WebElement projectDescriptionTestField;

    @FindBy(id = "project_enable_tasks")
    private WebElement projectEnableTasksCheckbox;

    @FindBy(id = "project_api_access")
    private WebElement projectAPIAccessCheckbox;

    @FindBy(id = "project_use_https")
    private WebElement projectUseHttpsCheckBox;

    @FindBy(id = "project_atom_enabled")
    private WebElement projectAtomRssCheckBox;

    @FindBy(id = "project_public")
    private WebElement projectPublicAccessCheckBox;

    @FindBy(id = "project_enable_incoming_emails")
    private WebElement projectEnableIncomingEmailCheckBox;

    @FindBy(id = "project_hide_emails_from_collaborators")
    private WebElement projectHideEmailsFromCollaboratorsCheckBox;

    @FindBy(id = "project_bugs_and_chores_are_estimatable")
    private WebElement projectBugsCheckBox;

    @FindBy(id = "project_week_start_day")
    private WebElement projectWeekStartDaySelect;

    @FindBy(id = "date_project[start_date]")
    private WebElement dateProjectStartTestField;

    @FindBy(id = "project_time_zone")
    private WebElement projectTimeZoneComboBox;

    @FindBy(id = "project_iteration_length")
    private WebElement projectIterationLengthComboBox;

    @FindBy(css = ".project_settings_field.point_scale")
    private WebElement projectSettingsPointScaleComboBox;

    @FindBy(id = "project_initial_velocity")
    private WebElement projectInitialVelocityTestField;

    @FindBy(id = "project_velocity_scheme")
    private WebElement projectVelocityComboBox;

    @FindBy(id = "project_number_of_done_iterations_to_show")
    private WebElement projectNumberOfDoneIterationsToShowTestField;

    @FindBy(id = "project_automatic_planning")
    private WebElement projectAutomaticPlanningCheckBox;

    @FindBy(className = "save_bar__submit")
    private WebElement saveButton;

    @FindBy(id = "delete_link")
    private WebElement deleteLink;

    @FindBy(css = ".message")
    private WebElement testMessage;

    @FindBy(className = "text_column")
    WebElement projectId;

    public Map<SettingSteps, IAutomationStep> getStrategyStepMap(Map<SettingSteps, Object> values) {
        Map<SettingSteps, IAutomationStep> strategyMap = new HashMap<>();
        strategyMap.put(TITLE_PROJECTS, () -> setProjectTitleTestField(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(DESCRIPTION, () -> setProjectDescriptionTestField(values.get(DESCRIPTION).toString()));
        strategyMap.put(PROJECT_START_DATE, () -> setProjectWeekStartDayComboBox(values.get(PROJECT_START_DATE).toString()));
        strategyMap.put(PROJECT_TIME_ZONE, () -> setProjectTimeZoneComboBox(values.get(PROJECT_TIME_ZONE).toString()));
        strategyMap.put(ITERATION_LENGTH, () -> setProjectIterationLengthComboBox(values.get(ITERATION_LENGTH).toString()));
        strategyMap.put(POINT_SCALE, () -> setProjectSettingsPointScaleComboBox(values.get(POINT_SCALE).toString()));
        strategyMap.put(INITIAL_VELOCITY, () -> setProjectInitialVelocityTestField(values.get(INITIAL_VELOCITY).toString()));
        strategyMap.put(VELOCITY_STRATEGY, () -> setProjectVelocityComboBox(values.get(VELOCITY_STRATEGY).toString()));
        strategyMap.put(NUMBER_OF_DONE_ITERATION_SHOW, () -> setProjectNumberOfDoneIterationsToShowTestField(values.get(NUMBER_OF_DONE_ITERATION_SHOW).toString()));
        strategyMap.put(PLAN_CURRENT_ITERATION, () -> setProjectAutomaticPlanningCheckBox(Boolean.parseBoolean(values.get(PLAN_CURRENT_ITERATION).toString())));
        strategyMap.put(ENABLE_TASKS, () -> setProjectEnableTasksCheckbox(Boolean.parseBoolean(values.get(ENABLE_TASKS).toString())));
        strategyMap.put(ALLOW_API_ACCESS, () -> setProjectAPIAccessCheckbox(Boolean.parseBoolean(values.get(ALLOW_API_ACCESS).toString())));
        strategyMap.put(REQUIRE_HTTPS_FOR_API_ACESS, () -> setProjectUseHttpsCheckBox(Boolean.parseBoolean(values.get(REQUIRE_HTTPS_FOR_API_ACESS).toString())));
        strategyMap.put(ENABLE_RSS, () -> setProjectAtomRssCheckBox(Boolean.parseBoolean(values.get(ENABLE_RSS).toString())));
        strategyMap.put(PUBLIC_ACCESS, () -> setProjectPublicAccessCheckBox(Boolean.parseBoolean(values.get(PUBLIC_ACCESS).toString())));
        strategyMap.put(ENABLE_INCOMING_EMAIL, () -> setProjectEnableIncomingEmailCheckBox(Boolean.parseBoolean(values.get(ENABLE_INCOMING_EMAIL).toString())));
        strategyMap.put(HIDE_EMAIL_ADDRESSES, () -> setProjectHideEmailsFromCollaboratorsCheckBox(Boolean.parseBoolean(values.get(HIDE_EMAIL_ADDRESSES).toString())));
        strategyMap.put(BUGSCHORESMAYBEGIVENPOINTS, () -> setProjectBugsCheckBox(Boolean.parseBoolean(values.get(BUGSCHORESMAYBEGIVENPOINTS).toString())));
        return  strategyMap;

    }

    public GeneralSettingForm setProjectTitleTestField(String projectTitle) {
        setWebElement(projectTitleTestField, projectTitle);
        return this;
    }

    public GeneralSettingForm setProjectDescriptionTestField(String projectDescription) {
        setWebElement(projectDescriptionTestField, projectDescription);
        return this;
    }

    public GeneralSettingForm setProjectEnableTasksCheckbox(boolean enable) {
        enableCheckBox(projectEnableTasksCheckbox, enable);
        return this;
    }

    public GeneralSettingForm setProjectWeekStartDayComboBox(String nameDay) {
        selectAElementComboBox(projectWeekStartDaySelect, nameDay);
        return this;
    }

    public GeneralSettingForm setDateProjectStartTestField(String dateProjectStart) {
        setWebElement(dateProjectStartTestField, dateProjectStart);
        return this;
    }

    public GeneralSettingForm setProjectTimeZoneComboBox(String projectTimeZone) {
        selectAElementComboBox(projectTimeZoneComboBox, projectTimeZone);
        return this;
    }

    public GeneralSettingForm setProjectIterationLengthComboBox(String projectIterationLength) {
        selectAElementComboBox(projectIterationLengthComboBox, projectIterationLength);
        return this;
    }

    public GeneralSettingForm setProjectSettingsPointScaleComboBox(String projectSettingsPointScale) {
        selectAElementComboBox(projectSettingsPointScaleComboBox, projectSettingsPointScale);
        return this;
    }

    public GeneralSettingForm setProjectInitialVelocityTestField(String projectInitialVelocity) {
        setWebElement(projectInitialVelocityTestField, projectInitialVelocity);
        return this;
    }

    public GeneralSettingForm setProjectVelocityComboBox(String projectVelocity) {
        selectAElementComboBox(projectVelocityComboBox, projectVelocity);
        return this;
    }

    public GeneralSettingForm setProjectNumberOfDoneIterationsToShowTestField(String projectNumberOfDoneIterationsToShow) {
        setWebElement(projectNumberOfDoneIterationsToShowTestField, projectNumberOfDoneIterationsToShow);
        return this;
    }

    public GeneralSettingForm setProjectAutomaticPlanningCheckBox(boolean projectAutomaticPlanning) {
        enableCheckBox(projectAutomaticPlanningCheckBox, projectAutomaticPlanning);
        return this;
    }

    public GeneralSettingForm clickSaveButton() {
        saveButton.click();
        return this;
    }

    public GeneralSettingForm setProjectAPIAccessCheckbox(boolean enable) {
        enableCheckBox(projectAPIAccessCheckbox, enable);
        return this;
    }

    public GeneralSettingForm setProjectUseHttpsCheckBox(boolean enable) {
        enableCheckBox(projectUseHttpsCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectAtomRssCheckBox(boolean enable) {
        enableCheckBox(projectAtomRssCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectPublicAccessCheckBox(boolean enable) {
        enableCheckBox(projectPublicAccessCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectEnableIncomingEmailCheckBox(boolean enable) {
        enableCheckBox(projectEnableIncomingEmailCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectHideEmailsFromCollaboratorsCheckBox(boolean enable) {
        enableCheckBox(projectHideEmailsFromCollaboratorsCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectBugsCheckBox(boolean enable) {
        enableCheckBox(projectBugsCheckBox, enable);
        return this;
    }

    public void clickLinkDeleteProject() {
        deleteLink.click();
    }

    public String getMessageTest() {
        return testMessage.getText();
    }

    public Select convertASelect(WebElement webElement) {
        return new Select(webElement);
    }

    public GeneralSettingForm selectStartIterationsOn(String nameDay) {
        selectAElementComboBox(projectWeekStartDaySelect, nameDay);
        return this;
    }

    public String getDescriptionText() {
        return projectDescriptionTestField.getAttribute("value");
    }

    public String getProjectId() {
        return projectId.getText();
    }

    public String getProjectTitleTestField() {
        return projectTitleTestField.getAttribute("value");
    }

    public String getNumberIterationShow() {
        return projectNumberOfDoneIterationsToShowTestField.getAttribute("value");
    }
    public String getInitialVelocity() {
        return projectInitialVelocityTestField.getAttribute("value");
    }
    public String getTextProjectWeekStartDaySelect() {
        return convertASelect(projectWeekStartDaySelect).getFirstSelectedOption().getAttribute("value");
    }

    public String getTextProjectIterationLength() {
        return convertASelect(projectIterationLengthComboBox).getFirstSelectedOption().getAttribute("value");
    }

    public boolean getEnableProjectsTasks() {
        return projectEnableTasksCheckbox.isSelected();
    }

    public Map<SettingSteps, Object> getAssertionMap() {
        Map<SettingSteps, Object> assertionMap = new HashMap<>();
        assertionMap.put(TITLE_PROJECTS, getProjectTitleTestField());
        assertionMap.put(DESCRIPTION, getDescriptionText());
        assertionMap.put(PROJECT_START_DATE, getTextProjectWeekStartDaySelect());
        assertionMap.put(ENABLE_TASKS, getEnableProjectsTasks());
        assertionMap.put(ITERATION_LENGTH, getTextProjectIterationLength());
        return assertionMap;
    }
}
