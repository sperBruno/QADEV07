package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales
 */
public class SideBarWorkspace extends BasePage {

    @FindBy(xpath = "//button[contains(.,'add project')]")
    private WebElement addProjectLink;

    @FindBy(id = "_dropdown__arrow")
    private WebElement listProjectLink;

    @FindBy(id = "save_workspace_button")
    private WebElement saveWorkspaceLink;

    public void clickAddProjectLink() {
        addProjectLink.click();
    }

    public void clickListProjectLink() {
        listProjectLink.click();
    }

    public void clickProjectNameLink(String projectName) {
        driver.findElement(By.xpath("//span[contains(.,'" + projectName + "')]")).click();
    }

    public Workspace clickSaveWorkspaceLink() {
        saveWorkspaceLink.click();
        return new Workspace();
    }
}
