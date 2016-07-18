package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales on 7/14/2016.
 */
public class DeleteWorkspace extends BasePage {

    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteLink;

    @FindBy(className = "cancel")
    private WebElement cancelDeleteLink;

    public void clickCancelDeleteLink() {
        cancelDeleteLink.click();
    }

    public Dashboard clickConfirmDeleteLink() {
        confirmDeleteLink.click();
        return new Dashboard();
    }
}
