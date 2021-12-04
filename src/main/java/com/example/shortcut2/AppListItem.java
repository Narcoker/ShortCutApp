package com.example.shortcut2;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

public class AppListItem implements Serializable {
    private Drawable appIcon;
    private String appName;
    private String appPackageName;
    private String pattern;

    public AppListItem(String appName, String appPackageName) {
        this.appName = appName;
        this.appPackageName = appPackageName;
    }

    public AppListItem(String appName, String appPackageName, String pattern) {
        this.appName = appName;
        this.appPackageName = appPackageName;
        this.pattern = pattern;
    }

    public AppListItem(Drawable appIcon, String appName, String appPackageName) {
        this.appIcon = appIcon;
        this.appName = appName;
        this.appPackageName = appPackageName;
    }

    public AppListItem(Drawable appIcon, String appName, String pattern, String appPackageName) {
        this.appIcon = appIcon;
        this.appName = appName;
        this.pattern = pattern;
        this.appPackageName = appPackageName;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String Drawable) {
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "";
    }
}
