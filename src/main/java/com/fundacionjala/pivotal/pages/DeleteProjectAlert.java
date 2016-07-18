package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * Created by mijhailvillarroel on 7/15/2016.
 */
public class DeleteProjectAlert extends BasePage {

    @FindBy(css = ".delete.inline_dialog")
    private WebElement deleteAlertContainer;

    @FindBy(id = "confirm_delete")
    private WebElement deleteProjectBtn;

    public Dashboard clickDeleteBtn() {
        wait.until(ExpectedConditions.visibilityOf(deleteAlertContainer));
        clickWebElement(deleteProjectBtn);
        return new Dashboard();
    }
}
