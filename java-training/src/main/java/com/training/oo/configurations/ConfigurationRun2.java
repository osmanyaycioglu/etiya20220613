package com.training.oo.configurations;

import com.training.oo.configurations.annotations.ConfigEngine;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationRun2 {

    public static void main(String[] args) {
        try {
            AppConfig appConfig = ConfigEngine.processConfig(new AppConfig());
            System.out.println(appConfig);

            XyzProperties xyzProperties = ConfigEngine.processConfig(new XyzProperties());
            System.out.println(xyzProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
