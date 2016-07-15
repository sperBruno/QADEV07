package com.fundacionjala.pivotal.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.pages.ProjectSteps.PROJECT_ACCOUNT;
import static com.fundacionjala.pivotal.pages.ProjectSteps.PROJECT_SAMPLE_DATA;
import static com.fundacionjala.pivotal.pages.ProjectSteps.PROJECT_TITLE;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class CreateProject extends BasePage {
    private static Logger LOGGER = Logger.getLogger(CreateProject.class.getName());
    @FindBy(className = "tc_form_input")
    private WebElement newProjectName;

    @FindBy(xpath = "//input[@placeholder='New account name']")
    private WebElement createNewAccountTxt;

    @FindBy(className = "tc_form_select")
    private WebElement accountDropDown;

    @FindBy(css = "button[class='tc_button tc_button_submit']")
    private WebElement createNewProjectBtn;

    @FindBy(css = "input[type='checkbox']")
    private WebElement projectVisibleCheckbox;

    @FindBy(css = ".tc_form_label.tc_form_checkbox>input")
    private WebElement projectSampleDataCheckBox;

    @FindBy(css = ".tc_select_option.tc_select_create_account")
    private WebElement createAccountOption;

    public CreateProject setProjectName(String projectName) {
        newProjectName.sendKeys(projectName);
        return this;
    }

    public CreateProject setAccountDropDown(String accountName) {
        accountDropDown.click();
        if (!isAccountNamePresent(accountName)) {
            createAccount(accountName);
        } else {
            driver.findElement(By.xpath("//span[text()='" + accountName + "']")).click();
        }
        return this;
    }

    public CreateProject clickDataSampleCheckBox(String isCheckBoxEnable) {
        GeneralSettingForm.enableCheckBox(projectSampleDataCheckBox, Boolean.parseBoolean(isCheckBoxEnable));
        return this;
    }

    private CreateProject createAccount(String accountName) {
        LOGGER.info("creating account");
        createAccountOption.click();
        createNewAccountTxt.sendKeys(accountName);
        return this;
    }

    private boolean isAccountNamePresent(String accountName) {
        boolean answer;
        try {
            answer = driver.findElement(By.xpath("//span[text()='" + accountName + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.warn("Element could not be found", e);
            answer = false;
        }
        LOGGER.info("AccountName is" + answer);
        return answer;
    }

    public void checkProjectVisible() {
        projectVisibleCheckbox.click();
    }

    public Project clickCreateProject() {
        createNewProjectBtn.click();
        return new Project();
    }

    public boolean createProjectFormIsdisplayed() {
        return newProjectName.isDisplayed() && accountDropDown.isDisplayed() && createNewProjectBtn.isDisplayed();
    }

    public Map<ProjectSteps, IAutomationStep> getStrategyStepMap(Map<ProjectSteps, Object> values) {
        final Map<ProjectSteps, IAutomationStep> strategyMap = new HashMap<ProjectSteps, IAutomationStep>();

        strategyMap.put(PROJECT_TITLE, () -> setProjectName(String.valueOf(values.get(PROJECT_TITLE))));
        strategyMap.put(PROJECT_ACCOUNT, () -> setAccountDropDown(String.valueOf(values.get(PROJECT_ACCOUNT))));
        strategyMap.put(PROJECT_SAMPLE_DATA, () -> clickDataSampleCheckBox(String.valueOf(values.get(PROJECT_SAMPLE_DATA).toString())));
        return strategyMap;
    }
}
