package com.fundacionjala.pivotal.pages;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class Accounts extends BasePage {

    private ToolBarAccount toolBarAccount;

    public Accounts() {
        toolBarAccount = new ToolBarAccount();
    }

    public ToolBarAccount getToolBarAccount() {
        return toolBarAccount;
    }
}
