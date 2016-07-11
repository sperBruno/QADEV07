package com.fundacionjala.pivotal.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Bruno on 7/7/2016.
 */
public class Project extends BasePage {
    @FindBy(css = "span[class='raw_context_name']")
    private WebElement projectName;

    @FindBy(css = "[data-aid='navTab-settings']")
    WebElement settings;


//    public Settings clickSettingTab() {
//        settings.click();
//        return new Settings();
//    }

    public String existsElement() {
        return projectName.getText();
    }

}
