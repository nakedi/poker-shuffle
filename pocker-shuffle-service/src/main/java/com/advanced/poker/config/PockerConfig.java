package com.advanced.poker.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PockerConfig {

    private static Properties properties;

    private static void load() {
        properties = new Properties();

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "application.properties";

        try {
            properties.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(properties.get("com.advance.poker.type"));
    }

    public PockerConfig() {
        load();
    }

    public static Properties getProperties() {
        if(properties == null){
            load();
        }
        return properties;
    }
}
