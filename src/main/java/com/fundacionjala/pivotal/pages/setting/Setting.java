package com.fundacionjala.pivotal.pages.setting;

import com.fundacionjala.pivotal.pages.dashboard.ToolBar;

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
