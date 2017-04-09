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

    /**
     * This method will click on dashboard link.
     *
     * @return Dashboard.
     */
    public Dashboard clickReturnDashboardLink() {
        clickWebElement(returnDashboardLink);
        return new Dashboard();
    }

    /**
     * This method will click on setting tab link.
     *
     * @return Setting.
     */
    public Setting clickSettingTabLink() {
        clickWebElement(settingsTabLink);
        return new Setting();
    }
}
