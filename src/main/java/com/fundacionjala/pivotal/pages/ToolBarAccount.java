package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class ToolBarAccount extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Plans & Billing')]")
    private WebElement plansAndBillingTab;

    @FindBy(xpath = "//a[contains(.,'Settings')]")
    private WebElement settingTab;

    public AccountSetting clickSettingTab() {
        settingTab.click();
        return new AccountSetting();
    }
}
