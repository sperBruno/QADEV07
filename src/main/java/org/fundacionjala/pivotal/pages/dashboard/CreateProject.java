package org.fundacionjala.pivotal.pages.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.setCheckBox;

/**
 * @BrunoBarrios
 */
public class CreateProject extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(CreateProject.class.getName());

    private boolean errorAccountMessage;
    private boolean errorProjectTitleMessage;
    private String accountMessage;

    private String projectTitleMessage;

    @FindBy(className = "tc_form_input")
    private WebElement newProjectName;

    @FindBy(xpath = "//input[@placeholder='New account name']")
    private WebElement createNewAccountTxt;

    @FindBy(className = "tc_form_select")
    private WebElement accountDropDown;

    @FindBy(css = "button[class='tc_button tc_button_submit']")
    private WebElement createNewProjectBtn;

    @FindBy(css = "#tc_public_project>input")
    private WebElement projectVisibleCheckbox;

    @FindBy(xpath = ".//*/descendant::section/div[2]/div[@class=\"tc_form_error_message\"]")
    private WebElement accountErrorMessage;

    @FindBy(xpath = ".//*/descendant::section/div[1]/div[@class=\"tc_form_error_message\"]")
    private WebElement blankProjectNameMessage;

    @FindBy(css = "button[class='tc_button tc_button_cancel']")
    private WebElement cancelCreateProjectBtn;

    @FindBy(xpath = "//*[text()='Add sample project data']")
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
        setCheckBox(projectSampleDataCheckBox, Boolean.parseBoolean(isCheckBoxEnable));
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
        try {
            clickWebElement(createNewProjectBtn);
            verifyErrorMessagesOfCreateProject();

        } catch (NullPointerException e) {
            LOGGER.info("null pointer");

        } catch (InvalidSelectorException e) {
            LOGGER.info("invalid web element");

        } catch (NoSuchElementException e) {
        }
        return new Project();

    }

    private void verifyErrorMessagesOfCreateProject() {
        if (blankProjectNameMessage.isDisplayed()) {
            LOGGER.info("title message: " + blankProjectNameMessage.getText());
            projectTitleMessage = blankProjectNameMessage.getText();

        } else if (accountErrorMessage.isDisplayed()) {
            LOGGER.info("account message: " + accountErrorMessage.getText());
            accountMessage = accountErrorMessage.getText();
        }
    }

    public boolean createProjectFormIsdisplayed() {
        return newProjectName.isDisplayed() && accountDropDown.isDisplayed() && createNewProjectBtn.isDisplayed();
    }

    public Dashboard clickCancelCreateProjectBtn() {
        clickWebElement(cancelCreateProjectBtn);
        return new Dashboard();
    }

    public void clickMakeProjectVisibleCheckBox(String isCheckBoxEnable) {
        setCheckBox(projectVisibleCheckbox, Boolean.parseBoolean(isCheckBoxEnable));
    }

    public Map<ProjectSteps, IAutomationStep> getStrategyStepMap(Map<ProjectSteps, Object> values) {
        final Map<ProjectSteps, IAutomationStep> strategyMap = new HashMap<ProjectSteps, IAutomationStep>();

        strategyMap.put(ProjectSteps.PROJECT_TITLE, () -> setProjectName(String.valueOf(values.get(ProjectSteps.PROJECT_TITLE))));
        strategyMap.put(ProjectSteps.PROJECT_ACCOUNT, () -> setAccountDropDown(String.valueOf(values.get(ProjectSteps.PROJECT_ACCOUNT))));
        strategyMap.put(ProjectSteps.PROJECT_VISIBLE, () -> clickMakeProjectVisibleCheckBox(String.valueOf(values.get(ProjectSteps.PROJECT_VISIBLE))));
        strategyMap.put(ProjectSteps.PROJECT_SAMPLE_DATA, () -> clickDataSampleCheckBox(String.valueOf(values.get(ProjectSteps.PROJECT_SAMPLE_DATA))));
        return strategyMap;
    }

    public String getAccountMessage() {
        return accountMessage;
    }

    public String getProjectTitleMessage() {
        return projectTitleMessage;
    }
}
