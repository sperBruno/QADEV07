package com.fundacionjala.pivotal.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class GeneralSettingForm extends BasePage{
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

    public void setProjectTitleTestField(String projectTitle) {
        projectTitleTestField.clear();
        projectTitleTestField.sendKeys(projectTitle);
    }

    public void setProjectDescriptionTestField(String projectDescription) {
        projectDescriptionTestField.clear();
        projectDescriptionTestField.sendKeys(projectDescription);
    }

    public void setProjectEnableTasksCheckbox(String projectEnableTasks) {
        projectEnableTasksCheckbox.clear();
        projectEnableTasksCheckbox.sendKeys(projectEnableTasks);
    }

    private void clickProjectWeekStartDayComboBox() {
       // projectWeekStartDaySelect.click();
    }

    public void setDateProjectStartTestField(String dateProjectStart) {
        dateProjectStartTestField.clear();
        dateProjectStartTestField.sendKeys(dateProjectStart);
    }

    public void setProjectTimeZoneTestField(String projectTimeZone) {
        projectTimeZoneTestField.clear();
        projectTimeZoneTestField.sendKeys(projectTimeZone);
    }

    public void setProjectIterationLengthComboBox(String projectIterationLength) {
        projectIterationLengthComboBox.clear();
        projectIterationLengthComboBox.sendKeys(projectIterationLength);
    }

    public void setProjectSettingsPointScaleComboBox(String projectSettingsPointScale) {
        projectSettingsPointScaleComboBox.clear();
        projectSettingsPointScaleComboBox.sendKeys(projectSettingsPointScale);
    }

    public void setProjectInitialVelocityTestField(String projectInitialVelocity) {
        projectInitialVelocityTestField.clear();
        projectInitialVelocityTestField.sendKeys(projectInitialVelocity);
    }

    public void setProjectVelocityComboBox(String projectVelocityComboBox) {
       // projectVelocityComboBox.clear();
        //projectVelocityComboBox.sendKeys(projectVelocityComboBox);
    }

    public void setProjectNumberOfDoneIterationsToShowTestField(String projectNumberOfDoneIterationsToShow) {
        projectNumberOfDoneIterationsToShowTestField.clear();
        projectNumberOfDoneIterationsToShowTestField.sendKeys(projectNumberOfDoneIterationsToShow);
    }

    public void setProjectAutomaticPlanningCheckBox(String projectAutomaticPlanning) {
        projectAutomaticPlanningCheckBox.clear();
        projectAutomaticPlanningCheckBox.sendKeys(projectAutomaticPlanning);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickLinkDeleteProject() {
        deleteLink.click();
    }
    public String getMessageTest() {
        return testMessage.getText();
    }

    public void selectStartIterationsOn(String nameDay){
        Select oSelect = new Select(projectWeekStartDaySelect);
        List<WebElement> oSize = oSelect.getOptions();
        System.out.print("sadas"+ oSize.size());
        oSelect.selectByValue("Sunday");
       // projectWeekStartDaySelect.selectByValue(nameDay);//projectWeekStartDaySelect.findElement(By.xpath("//option[@value='"+nameDay+"']")).click();
//        //Another implementation using xpath
//        driver.findElement(By.xpath("//div[@class='AmiMenu priority_menu']/descendant::img[@class='cmp_priority" + priority + "']")).click();
    }

}
