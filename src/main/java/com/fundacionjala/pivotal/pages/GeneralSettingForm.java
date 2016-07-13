package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class GeneralSettingForm <T extends GeneralSettingForm<T>> extends BasePage{
    @FindBy(id= "project_name")
    protected WebElement projectTitleTestField;

    @FindBy(id= "project_description")
    protected WebElement projectDescriptionTestField;

    @FindBy(id= "project_enable_tasks")
    private WebElement projectEnableTasksCheckbox;

    @FindBy(id= "project_week_start_day")
    private WebElement projectWeekStartDaySelect;

    @FindBy(id= "date_project[start_date]")
    private WebElement dateProjectStartTestField;

    @FindBy(id= "project_time_zone")
    private WebElement projectTimeZoneTestField;

    @FindBy(id= "project_iteration_length")
    private WebElement projectIterationLengthComboBox;

    @FindBy(id= "project_settings_field point_scale")
    private WebElement projectSettingsPointScaleComboBox;

    @FindBy(id= "project_initial_velocity")
    private WebElement projectInitialVelocityTestField;

    @FindBy(id= "project_velocity_scheme")
    private WebElement projectVelocityComboBox;

    @FindBy(id= "project_number_of_done_iterations_to_show")
    private WebElement projectNumberOfDoneIterationsToShowTestField;

    @FindBy(id= "project_automatic_planning")
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
       // if (projectEnableTasksCheckbox.isSelected()) {
            projectEnableTasksCheckbox.click();
    //    }
        return getThis();
    }

    private T clickProjectWeekStartDayComboBox() {
       // projectWeekStartDaySelect.click();
        return getThis();
    }

    public T setDateProjectStartTestField(String dateProjectStart) {
        dateProjectStartTestField.clear();
        dateProjectStartTestField.sendKeys(dateProjectStart);
        return getThis();
    }

    public T setProjectTimeZoneTestField(String projectTimeZone) {
        projectTimeZoneTestField.clear();
        projectTimeZoneTestField.sendKeys(projectTimeZone);
        return getThis();
    }

    public T setProjectIterationLengthComboBox(String projectIterationLength) {
        projectIterationLengthComboBox.clear();
        projectIterationLengthComboBox.sendKeys(projectIterationLength);
        return getThis();
    }

    public T setProjectSettingsPointScaleComboBox(String projectSettingsPointScale) {
        projectSettingsPointScaleComboBox.clear();
        projectSettingsPointScaleComboBox.sendKeys(projectSettingsPointScale);
        return getThis();
    }

    public T setProjectInitialVelocityTestField(String projectInitialVelocity) {
        projectInitialVelocityTestField.clear();
        projectInitialVelocityTestField.sendKeys(projectInitialVelocity);
        return getThis();
    }

    public T setProjectVelocityComboBox(String projectVelocityComboBox) {
       // projectVelocityComboBox.clear();
        //projectVelocityComboBox.sendKeys(projectVelocityComboBox);
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

    public void clickLinkDeleteProject() {
        deleteLink.click();
    }
    public String getMessageTest() {
        return testMessage.getText();
    }

    public T selectStartIterationsOn(String nameDay){
        Select oSelect = new Select(projectWeekStartDaySelect);
        oSelect.selectByValue(nameDay);
        return getThis();
    }

    protected T getThis() {
        return (T) this;
    }

}
