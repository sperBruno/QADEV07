package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

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
