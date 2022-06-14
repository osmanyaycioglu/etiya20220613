package com.training.etiya.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.info.xyz")
public class MyProperties {

    private String name;
    private String test;
    private String denemeSayisi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getDenemeSayisi() {
        return denemeSayisi;
    }

    public void setDenemeSayisi(String denemeSayisi) {
        this.denemeSayisi = denemeSayisi;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "name='" + name + '\'' +
                ", test='" + test + '\'' +
                ", denemeSayisi='" + denemeSayisi + '\'' +
                '}';
    }
}
