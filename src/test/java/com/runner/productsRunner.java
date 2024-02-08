package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/features"},
        glue = {"steps",
                "hooks"},
//        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@UiAutomationExercise",
        monochrome = true
)
public class productsRunner extends AbstractTestNGCucumberTests {
}
