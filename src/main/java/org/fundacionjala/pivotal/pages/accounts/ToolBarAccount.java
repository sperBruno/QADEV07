package org.fundacionjala.pivotal.pages.accounts;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class ToolBarAccount extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Settings')]")
    private WebElement settingTab;

    /**
     * This method will be used to select setting tab.
     *
     * @return Account settings.
     */
    public AccountSetting clickSettingTab() {
        clickWebElement(settingTab);
        return new AccountSetting();
    }
}
