package org.fundacionjala.pivotal.pages.setting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.BasePage;
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
import static org.fundacionjala.pivotal.framework.util.Constants.ATTRIBUTE_VALUE;
import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_BRACKETS;
import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_HALF_BRACKET;
import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_INSIDE_BRACKETS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ALLOW_API_ACCESS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.BUGS_GIVEN_POINTS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.DATE_NAME;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.DESCRIPTION;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ENABLE_INCOMING_EMAIL;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ENABLE_RSS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ENABLE_TASKS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.HIDE_EMAIL_ADDRESSES;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.INITIAL_VELOCITY;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.ITERATION_LENGTH;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.DONE_ITERATION_SHOW;
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

    private static final Logger LOGGER = Logger.getLogger(GeneralSettingForm.class.getName());

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
    private WebElement projectId;

    @FindBy(className = "error_above_or_below")
    private WebElement massageErrorNameDayText;

    private boolean flat;

    private static final String REGEX_BLACK_SPACE = " ";

    /**
     * This method will be used to create a Project at once.
     *
     * @param values required to create a project
     * @return Map of executed steps.
     */
    public Map<SettingSteps, IAutomationStep> getStrategyStepMap(Map<SettingSteps, Object> values) {
        Map<SettingSteps, IAutomationStep> strategyMap = new EnumMap<>(SettingSteps.class);
        strategyMap.put(SettingSteps.TITLE_PROJECTS, () -> {
            String projectTitle = values.get(TITLE_PROJECTS).toString();
            setProjectTitleTestField(projectTitle);
        });
        strategyMap.put(DESCRIPTION, () -> {
            String projectDescription = values.get(DESCRIPTION).toString();
            setProjectDescriptionTestField(projectDescription);
        });
        strategyMap.put(START_ITERATIONS_ON, () -> {
            String nameDay = String.valueOf(values.get(START_ITERATIONS_ON).toString());
            setProjectWeekStartDayComboBox(nameDay);
        });
        strategyMap.put(PROJECT_TIME_ZONE, () -> setProjectTimeZoneComboBox(values.get(PROJECT_TIME_ZONE).toString()));
        strategyMap.put(ITERATION_LENGTH, () -> {
            String projectIterationLength = values.get(ITERATION_LENGTH).toString();
            setProjectIterationLengthComboBox(projectIterationLength);
        });
        strategyMap.put(POINT_SCALE, () -> setProjectSettingsPointScaleComboBox(values.get(POINT_SCALE).toString()));
        strategyMap.put(INITIAL_VELOCITY, () -> {
            String projectInitialVelocity = values.get(INITIAL_VELOCITY).toString();
            setProjectInitialVelocityTestField(projectInitialVelocity);
        });
        strategyMap.put(VELOCITY_STRATEGY, () -> setProjectVelocityComboBox(values.get(VELOCITY_STRATEGY).toString()));
        strategyMap.put(DONE_ITERATION_SHOW, () -> {
            String numberOfDoneIterationsToShow = values.get(DONE_ITERATION_SHOW).toString();
            setProjectNumberOfDoneIterationsToShowTestField(numberOfDoneIterationsToShow);
        });
        strategyMap.put(PLAN_CURRENT_ITERATION, () -> {
            boolean projectAutomaticPlanning = Boolean.parseBoolean(values.get(PLAN_CURRENT_ITERATION).toString());
            setProjectAutomaticPlanningCheckBox(projectAutomaticPlanning);
        });
        strategyMap.put(ENABLE_TASKS, () -> {
            boolean enableTasks = Boolean.parseBoolean(values.get(ENABLE_TASKS).toString());
            setProjectEnableTasksCheckbox(enableTasks);
        });
        strategyMap.put(ALLOW_API_ACCESS, () -> {
            boolean enableApiAccess = Boolean.parseBoolean(values.get(ALLOW_API_ACCESS).toString());
            setProjectAPIAccessCheckbox(enableApiAccess);
        });
        strategyMap.put(REQUIRE_HTTPS_FOR_API_ACCESS, () -> {
            boolean enablehttps = Boolean.parseBoolean(values.get(REQUIRE_HTTPS_FOR_API_ACCESS).toString());
            setProjectUseHttpsCheckBox(enablehttps);
        });
        strategyMap.put(ENABLE_RSS, () -> {
            boolean enableRss = Boolean.parseBoolean(values.get(ENABLE_RSS).toString());
            setProjectAtomRssCheckBox(enableRss);
        });
        strategyMap.put(PUBLIC_ACCESS, () -> {
            boolean enablePublicAccess = Boolean.parseBoolean(values.get(PUBLIC_ACCESS).toString());
            setProjectPublicAccessCheckBox(enablePublicAccess);
        });
        strategyMap.put(ENABLE_INCOMING_EMAIL, () -> {
            boolean enableIncomingEmail = Boolean.parseBoolean(values.get(ENABLE_INCOMING_EMAIL).toString());
            setProjectEnableIncomingEmailCheckBox(enableIncomingEmail);
        });
        strategyMap.put(HIDE_EMAIL_ADDRESSES, () -> {
            boolean enableCollaborators = Boolean.parseBoolean(values.get(HIDE_EMAIL_ADDRESSES).toString());
            setProjectHideEmailsFromCollaboratorsCheckBox(enableCollaborators);
        });
        strategyMap.put(BUGS_GIVEN_POINTS, () -> {
            boolean enableBugPoints = Boolean.parseBoolean(values.get(BUGS_GIVEN_POINTS).toString());
            setProjectBugsCheckBox(enableBugPoints);
        });
        strategyMap.put(PROJECT_START_DATE, () -> {
            String dateProjectStart = String.valueOf(values.get(PROJECT_START_DATE).toString());
            setDateProjectStartTestField(dateProjectStart);
        });
        return strategyMap;
    }

    /**
     * This method will set project title.
     *
     * @param projectTitle to be set.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectTitleTestField(String projectTitle) {
        setWebElement(projectTitleTestField, projectTitle);
        return this;
    }

    /**
     * This method will set project description.
     *
     * @param projectDescription to be set.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectDescriptionTestField(String projectDescription) {
        setWebElement(projectDescriptionTestField, projectDescription);
        return this;
    }

    /**
     * This method will enable Tasks.
     *
     * @param enable tasks state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectEnableTasksCheckbox(boolean enable) {
        setCheckBox(projectEnableTasksCheckbox, enable);
        return this;
    }

    /**
     * This method will set week start day.
     *
     * @param nameDay start day.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectWeekStartDayComboBox(String nameDay) {
        selectAElementComboBox(projectWeekStartDaySelect, nameDay);
        return this;
    }

    /**
     * This method will set Date start test.
     *
     * @param dateProjectStart state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setDateProjectStartTestField(String dateProjectStart) {
        setWebElement(dateProjectStartTestField, dateProjectStart);
        return this;
    }

    /**
     * This method will set TimeZone.
     *
     * @param projectTimeZone state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectTimeZoneComboBox(String projectTimeZone) {
        selectAElementComboBox(projectTimeZoneComboBox, projectTimeZone);
        return this;
    }

    /**
     * This method will set iterations length.
     *
     * @param projectIterationLength state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectIterationLengthComboBox(String projectIterationLength) {
        selectAElementComboBox(projectIterationLengthComboBox, projectIterationLength);
        return this;
    }

    /**
     * This method will set point scale.
     *
     * @param projectSettingsPointScale state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectSettingsPointScaleComboBox(String projectSettingsPointScale) {
        selectAElementComboBox(projectSettingsPointScaleComboBox, projectSettingsPointScale);
        flat = true;
        return this;
    }

    /**
     * This method will set initial velocity.
     *
     * @param projectInitialVelocity state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectInitialVelocityTestField(String projectInitialVelocity) {
        setWebElement(projectInitialVelocityTestField, projectInitialVelocity);
        return this;
    }

    /**
     * This method will set velocity project.
     *
     * @param projectVelocity state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectVelocityComboBox(String projectVelocity) {
        selectAElementComboBox(projectVelocityComboBox, projectVelocity);
        return this;
    }

    /**
     * This method will number of done iterations.
     *
     * @param numberOfDoneIterationsToShow name of project
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectNumberOfDoneIterationsToShowTestField(String numberOfDoneIterationsToShow) {
        setWebElement(projectNumberOfDoneIterationsToShowTestField, numberOfDoneIterationsToShow);
        return this;
    }

    /**
     * This method will be set enable automatic planning checkbox.
     *
     * @param projectAutomaticPlanning state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectAutomaticPlanningCheckBox(boolean projectAutomaticPlanning) {
        setCheckBox(projectAutomaticPlanningCheckBox, projectAutomaticPlanning);
        return this;
    }

    /**
     * This method will click on save button.
     *
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm clickSaveButton() {
        clickWebElement(saveButton);
        if (flat) {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
            flat = false;
        }

        return this;
    }

    /**
     * This method will be set enable api access checkbox.
     *
     * @param enable api access state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectAPIAccessCheckbox(boolean enable) {
        setCheckBox(projectAPIAccessCheckbox, enable);
        return this;
    }

    /**
     * This method will be set enable user https checkbox.
     *
     * @param enable user https state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectUseHttpsCheckBox(boolean enable) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,500)");
        action.keyDown(Keys.DOWN).perform();
        setCheckBox(projectUseHttpsCheckBox, enable);
        return this;
    }

    /**
     * This method will be set enable atom Rss checkbox.
     *
     * @param enable atom rss state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectAtomRssCheckBox(boolean enable) {
        setCheckBox(projectAtomRssCheckBox, enable);
        return this;
    }

    /**
     * This method will be set enable public access checkbox.
     *
     * @param enable public access state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectPublicAccessCheckBox(boolean enable) {
        setCheckBox(projectPublicAccessCheckBox, enable);
        return this;
    }

    /**
     * This method will be set enable incoming email checkbox.
     *
     * @param enable incoming email state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectEnableIncomingEmailCheckBox(boolean enable) {
        setCheckBox(projectEnableIncomingEmailCheckBox, enable);
        return this;
    }

    /**
     * This method will set hiden emails.
     *
     * @param enable state.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectHideEmailsFromCollaboratorsCheckBox(boolean enable) {
        setCheckBox(projectHideEmailsFromCollaboratorsCheckBox, enable);
        return this;
    }

    /**
     * This method will be used to set bug  checkbox.
     *
     * @param enable state of bug.
     * @return GeneralSettingForm.
     */
    public GeneralSettingForm setProjectBugsCheckBox(boolean enable) {
        setCheckBox(projectBugsCheckBox, enable);
        return this;
    }

    /**
     * This method will delete project alert.
     *
     * @return the alert.
     */
    public DeleteProjectAlert clickLinkDeleteProject() {
        clickWebElement(deleteLink);
        return new DeleteProjectAlert();
    }

    /**
     * This method will be used to get message.
     *
     * @return Message text.
     */
    public String getMessageTest() {
        return testMessage.getText();
    }

    /**
     * This method will get error message relate to Name Day text.
     *
     * @return the error message.
     */
    public String getMessageErrorNameDayText() {
        return massageErrorNameDayText.getText();
    }

    /**
     * This method will get the description.
     *
     * @return description.
     */
    public String getDescriptionText() {
        return projectDescriptionTestField.getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get the project id.
     *
     * @return project id.
     */
    public String getProjectId() {
        return projectId.getText();
    }

    /**
     * This method will project title.
     *
     * @return project title.
     */
    public String getProjectTitleTestField() {
        return projectTitleTestField.getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get the number of iterations.
     *
     * @return the number of iterations.
     */
    public String getNumberIterationShow() {
        return projectNumberOfDoneIterationsToShowTestField.getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get initial velocity.
     *
     * @return velocity.
     */
    public String getInitialVelocity() {
        return projectInitialVelocityTestField.getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get week start day.
     *
     * @return start day.
     */
    public String getTextProjectWeekStartDaySelect() {
        return convertASelect(projectWeekStartDaySelect).getFirstSelectedOption().getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get Data project start.
     *
     * @return date project start.
     */
    public String getTextDateProjectStart() {
        return dateProjectStartTestField.getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get the time zone.
     *
     * @return time zone.
     */
    public String getTextProjectTimeZone() {
        return convertASelect(projectTimeZoneComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will on account link.
     *
     * @return Account.
     */
    public Accounts clickAccountLink() {
        accountLink.click();
        return new Accounts();
    }

    /**
     * This method will get interation lenght.
     *
     * @return thjis method will get iteration length.
     */
    public String getTextProjectIterationLength() {
        return convertASelect(projectIterationLengthComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get point scale text.
     *
     * @return point scale text.
     */
    public String getTextProjectSettingPointScale() {
        return convertASelect(projectSettingsPointScaleComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will get project velocity text.
     *
     * @return project velocity text.
     */
    public String getTextProjectVelocity() {
        return convertASelect(projectVelocityComboBox).getFirstSelectedOption().getAttribute(ATTRIBUTE_VALUE);
    }

    /**
     * This method will verify if project automatic plannig is selected.
     *
     * @return true if so and false if not.
     */
    public boolean getTextProjectAutomaticPlanning() {
        return projectAutomaticPlanningCheckBox.isSelected();
    }

    /**
     * This method will verify if allow api access is selected.
     *
     * @return true if so and false if not.
     */
    public boolean getAllowAPIACCES() {
        return projectAPIAccessCheckbox.isSelected();
    }

    /**
     * This method will verify if use https is selected.
     *
     * @return true if so and false if not.
     */
    public boolean getUseHttps() {
        return projectUseHttpsCheckBox.isSelected();
    }

    /**
     * This method will verify if atom rss is selected.
     *
     * @return true if so and false if not.
     */
    public boolean getAtomRss() {
        return projectAtomRssCheckBox.isSelected();
    }

    /**
     * This method will verify public access.
     *
     * @return true if so and false if not.
     */
    public boolean getPublicAccess() {
        return projectPublicAccessCheckBox.isSelected();
    }

    /**
     * This method will verify if enable incoming email is selected.
     *
     * @return true if so and false if not.
     */
    public boolean getEnableIncomingEmailCheckBox() {
        return projectEnableIncomingEmailCheckBox.isSelected();
    }

    /**
     * This method will verify the hide emails from collaborators.
     *
     * @return true if so and false if not.
     */
    public boolean getHideEmailsFromCollaboratorsCheckBox() {
        return projectHideEmailsFromCollaboratorsCheckBox.isSelected();
    }

    /**
     * This method will verify if a bug given points is selected.
     *
     * @return true if so and false if not.
     */
    public boolean getBugGivenPointsCheckBox() {
        return projectBugsCheckBox.isSelected();
    }

    /**
     * This method will set project tasks.
     *
     * @return the state.
     */
    public boolean getEnableProjectsTasks() {
        return projectEnableTasksCheckbox.isSelected();
    }

    /**
     * This method will verify the settings.
     *
     * @return Map of assertions.
     */
    public Map<SettingSteps, Object> getAssertionMap() {
        Map<SettingSteps, Object> assertionMap = new EnumMap<>(SettingSteps.class);
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
        assertionMap.put(DONE_ITERATION_SHOW, getNumberIterationShow());
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

    /**
     * This method will get a message.
     *
     * @param endPoint to make requst.
     * @param values   to send with the request.
     * @return request message.
     */
    public String getMassage(String endPoint, Map<SettingSteps, Object> values) {
        String nameDay = dayName(String.valueOf(values.get(PROJECT_START_DATE)));
        Map<Enum, Object> copy = new HashMap<>(values);
        copy.put(DATE_NAME, nameDay);
        final String point = "s.";
        final int index = 1;
        String result = endPoint;
        if (result.contains(REGEX_HALF_BRACKET)) {
            for (String endPointSplit : result.split(REGEX_BLACK_SPACE)) {
                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
                    StringBuilder value = new StringBuilder();
                    value.append(copy.get(SettingSteps.valueOf(mapString[index])));
                    result = result.replace(endPointSplit, value);
                }
            }
        }
        return result.concat(point);
    }

    /**
     * This method will get the day name.
     *
     * @param inputDate to set.
     * @return formatted day.
     */
    private String dayName(String inputDate) {
        Date date = null;
        final String format = "YYYY/MM/DD";
        final String standard = "EEEE";
        try {
            date = new SimpleDateFormat(format).parse(inputDate);
        } catch (ParseException e) {
            LOGGER.warn("Convert String format the date", e);
        }
        return new SimpleDateFormat(standard, Locale.ENGLISH).format(date);
    }
}
