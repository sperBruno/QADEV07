package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ContainerSetting {

    @FindBy(id= "project_name")
    private String projectTitleTestField;

    @FindBy(id= "project_description")
    private String projectDescriptionTestField;

    @FindBy(id= "project_enable_tasks")
    private String projectEnableTasksCheckbox;

    @FindBy(id= "project_week_start_day")
    private String projectWeekStartDayComboBox;

    @FindBy(id= "date_project[start_date]")
    private String dateProjectStartTestField;

    @FindBy(id= "project_time_zone")
    private String projectTimeZoneTestField;

    @FindBy(id= "project_iteration_length")
    private String projectIterationLengthComboBox;

    @FindBy(id= "project_settings_field point_scale")
    private String projectSettingsPointScaleComboBox;

    @FindBy(id= "project_initial_velocity")
    private String projectInitialVelocityTestField;

    @FindBy(id= "project_velocity_scheme")
    private String projectVelocityComboBox;

    @FindBy(id= "project_number_of_done_iterations_to_show")
    private String projectNumberOfDoneIterationsToShowTestField;

    @FindBy(id= "project_automatic_planning")
    private String projectAutomaticPlanningCheckBox;

    @FindBy(id= "delete_link")
    private String linkDeleteButton;

    public ContainerSetting(GeneralSettingFormBuilder generalSettingFormBuilder) {
        this.projectTitleTestField = generalSettingFormBuilder.projectTitleTestField;
        this.projectDescriptionTestField = generalSettingFormBuilder.projectDescriptionTestField;
//        this.projectEnableTasksCheckbox = generalSettingFormBuilder.projectEnableTasksCheckbox;
//        this.projectWeekStartDayComboBox = generalSettingFormBuilder.projectWeekStartDayComboBox;
//        this.dateProjectStartTestField = generalSettingFormBuilder.dateProjectStartTestField;
//        this.projectTimeZoneTestField = generalSettingFormBuilder.projectTimeZoneTestField;
//        this.projectIterationLengthComboBox = generalSettingFormBuilder.projectIterationLengthComboBox;
//        this.projectSettingsPointScaleComboBox = generalSettingFormBuilder.projectSettingsPointScaleComboBox;
//        this.projectInitialVelocityTestField = generalSettingFormBuilder.projectInitialVelocityTestField;
//        this.projectVelocityComboBox = generalSettingFormBuilder.projectVelocityComboBox;
//        this.projectNumberOfDoneIterationsToShowTestField = generalSettingFormBuilder.projectNumberOfDoneIterationsToShowTestField;
//        this.projectAutomaticPlanningCheckBox = generalSettingFormBuilder.projectAutomaticPlanningCheckBox;
    }
}
