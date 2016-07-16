package com.fundacionjala.pivotal.pages;

/**
 * Created by mijhailvillarroel on 7/12/2016.
 */
public class Setting {
    SideBarSetting sideBar;
    ToolBar toolBar;

    public Setting() {
        sideBar = new SideBarSetting();
        toolBar = new ToolBar();
    }

    public SideBarSetting getSideBar() {
        return sideBar;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }
}
