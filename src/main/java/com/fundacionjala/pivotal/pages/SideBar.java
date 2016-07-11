package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by BrunoBarrios on 7/11/2016.
 */
public class SideBar {
    @FindBy(css = "a[data-aid='navTab-analytics']")
    WebElement analiticsTab;

    @FindBy(css = "[data-aid=['navTab-settings']")
    WebElement settingsTab;

    @FindBy(css = "[data-aid='navTab-members']")
    WebElement membersTab;

    @FindBy(css = "[data-aid='navTab-stories']")
    WebElement storiesTab;

    @FindBy(className = "_29mpe__projectNav__toggle")
    WebElement collapseBtn;


    public Settings clickSettingTab() {
        settingsTab.click();
        return new Settings();
    }

    public Members clickMemberTab() {
        membersTab.click();
        return new Members();
    }

    public Analytics clickAnaliticsTab() {
        analiticsTab.click();
        return new Analytics();
    }

}
