package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.time.Duration;

import static com.hooks.hook.driver;
import static com.util.webPageUtility.*;

public class automationExerciseSteps {


    @Given("Navigate to {string}")
    public void navigateTo (String URL){
        driver.get(URL);
    }

    @And("verify {string} is visible")
    public void isVisible (String visible){
        Assert.assertTrue(isItVisible(visible),"it is not visible.");
    }

    @And("Click on {string}")
    public void clickOn (String button){
        click(button);
    }

    @And("fill in the {string} field with {string}")
    public void fillInTheFieldWith (String elementName,String typedValue){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        type(elementName,typedValue);
    }

    @Given("{string} is opened")
    public void isOpened (String page){
        //to-do
    }
}
