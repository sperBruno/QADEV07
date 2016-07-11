package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class SideBarSetting extends SideBar {

    @FindBy(xpath = "//a[text()=\"General Settings\"]")
    private WebElement linkGeneralSettings;

    @FindBy(xpath = "//a[text()=\"Project Profile\"]")
    private WebElement linkProjectProfile;

    @FindBy(xpath = "//a[text()=\"Integrations\"]")
    private WebElement linkIntegrations;

    @FindBy(xpath = "//a[text()=\"Import CSV\"]")
    private WebElement linkImportCSV;

    @FindBy(xpath = "//a[text()=\"Export CSV\"]")
    private WebElement linkExportCSV;

    public ContainerSetting clickGeneralSetting() {
        linkGeneralSettings.click();
        return new ContainerSetting();
    }
}
