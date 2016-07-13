package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class GeneralSettingForm<T extends GeneralSettingForm<T>> extends BasePage {
    @FindBy(id = "project_name")
    protected WebElement projectTitleTestField;

    @FindBy(id = "project_description")
    protected WebElement projectDescriptionTestField;

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

    public T setProjectTitleTestField(String projectTitle) {
        projectTitleTestField.clear();
        projectTitleTestField.sendKeys(projectTitle);
        return getThis();
    }

    public T setProjectDescriptionTestField(String projectDescription) {
        projectDescriptionTestField.clear();
        projectDescriptionTestField.sendKeys(projectDescription);
        return getThis();
    }

    public T setProjectEnableTasksCheckbox(boolean enable) {
        enableCheckBox(projectEnableTasksCheckbox, enable);
        return getThis();
    }

    public T setProjectWeekStartDayComboBox(String nameDay) {
        selectAElementComboBox(projectWeekStartDaySelect, nameDay);
        return getThis();
    }

    public T setDateProjectStartTestField(String dateProjectStart) {
        dateProjectStartTestField.clear();
        dateProjectStartTestField.sendKeys(dateProjectStart);
        return getThis();
    }

    public T setProjectTimeZoneComboBox(String projectTimeZone) {
        selectAElementComboBox(projectTimeZoneComboBox, projectTimeZone);
        return getThis();
    }

    public T setProjectIterationLengthComboBox(String projectIterationLength) {
        selectAElementComboBox(projectIterationLengthComboBox, projectIterationLength);
        return getThis();
    }

    public T setProjectSettingsPointScaleComboBox(String projectSettingsPointScale) {
        selectAElementComboBox(projectSettingsPointScaleComboBox, projectSettingsPointScale);
        return getThis();
    }

    public T setProjectInitialVelocityTestField(String projectInitialVelocity) {
        projectInitialVelocityTestField.clear();
        projectInitialVelocityTestField.sendKeys(projectInitialVelocity);
        return getThis();
    }

    public T setProjectVelocityComboBox(String projectVelocity) {
        selectAElementComboBox(projectVelocityComboBox, projectVelocity);
        return getThis();
    }

    public T setProjectNumberOfDoneIterationsToShowTestField(String projectNumberOfDoneIterationsToShow) {
        projectNumberOfDoneIterationsToShowTestField.clear();
        projectNumberOfDoneIterationsToShowTestField.sendKeys(projectNumberOfDoneIterationsToShow);
        return getThis();
    }

    public T setProjectAutomaticPlanningCheckBox(String projectAutomaticPlanning) {
        projectAutomaticPlanningCheckBox.clear();
        projectAutomaticPlanningCheckBox.sendKeys(projectAutomaticPlanning);
        return getThis();
    }

    public T clickSaveButton() {
        saveButton.click();
        return getThis();
    }

    public T setProjectAPIAccessCheckbox(boolean enable) {
        enableCheckBox(projectAPIAccessCheckbox, enable);
        return getThis();
    }

    public T setProjectUseHttpsCheckBox(boolean enable) {
        enableCheckBox(projectUseHttpsCheckBox, enable);
        return getThis();
    }

    public T setProjectAtomRssCheckBox(boolean enable) {
        enableCheckBox(projectAtomRssCheckBox, enable);
        return getThis();
    }

    public T setProjectPublicAccessCheckBox(boolean enable) {
        enableCheckBox(projectPublicAccessCheckBox, enable);
        return getThis();
    }

    public T setProjectEnableIncomingEmailCheckBox(boolean enable) {
        enableCheckBox(projectEnableIncomingEmailCheckBox, enable);
        return getThis();
    }

    public T setProjectHideEmailsFromCollaboratorsCheckBox(boolean enable) {
        enableCheckBox(projectHideEmailsFromCollaboratorsCheckBox, enable);
        return getThis();
    }

    public T setProjectBugsCheckBox(boolean enable) {
        enableCheckBox(projectBugsCheckBox, enable);
        return getThis();
    }

    public void clickLinkDeleteProject() {
        deleteLink.click();
    }

    public String getMessageTest() {
        return testMessage.getText();
    }

    public T selectStartIterationsOn(String nameDay) {
        selectAElementComboBox(projectWeekStartDaySelect, nameDay);
        return getThis();
    }

    public void enableCheckBox(WebElement webElement, boolean enable) {
        if (enable) {
            if (!webElement.isSelected()) {
                webElement.click();
            }
        } else {
            if (webElement.isSelected()) {
                webElement.click();
            }
        }
    }

    public void selectAElementComboBox(WebElement webElementSelect, String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }


    public String getDescriptionText() {
        return projectDescriptionTestField.getText();
    }

    protected T getThis() {
        return (T) this;
    }

}
