package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by BrunoBarrios on 7/11/2016.
 */
public class Analytics {

    @FindBy(xpath = "//span[@style='font-size: 12px;']")
    WebElement feedBackOption;

    public FeedBackPanel clickSendFeedBackOption() {
        feedBackOption.click();
        return new FeedBackPanel();
    }

    public boolean isSendFeedBackOptionDisplayed() {
        return feedBackOption.isDisplayed();
    }
}
