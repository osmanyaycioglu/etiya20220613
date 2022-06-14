package com.training.oo.configurations.annotations;

import com.training.oo.configurations.AppConfig;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigEngine {

    public Object processConfig(Object instance) {
        Class<?> aClass = instance.getClass();
        ConfigFile fileAnno = aClass.getAnnotation(ConfigFile.class);
        if (fileAnno == null) {
            return instance;
        }
        String fileName = fileAnno.value();
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field f : declaredFields) {
                ConfigKey configKey = f.getAnnotation(ConfigKey.class);
                if (configKey != null) {
                    String keyName = configKey.value();
                    String property = properties.getProperty(keyName);
                    if (property != null) {
                        f.setAccessible(true);
                        switch (f.getType()
                                 .getName()) {
                            case "java.lang.String": {
                                f.set(instance,
                                      property);
                            }
                            break;
                            case "java.lang.Integer": {
                                f.set(instance,
                                      Integer.parseInt(property));
                            }
                            break;
                            case "java.lang.Long": {
                                f.set(instance,
                                      Long.parseLong(property));
                            }
                            break;
                            case "int": {
                                f.setInt(instance,
                                         Integer.parseInt(property));
                            }
                            break;

                        }
                    }
                }
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
