package org.fundacionjala.pivotal.pages.dashboard;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * @ Mijhail Villarroel.
 */
public class ToolBar extends BasePage {

    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement returnDashboardLink;

    @FindBy(css = "[data-aid='navTab-settings']")
    private WebElement settingsTabLink;

    public Dashboard clickReturnDashboardLink() {
        clickWebElement(returnDashboardLink);
        return new Dashboard();
    }

    public Setting clickSettingTabLink() {
        clickWebElement(settingsTabLink);
        return new Setting();
    }
}