package com.training.oo.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationRun {

    public static void main(String[] args) {
        try {
            File file = new File("myconfig.properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            AppConfig appConfig = new AppConfig();
            appConfig.setAppName(properties.getProperty("app.name"));
            appConfig.setDenemeSayisi(Integer.parseInt(properties.getProperty("app.deneme")));
            appConfig.setAppVersion(properties.getProperty("app.version"));
            appConfig.setAppTest(properties.getProperty("app.test"));
            System.out.println(appConfig);
            File file2 = new File("xyz.properties");
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            Properties properties2 = new Properties();
            properties.load(fileInputStream2);
            XyzProperties xyzProperties = new XyzProperties();
            xyzProperties.setName(properties2.getProperty("xyz.name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
