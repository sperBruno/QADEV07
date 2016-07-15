package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ToolBar extends BasePage {
    
    @FindBy(xpath = "//a[@href='/dashboard']")
    private WebElement dashboardLink;
    
    public Dashboard clickOnDashboardLink(){
        dashboardLink.click();
        return new Dashboard();
    }
}
