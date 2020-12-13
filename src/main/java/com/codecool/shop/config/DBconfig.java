package com.codecool.shop.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class DBconfig {


    public HashMap<String, String> getDBProperties() {
        HashMap<String, String> dbProperties = new HashMap<>();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return dbProperties;
            }
            prop.load(input);
            dbProperties.put("db.name", prop.getProperty("db.name"));
            dbProperties.put("db.user", prop.getProperty("db.user"));
            dbProperties.put("db.password", prop.getProperty("db.password"));

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        return dbProperties;
    }

}


