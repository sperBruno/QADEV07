package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales on 7/14/2016.
 */
public class SettingWorkspace extends BasePage {

    private ToolBar toolBar;

    @FindBy(id = "workspace_name")
    private WebElement workspaceNameText;

    @FindBy(id = "delete_link")
    private WebElement deleteWorkspaceLink;

    public SettingWorkspace() {
        toolBar = new ToolBar();
    }

    public ToolBar getToolBar() {
        return toolBar;
    }
}
