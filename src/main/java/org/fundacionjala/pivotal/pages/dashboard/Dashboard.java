package org.fundacionjala.pivotal.pages.dashboard;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.fundacionjala.pivotal.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.pages.workspace.Workspace;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.Constants.*;

/**
 * This class represent the Dashboard page
 *
 * @autor Mijhail Villarroel, Bruno Barrios, Daniel Gonzales, Rosario Garcia.
 */
public class Dashboard extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Dashboard.class.getName());

    private static final String CREATE_WORKSPACE_BUTTON_WAS_NOT_FOUND_MSG = "Create Workspace Button was not found";

    @FindBy(css = ".tc_dropdown_name")
    private WebElement userNameText;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountOption;

    @FindBy(id = "create_new_project_button")
    private WebElement createProjectLink;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(id = "notice")
    private WebElement deleteMessageText;

    @FindBy(id = "notice")
    private WebElement messageDeleteWorkspace;

    @FindBy(id = "my_workspaces")
    private WebElement workspaceContainer;

    /**
     * @return
     */
    public CreateProject clickCreateProjectLink() {
        try {
            wait.withTimeout(45, SECONDS);
            clickWebElement(createProjectLink);
        } catch (NoSuchElementException e) {
            LOGGER.warn("Create Project link was not found", e);
            throw new NoSuchElementException("Create Project link was not found", e);
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new CreateProject();
    }

    /**
     * @return CreateWorkspace()
     */
    public CreateWorkspace clickCreateWorkspaceLink() {

        try {
            wait.withTimeout(45, SECONDS);
            clickWebElement(createWorkspaceLink);
        } catch (NoSuchElementException e) {
            LOGGER.warn(CREATE_WORKSPACE_BUTTON_WAS_NOT_FOUND_MSG, e);
            throw new NoSuchElementException(CREATE_WORKSPACE_BUTTON_WAS_NOT_FOUND_MSG);
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new CreateWorkspace();
    }

    /**
     * @return
     */
    public String getUserNameText() {
        String userName = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            userName = userNameText.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn("User name element not found", e);

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return userName;
    }

    /**
     * @return
     */
    public String getMessageTextDelete() {
        return deleteMessageText.getText();
    }

    /**
     * This method is used to enter to main page of
     * project created using its name.
     *
     * @param projectName: This parameter is the project name of project created
     * @return: return the project main page
     */
    public Project clickOnProject(String projectName) {
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            WebElement projectNameLink = fluentWait(By.xpath("//a[contains(.,'" + projectName + "')]"));
            projectNameLink.click();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The Project button web element not was find ", e);
            throw new NoSuchElementException("The Web element not was find ", e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return new Project();
    }

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(locator));
    }

    ;

    public Setting clickSettingsLink(String nameProjects) {
        refreshPage();
        WebElement taskElement = driver.findElement(By.xpath("//*[@class='hover_link settings' and @href=\"/projects/" + nameProjects + "/settings\"]"));
        clickWebElement(taskElement);
        return new Setting();
    }

    public Accounts selectAccountOption() {
        userNameText.click();
        accountOption.click();
        return new Accounts();
    }

    public Workspace clickNameWorkspaceLink(String nameWorkspace) {
        WebElement nameWorkspaceLink = driver.findElement(By.xpath("//a[contains(.,'" + nameWorkspace + "')]"));
        nameWorkspaceLink.click();
        return new Workspace();
    }

    public String getMessageDeleteWorkspace() {
        return messageDeleteWorkspace.getText();
    }

    public String getUserName(String value) {

        final String endPointProfile = "/me";
        final String fieldEmail = "email";
        final String fieldUserName = "username";
        final String email = RequestManager.getRequest(endPointProfile).jsonPath().get(fieldEmail);
        if (value.equalsIgnoreCase(email)) {
            return RequestManager.getRequest(endPointProfile).jsonPath().get(fieldUserName);
        }
        return value;
    }
}
