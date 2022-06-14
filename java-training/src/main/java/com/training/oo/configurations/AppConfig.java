package com.training.oo.configurations;

import com.training.oo.configurations.annotations.ConfigFile;
import com.training.oo.configurations.annotations.ConfigKey;

@ConfigFile("myconfig.properties")
public class AppConfig {
    @ConfigKey("app.name")
    private String appName;
    @ConfigKey("app.deneme")
    private Integer denemeSayisi;
    @ConfigKey("app.version")
    private String appVersion;
    @ConfigKey("app.test")
    private String appTest;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getDenemeSayisi() {
        return denemeSayisi;
    }

    public void setDenemeSayisi(Integer denemeSayisi) {
        this.denemeSayisi = denemeSayisi;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppTest() {
        return appTest;
    }

    public void setAppTest(String appTest) {
        this.appTest = appTest;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appName='" + appName + '\'' +
                ", denemeSayisi=" + denemeSayisi +
                ", appVersion='" + appVersion + '\'' +
                ", appTest='" + appTest + '\'' +
                '}';
    }
}
