package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by BrunoBarrios on 7/12/2016.
 */
public class Settings extends BasePage{

    @FindBy(className = "text_column")
    WebElement projectId;

    public String getProjectId(){
        return projectId.getText();
    }
}
