package org.fundacionjala.pivotal.pages.workspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;

/**
 * This class create a form to create a new Workspace.
 *
 * @author Daniel Gonzales.
 */
public class DeleteWorkspace extends BasePage {

    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteLink;

    @FindBy(className = "cancel")
    private WebElement cancelDeleteLink;

    /**
     * This method will click on cancel delete.
     */
    public void clickCancelDeleteLink() {
        cancelDeleteLink.click();
    }

    /**
     * This method will confirm the delete.
     *
     * @return Dashboard.
     */
    public Dashboard clickConfirmDeleteLink() {
        confirmDeleteLink.click();
        return new Dashboard();
    }
}
