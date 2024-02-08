package com.util;


import com.POM.webElementPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

import static com.hooks.hook.driver;

public class webPageUtility {
    public static WebElement element;

    public static void click (String elementName){
        By path = (By) getVariableValue(elementName);
        element = driver.findElement(path);
        element.click();
    }

    public static boolean isItVisible (String elementName){
        element = driver.findElement(((By) getVariableValue(elementName)));
        if(element.isDisplayed()) {
            return true;
        }

        return false;
    }

    public static void type(String elementName,String typedValue){
        element = driver.findElement(((By) getVariableValue(elementName)));
        element.sendKeys(typedValue);
    }

    private static Object getVariableValue (String variableName){
        try {
            // Get the field (variable) from the class

            Field field = (webElementPath.class).getDeclaredField(variableName);

            // Set the field to be accessible, as it might be private
            field.setAccessible(true);

            // Get the value of the field for a specific instance (null for static fields)
            return field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
