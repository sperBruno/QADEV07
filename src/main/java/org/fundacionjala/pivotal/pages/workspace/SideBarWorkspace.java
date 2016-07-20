package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales
 */
public class SideBarWorkspace extends BasePage {

    @FindBy(xpath = "//button[contains(.,'add projects')]")
    private WebElement addProjectLink;

    @FindBy(id = "_dropdown__arrow")
    private WebElement listProjectLink;

    @FindBy(xpath = "//span[contains(.,'test')]")
    private WebElement idProjectLink;

    @FindBy(id = "save_workspace_button")
    private WebElement saveWorkspaceLink;


    public void clickAddProjectLink () {
        addProjectLink.click ();
    }

    public void clickListProjectLink () {
        listProjectLink.click ();
    }

    public void clickIdProjectLink () {
        idProjectLink.click ();
    }

    public Workspace clickSaveWorkspaceLink () {
        saveWorkspaceLink.click ();
        return new Workspace ();
    }
}
