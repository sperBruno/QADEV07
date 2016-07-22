package org.fundacionjala.pivotal.pages.dashboard;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.fundacionjala.pivotal.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.pages.workspace.Workspace;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * This class represent the Dashboard page
 *
 * @autor Mijhail Villarroel, Bruno Barrios, Daniel Gonzales, Rosario Garcia.
 */
public class Dashboard extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Dashboard.class.getName());

    private static final String CREATE_WORKSPACE_BUTTON_WAS_NOT_FOUND_MSG = "Create Workspace Button was not found";

    @FindBy(className = "tc_dropdown_name")
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
            throw new NoSuchElementException("Create Project link was not found");
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
        driver.navigate().refresh();
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            WebElement projectNameLink = driver.findElement(By.xpath("//a[contains(.,'" + projectName + "')]"));
            projectNameLink.click();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The Web element not was find ", e.getCause());
            throw new NoSuchElementException("The Web element not was find ", e.getCause());
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return new Project();
    }

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

    public void refreshPage() {
        driver.navigate().refresh();
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
