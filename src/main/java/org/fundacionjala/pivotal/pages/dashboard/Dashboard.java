package org.fundacionjala.pivotal.pages.dashboard;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.fundacionjala.pivotal.pages.workspace.Workspace;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * This class represent the Dashboard page
 *
 * @autor Mijhail Villarroel, Bruno Barrios, Daniel Gonzales, Rosario Garcia.
 */
public class Dashboard extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Dashboard.class.getName());

    @FindBy(className = "tc_dropdown_name")
    private WebElement userNameText;

    @FindBy(xpath = ".//*[@id='shared_header']/div/div/header/ul/li[3]/div/div/div/ul/li[2]/a")
    private WebElement accountOption;

    @FindBy(id = "create_new_project_button")
    private WebElement createProjectLink;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(id = "notice")
    private WebElement deleteMessageText;

    @FindBy(id = "notice")
    private WebElement messageDeleteWorkspace;

    /**
     * @return
     */
    public CreateProject clickCreateProjectLink() {
        createProjectLink.click();
        return new CreateProject();
    }

    /**
     * @return CreateWorkspace()
     */
    public CreateWorkspace clickCreateWorkspaceLink() {
        createWorkspaceLink.click();
        return new CreateWorkspace();
    }

    /**
     * @return
     */
    public String getUserNameText() {
        String userName = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            userName = userNameText.getText();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
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
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            WebElement projectNameLink = driver.findElement(By.xpath("//a[contains(.,'" + projectName + "')]"));
            projectNameLink.click();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The Web element not was find ", e.getCause());
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return new Project();
    }

    public Setting clickSettingsLink(String nameProjects) {
        WebElement taskElement = driver.findElement(By.xpath("//*[@class='hover_link settings' and @href=\"/projects/" + nameProjects + "/settings\"]"));
        taskElement.click();
        return new Setting();
    }

    public Accounts selectAccountOption() {
        userNameText.click();
        accountOption.click();
        return new Accounts();
    }


    public Workspace clickNameWorkspaceLink(String nameWorkspace) {
        WebElement nameWorkspaceLink = driver.findElement(By.xpath("//a[contains(.,'" + nameWorkspace + "')]"));
        System.out.println(nameWorkspaceLink.getText());
        nameWorkspaceLink.click();
        return new Workspace();
    }

    public String getMessageDeleteWorkspace() {
        return messageDeleteWorkspace.getText();
    }
}
