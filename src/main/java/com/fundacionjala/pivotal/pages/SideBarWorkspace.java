package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales on 7/13/2016.
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


    public void clickAddProjectLink() {
        addProjectLink.click();
    }

    public void clicklistProjectLink() {
        listProjectLink.click();
    }

    public void clickidProjectLink() {
        idProjectLink.click();
    }

    public Workspace clickSaveWorkspaceLink() {
        saveWorkspaceLink.click();
        return new Workspace();
    }
}
