package org.fundacionjala.pivotal.pages.accounts;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class ToolBarAccount extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Plans & Billing')]")
    private WebElement plansAndBillingTab;

    @FindBy(xpath = "//a[contains(.,'Settings')]")
    private WebElement settingTab;

    public AccountSetting clickSettingTab() {
        clickWebElement(settingTab);
        return new AccountSetting();
    }
}
