package com.fundacionjala.pivotal.framework.util;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mijhailvillarroel on 7/14/2016.
 */
public final class CommonMethods {

    private CommonMethods() {
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public static void setWebElement(WebElement webElement, String text) {
        //  DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void clickWebElement(WebElement webElement) {
        //  DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

//    public static void enableCheckBox(WebElement webElement, boolean enable) {
//        if (enable) {
//            if (!webElement.isSelected()) {
//                webElement.click();
//            }
//        } else {
//            if (webElement.isSelected()) {
//                webElement.click();
//            }
//        }
//    }

    public static void selectAElementComboBox(WebElement webElementSelect, String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }

}