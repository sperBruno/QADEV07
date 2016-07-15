package com.fundacionjala.pivotal.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_PROJECT_WAIT;

/**
 * Created by brunobarrios on 7/15/2016.
 */
public class AccountSetting extends BasePage {

    private Logger LOGGER  = Logger.getLogger(AccountSetting.class.getName());

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    public Accounts deleteAccount(){
        deleteAccountLink.click();
        try {

            driver.manage().timeouts().implicitlyWait(IMPLICIT_PROJECT_WAIT, TimeUnit.SECONDS);
             driver.switchTo().alert();
             driver.findElement(By.xpath("//.*[text()='OK']")).click();
        } catch (UnhandledAlertException e) {
            LOGGER.warn("The Element could not be found", e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
        }
        return new Accounts();
    }
}
