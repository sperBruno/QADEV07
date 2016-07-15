package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 *
 */
public class Dashboard extends BasePage {

    @FindBy(className = "tc_dropdown_name")
    private WebElement userNameText;

    @FindBy(id = "create_new_project_button")
    private WebElement createProjectLink;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(id = "notice")
    private WebElement deleteMessageText;

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
     * @autor Rosario Garcia
     */
    public Project clickOnProject(String projectName) {
        WebElement projectNameLink = driver.findElement(By.xpath("//a[contains(.,'" + projectName + "')]"));
        projectNameLink.click();
        return new Project();
    }

    public Setting clickSettingsLink(String nameProjects) {
        WebElement taskElement = driver.findElement(By.xpath("//*[@class='hover_link settings' and @href=\"/projects/" + nameProjects + "/settings\"]"));
        taskElement.click();
        return new Setting();
    }
}
