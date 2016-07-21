package org.fundacionjala.pivotal.pages.setting;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.project.DeleteProjectAlert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.convertASelect;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.selectAElementComboBox;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.setCheckBox;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.setWebElement;
import static org.fundacionjala.pivotal.framework.util.Constants.ATTRIBUTE_WEB_ELEMENT;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ALLOW_API_ACCESS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.BUGS_GIVEN_POINTS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.DESCRIPTION;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ENABLE_INCOMING_EMAIL;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ENABLE_RSS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ENABLE_TASKS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.HIDE_EMAIL_ADDRESSES;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.INITIAL_VELOCITY;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ITERATION_LENGTH;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.NUMBER_OF_DONE_ITERATION_SHOW;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.PLAN_CURRENT_ITERATION;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.POINT_SCALE;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.PROJECT_START_DATE;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.PROJECT_TIME_ZONE;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.PUBLIC_ACCESS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.REQUIRE_HTTPS_FOR_API_ACCESS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.START_ITERATIONS_ON;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.TITLE_PROJECTS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.VELOCITY_STRATEGY;


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

    @FindBy(id = "project_account_link")
    private WebElement accountLink;

    @FindBy(css = ".message")
    private WebElement testMessage;

    @FindBy(className = "text_column")
    WebElement projectId;

    @FindBy(className = "error_above_or_below")
    WebElement massageErrorNameDayText;

    private boolean flat;

    public Map<SettingSteps, IAutomationStep> getStrategyStepMap(Map<SettingSteps, Object> values) {
        Map<SettingSteps, IAutomationStep> strategyMap = new HashMap<>();
        strategyMap.put(SettingSteps.TITLE_PROJECTS, () -> setProjectTitleTestField(values.get(TITLE_PROJECTS).toString()));
        strategyMap.put(DESCRIPTION, () -> setProjectDescriptionTestField(values.get(DESCRIPTION).toString()));
        strategyMap.put(START_ITERATIONS_ON, () -> setProjectWeekStartDayComboBox(String.valueOf(values.get(START_ITERATIONS_ON).toString())));
        strategyMap.put(PROJECT_TIME_ZONE, () -> setProjectTimeZoneComboBox(values.get(PROJECT_TIME_ZONE).toString()));
        strategyMap.put(ITERATION_LENGTH, () -> setProjectIterationLengthComboBox(values.get(ITERATION_LENGTH).toString()));
        strategyMap.put(POINT_SCALE, () -> setProjectSettingsPointScaleComboBox(values.get(POINT_SCALE).toString()));
        strategyMap.put(INITIAL_VELOCITY, () -> setProjectInitialVelocityTestField(values.get(INITIAL_VELOCITY).toString()));
        strategyMap.put(VELOCITY_STRATEGY, () -> setProjectVelocityComboBox(values.get(VELOCITY_STRATEGY).toString()));
        strategyMap.put(NUMBER_OF_DONE_ITERATION_SHOW, () -> setProjectNumberOfDoneIterationsToShowTestField(values.get(NUMBER_OF_DONE_ITERATION_SHOW).toString()));
        strategyMap.put(PLAN_CURRENT_ITERATION, () -> setProjectAutomaticPlanningCheckBox(Boolean.parseBoolean(values.get(PLAN_CURRENT_ITERATION).toString())));
        strategyMap.put(ENABLE_TASKS, () -> setProjectEnableTasksCheckbox(Boolean.parseBoolean(values.get(ENABLE_TASKS).toString())));
        strategyMap.put(ALLOW_API_ACCESS, () -> setProjectAPIAccessCheckbox(Boolean.parseBoolean(values.get(ALLOW_API_ACCESS).toString())));
        strategyMap.put(REQUIRE_HTTPS_FOR_API_ACCESS, () -> setProjectUseHttpsCheckBox(Boolean.parseBoolean(values.get(REQUIRE_HTTPS_FOR_API_ACCESS).toString())));
        strategyMap.put(ENABLE_RSS, () -> setProjectAtomRssCheckBox(Boolean.parseBoolean(values.get(ENABLE_RSS).toString())));
        strategyMap.put(PUBLIC_ACCESS, () -> setProjectPublicAccessCheckBox(Boolean.parseBoolean(values.get(PUBLIC_ACCESS).toString())));
        strategyMap.put(ENABLE_INCOMING_EMAIL, () -> setProjectEnableIncomingEmailCheckBox(Boolean.parseBoolean(values.get(ENABLE_INCOMING_EMAIL).toString())));
        strategyMap.put(HIDE_EMAIL_ADDRESSES, () -> setProjectHideEmailsFromCollaboratorsCheckBox(Boolean.parseBoolean(values.get(HIDE_EMAIL_ADDRESSES).toString())));
        strategyMap.put(BUGS_GIVEN_POINTS, () -> setProjectBugsCheckBox(Boolean.parseBoolean(values.get(BUGS_GIVEN_POINTS).toString())));
        strategyMap.put(PROJECT_START_DATE, () -> setDateProjectStartTestField(String.valueOf(values.get(PROJECT_START_DATE).toString())));
        return strategyMap;

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
        setCheckBox(projectEnableTasksCheckbox, enable);
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
        flat = true;
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
        setCheckBox(projectAutomaticPlanningCheckBox, projectAutomaticPlanning);
        return this;
    }

    public GeneralSettingForm clickSaveButton() {
        clickWebElement(saveButton);
        if (flat) {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
            flat = false;
        }

        return this;
    }

    public GeneralSettingForm setProjectAPIAccessCheckbox(boolean enable) {
        setCheckBox(projectAPIAccessCheckbox, enable);
        return this;
    }

    public GeneralSettingForm setProjectUseHttpsCheckBox(boolean enable) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,500)");
        action.keyDown(Keys.DOWN).perform();
        setCheckBox(projectUseHttpsCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectAtomRssCheckBox(boolean enable) {
        setCheckBox(projectAtomRssCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectPublicAccessCheckBox(boolean enable) {
        setCheckBox(projectPublicAccessCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectEnableIncomingEmailCheckBox(boolean enable) {
        setCheckBox(projectEnableIncomingEmailCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectHideEmailsFromCollaboratorsCheckBox(boolean enable) {
        setCheckBox(projectHideEmailsFromCollaboratorsCheckBox, enable);
        return this;
    }

    public GeneralSettingForm setProjectBugsCheckBox(boolean enable) {
        setCheckBox(projectBugsCheckBox, enable);
        return this;
    }

    public DeleteProjectAlert clickLinkDeleteProject() {
        clickWebElement(deleteLink);
        return new DeleteProjectAlert();
    }

    public String getMessageTest() {
        return testMessage.getText();
    }

    public String getMessageErrorNameDayText() {
        return massageErrorNameDayText.getText();
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
        return convertASelect(projectWeekStartDaySelect).getFirstSelectedOption().getAttribute(ATTRIBUTE_WEB_ELEMENT);
    }

    public String getTextDateProjectStart() {
        return dateProjectStartTestField.getAttribute(ATTRIBUTE_WEB_ELEMENT);
    }

    public String getTextProjectTimeZone() {
        return convertASelect(projectTimeZoneComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_WEB_ELEMENT);
    }

    public Accounts clickAccountLink() {
        accountLink.click();
        return new Accounts();
    }

    public String getTextProjectIterationLength() {
        return convertASelect(projectIterationLengthComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_WEB_ELEMENT);
    }

    public String getTextProjectSettingPointScale() {
        return convertASelect(projectSettingsPointScaleComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_WEB_ELEMENT);
    }

    public String getTextProjectVelocity() {
        return convertASelect(projectVelocityComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_WEB_ELEMENT);
    }

    public boolean getTextProjectAutomaticPlanning() {
        return projectAutomaticPlanningCheckBox.isSelected();
    }

    public boolean getAllowAPIACCES() {
        return projectAPIAccessCheckbox.isSelected();
    }

    public boolean getUseHttps() {
        return projectUseHttpsCheckBox.isSelected();
    }

    public boolean getAtomRss() {
        return projectAtomRssCheckBox.isSelected();
    }

    public boolean getPublicAccess() {
        return projectPublicAccessCheckBox.isSelected();
    }

    public boolean getEnableIncomingEmailCheckBox() {
        return projectEnableIncomingEmailCheckBox.isSelected();
    }

    public boolean getHideEmailsFromCollaboratorsCheckBox() {
        return projectHideEmailsFromCollaboratorsCheckBox.isSelected();
    }

    public boolean getBugGivenPointsCheckBox() {
        return projectBugsCheckBox.isSelected();
    }

    public boolean getEnableProjectsTasks() {
        return projectEnableTasksCheckbox.isSelected();
    }

    public Map<SettingSteps, Object> getAssertionMap() {
        Map<SettingSteps, Object> assertionMap = new HashMap<>();
        assertionMap.put(TITLE_PROJECTS, getProjectTitleTestField());
        assertionMap.put(DESCRIPTION, getDescriptionText());
        assertionMap.put(ENABLE_TASKS, getEnableProjectsTasks());
        assertionMap.put(START_ITERATIONS_ON, getTextProjectWeekStartDaySelect());
        assertionMap.put(PROJECT_START_DATE, getTextDateProjectStart());
        assertionMap.put(PROJECT_TIME_ZONE, getTextProjectTimeZone());
        assertionMap.put(ITERATION_LENGTH, getTextProjectIterationLength());
        assertionMap.put(POINT_SCALE, getTextProjectSettingPointScale());
        assertionMap.put(INITIAL_VELOCITY, getInitialVelocity());
        assertionMap.put(VELOCITY_STRATEGY, getTextProjectVelocity());
        assertionMap.put(NUMBER_OF_DONE_ITERATION_SHOW, getNumberIterationShow());
        assertionMap.put(PLAN_CURRENT_ITERATION, getTextProjectAutomaticPlanning());
        assertionMap.put(ALLOW_API_ACCESS, getAllowAPIACCES());
        assertionMap.put(REQUIRE_HTTPS_FOR_API_ACCESS, getUseHttps());
        assertionMap.put(ENABLE_RSS, getAtomRss());
        assertionMap.put(PUBLIC_ACCESS, getPublicAccess());
        assertionMap.put(ENABLE_INCOMING_EMAIL, getEnableIncomingEmailCheckBox());
        assertionMap.put(HIDE_EMAIL_ADDRESSES, getHideEmailsFromCollaboratorsCheckBox());
        assertionMap.put(BUGS_GIVEN_POINTS, getBugGivenPointsCheckBox());
        return assertionMap;
    }
}
