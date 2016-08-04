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
        setCheckBox(projectPrivateRadioBtn, Boolean.parseBoolean(isCheckBoxEnable));
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
            LOGGER.warn("Element could not be found",e);
            answer = false;
        }
        LOGGER.info("AccountName is" + answer);
        return answer;
    }

    public void checkProjectVisible() {
        projectPublicRadioBtn.click();
    }

    public Project clickCreateProject() {
        try {
            clickWebElement(createNewProjectBtn);
            verifyErrorMessagesOfCreateProject();

        } catch (NullPointerException e) {
            LOGGER.error("null pointer", e);

        } catch (InvalidSelectorException e) {
            LOGGER.info("invalid web element",e);

        } catch (NoSuchElementException e) {
            LOGGER.warn("invalid no such element",e);
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
        setCheckBox(projectPublicRadioBtn, Boolean.parseBoolean(isCheckBoxEnable));
    }

    public Map<Enum, IAutomationStep> getStrategyStepMap(Map<ProjectSteps, Object> values) {
        final Map<Enum, IAutomationStep> strategyMap = new HashMap<>();

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
