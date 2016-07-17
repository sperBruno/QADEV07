package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ToolBar extends BasePage {

    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement returnDashboardLink;

    @FindBy(css = "[data-aid='navTab-settings']")
    WebElement SettingsTabLink;

    public Dashboard clickReturnDashboardLink() {
        returnDashboardLink.click();
        return new Dashboard();
    }

    public Setting clickSettingTabLink() {
        SettingsTabLink.click();
        return new Setting();
    }
}