package com.fundacionjala.pivotal.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class AccountSetting extends BasePage {

    private Logger LOGGER  = Logger.getLogger(AccountSetting.class.getName());

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    public Accounts deleteAccount(){
        deleteAccountLink.click();
        driver.switchTo().alert().accept();
        driver.switchTo().activeElement();
        return new Accounts();
    }
}
