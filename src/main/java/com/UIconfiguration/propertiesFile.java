package com.UIconfiguration;

import com.hooks.hook;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class propertiesFile {
    static Properties properties = new Properties();
    static InputStream inputStream;
    static OutputStream outputStream;


    public static void getBaseUrl (){
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/java/configuration/cofig.properties"));
            properties.load(inputStream);
            hook.baseUrl = properties.getProperty("automationExerciseBaseUrl");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void getBrowserProperties (){
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/test/java/configuration/cofig.properties"));
            properties.load(inputStream);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void setProperties (String browser){
        try {
            outputStream = Files.newOutputStream(Paths.get(System.getProperty("user.dir") + "/src/test/java/configuration/cofig.properties"));
            properties.setProperty("browser",browser);
            properties.store(outputStream,null);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}