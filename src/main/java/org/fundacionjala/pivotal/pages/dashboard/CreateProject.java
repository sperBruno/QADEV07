package org.fundacionjala.pivotal.pages.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.setCheckBox;
import static org.fundacionjala.pivotal.pages.project.ProjectSteps.PROJECT_TITLE;
import static org.fundacionjala.pivotal.pages.project.ProjectSteps.PROJECT_ACCOUNT;
import static org.fundacionjala.pivotal.pages.project.ProjectSteps.PROJECT_VISIBLE;
import static org.fundacionjala.pivotal.pages.project.ProjectSteps.PROJECT_SAMPLE_DATA;

/**
 * @BrunoBarrios
 */
public class CreateProject extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(CreateProject.class.getName());

    private String accountMessage;

    private String projectTitleMessage;

    @FindBy(className = "tc-project-name__input")
    private WebElement newProjectName;

    @FindBy(className = "tc-account-creator__name")
    private WebElement createNewAccountTxt;

    @FindBy(className = "tc-account-selector__header")
    private WebElement accountDropDown;

    @FindBy(css = ".tc-create-project-footer__button.tc-create-project-footer__button--submit")
    private WebElement createNewProjectBtn;

    @FindBy(css = "input[type='radio'][value='public']")
    private WebElement projectPublicRadioBtn;

    @FindBy(css = "span[contains(.,'Please select or create an account for the new project')]")
    private WebElement accountErrorMessage;

    @FindBy(css = ".tc-project-name__info > span")
    private WebElement blankProjectNameMessage;

    @FindBy(css = ".tc-create-project-footer__button.tc-create-project-footer__button--cancel")
    private WebElement cancelCreateProjectBtn;

    @FindBy(css = "input[type='radio'][value='private']")
    private WebElement projectPrivateRadioBtn;

    @FindBy(className = "tc-account-selector__create-account-icon")
    private WebElement createAccountOption;

    /**
     * This method will be used set the project name.
     *
     * @param projectName to create.
     * @return CreateProject.
     */
    public CreateProject setProjectName(String projectName) {
        newProjectName.sendKeys(projectName);
        return this;
    }

    /**
     * This method will be used to select an account for the project.
     *
     * @param accountName to use.
     * @return CreateProject.
     */
    public CreateProject setAccountDropDown(String accountName) {
        accountDropDown.click();
        if (!isAccountNamePresent(accountName)) {
            createAccount(accountName);
        } else {
            driver.findElement(By.xpath("//span[text()='" + accountName + "']")).click();
        }
        return this;
    }

    /**
     * This method will be used select data sample checkbox.
     *
     * @param isCheckBoxEnable chackbox state.
     * @return CreateProject.
     */
    public CreateProject clickDataSampleCheckBox(String isCheckBoxEnable) {
        setCheckBox(projectPrivateRadioBtn, Boolean.parseBoolean(isCheckBoxEnable));
        return this;
    }

    /**
     * This method will be used to create an account.
     *
     * @param accountName for the account
     * @return CreateProject.
     */
    private CreateProject createAccount(String accountName) {
        LOGGER.info("creating account");
        createAccountOption.click();
        createNewAccountTxt.sendKeys(accountName);
        return this;
    }

    /**
     * This method will be used to verify if an account name exists.
     *
     * @param accountName to shearch
     * @return true if exists or false if not.
     */
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

    /**
     * This method will be used to mark if a project will be visible.
     */
    public void checkProjectVisible() {
        projectPublicRadioBtn.click();
    }

    /**
     * This method will be used to click on create project button.
     *
     * @return Project.
     */
    public Project clickCreateProject() {
        try {
            clickWebElement(createNewProjectBtn);
            verifyErrorMessagesOfCreateProject();

        } catch (NullPointerException e) {
            LOGGER.error("null pointer", e);

        } catch (InvalidSelectorException e) {
            LOGGER.info("invalid web element", e);

        } catch (NoSuchElementException e) {
            LOGGER.warn("invalid no such element", e);
        }
        return new Project();

    }

    /**
     * This method will be used to verify if an error happens.
     */
    private void verifyErrorMessagesOfCreateProject() {
        if (blankProjectNameMessage.isDisplayed()) {
            LOGGER.info("title message: " + blankProjectNameMessage.getText());
            projectTitleMessage = blankProjectNameMessage.getText();

        } else if (accountErrorMessage.isDisplayed()) {
            LOGGER.info("account message: " + accountErrorMessage.getText());
            accountMessage = accountErrorMessage.getText();
        }
    }

    /**
     * This method will verify if a create project form was displayed.
     *
     * @return true if so and false if not.
     */
    public boolean createProjectFormIsdisplayed() {
        return newProjectName.isDisplayed() && accountDropDown.isDisplayed() && createNewProjectBtn.isDisplayed();
    }

    /**
     * This method will be used to cancel the creation of a project.
     *
     * @return Dashboard.
     */
    public Dashboard clickCancelCreateProjectBtn() {
        clickWebElement(cancelCreateProjectBtn);
        return new Dashboard();
    }

    /**
     * This method will be used to make a project visible.
     *
     * @param isCheckBoxEnable the state of the checkbox.
     */
    public void clickMakeProjectVisibleCheckBox(String isCheckBoxEnable) {
        setCheckBox(projectPublicRadioBtn, Boolean.parseBoolean(isCheckBoxEnable));
    }

    /**
     * This method will be used to create a Project at once.
     *
     * @param values of the new project.
     * @return the new Project.
     */
    public Map<Enum, IAutomationStep> getStrategyStepMap(Map<ProjectSteps, Object> values) {
        final Map<Enum, IAutomationStep> strategyMap = new HashMap<>();
        String projectTitle = String.valueOf(values.get(PROJECT_TITLE));
        String accountName = String.valueOf(values.get(PROJECT_ACCOUNT));
        String isCheckBoxEnable = String.valueOf(values.get(PROJECT_VISIBLE));
        String sampleData = String.valueOf(values.get(PROJECT_SAMPLE_DATA));
        strategyMap.put(PROJECT_TITLE, () -> setProjectName(projectTitle));
        strategyMap.put(PROJECT_ACCOUNT, () -> setAccountDropDown(accountName));
        strategyMap.put(PROJECT_VISIBLE, () -> clickMakeProjectVisibleCheckBox(isCheckBoxEnable));
        strategyMap.put(PROJECT_SAMPLE_DATA, () -> clickDataSampleCheckBox(sampleData));
        return strategyMap;
    }

    /**
     * This method will get the error message string.
     *
     * @return error message.
     */
    public String getAccountMessage() {
        return accountMessage;
    }

    /**
     * This method will be used to get the title message.
     *
     * @return the tittle message.
     */
    public String getProjectTitleMessage() {
        return projectTitleMessage;
    }
}
