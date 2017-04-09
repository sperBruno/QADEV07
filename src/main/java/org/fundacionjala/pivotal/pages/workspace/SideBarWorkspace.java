package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales.
 */
public class SideBarWorkspace extends BasePage {

    @FindBy(xpath = "//button[contains(.,'add project')]")
    private WebElement addProjectLink;

    @FindBy(id = "_dropdown__arrow")
    private WebElement listProjectLink;

    @FindBy(id = "save_workspace_button")
    private WebElement saveWorkspaceLink;

    /**
     * this method will clik add project link.
     */
    public void clickAddProjectLink() {
        addProjectLink.click();
    }

    /**
     * This method will click list project link.
     */
    public void clickListProjectLink() {
        listProjectLink.click();
    }

    /**
     * This method will click project name link.
     *
     * @param projectName to create.
     */
    public void clickProjectNameLink(String projectName) {
        driver.findElement(By.xpath("//span[contains(.,'" + projectName + "')]")).click();
    }

    /**
     * This method will save workspace.
     *
     * @return workspace.
     */
    public Workspace clickSaveWorkspaceLink() {
        saveWorkspaceLink.click();
        return new Workspace();
    }
}
