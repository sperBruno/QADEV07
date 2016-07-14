package com.fundacionjala.pivotal.pages;

import com.fundacionjala.pivotal.framework.util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.fundacionjala.pivotal.framework.util.CommonMethods.*;
import static com.fundacionjala.pivotal.framework.util.CommonMethods.selectAElementComboBox;

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
}
