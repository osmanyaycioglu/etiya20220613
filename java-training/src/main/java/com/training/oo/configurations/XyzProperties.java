package com.training.oo.configurations;

import com.training.oo.configurations.annotations.ConfigFile;
import com.training.oo.configurations.annotations.ConfigKey;

@ConfigFile("xyz.properties")
public class XyzProperties {
    @ConfigKey("xyz.test")
    private String test;
    @ConfigKey("xyz.name")
    private String name;
    @ConfigKey("xyz.goto")
    private String gotoStr;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGotoStr() {
        return gotoStr;
    }

    public void setGotoStr(String gotoStr) {
        this.gotoStr = gotoStr;
    }

    @Override
    public String toString() {
        return "XyzProperties{" +
                "test='" + test + '\'' +
                ", name='" + name + '\'' +
                ", gotoStr='" + gotoStr + '\'' +
                '}';
    }
}
