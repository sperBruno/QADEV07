package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class Accounts extends BasePage {

    private ToolBarAccount toolBarAccount;

    @FindBy(id = "notice")
    private WebElement deleteAccountMessage;

    @FindBy(xpath = "//a[contains(.,'Manage Account')]")
    private WebElement manageAccountBtn;

    public Accounts() {
        toolBarAccount = new ToolBarAccount();
    }

    public ToolBarAccount manageAccount() {
        manageAccountBtn.click();
        return new ToolBarAccount();
    }

    public ToolBarAccount getToolBarAccount() {
        return toolBarAccount;
    }

    public String getDeleteAccountMessage() {
        return deleteAccountMessage.getText();
    }

}
