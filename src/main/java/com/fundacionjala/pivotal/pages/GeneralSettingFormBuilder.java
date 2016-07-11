package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public static class GeneralSettingFormBuilder {
    @FindBy(id= "project_name")
    protected String projectTitleTestField;

    @FindBy(id= "project_description")
    protected String projectDescriptionTestField;

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


    public GeneralSettingFormBuilder(String projectTitleTestField) {
        this.projectTitleTestField = projectTitleTestField;
    }

    public GeneralSettingFormBuilder projectDescriptionTestField(String description) {
        this.projectDescriptionTestField = description;
        return this;
    }

    public ContainerSetting build() {
        return new ContainerSetting(this);
    }
}
