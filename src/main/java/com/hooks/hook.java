package com.hooks;

import com.UIconfiguration.propertiesFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.core.gherkin.Pickle;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import io.cucumber.plugin.event.TestCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class hook {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static String baseUrl;

    @BeforeAll
    public static void setUp (){

        String browserName = "chrome";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("ignoreProtectedModeSittings",true);
        propertiesFile.getBaseUrl();//set the Url for the driver
        //propertiesFile.setCredentials();

        if(browserName.equalsIgnoreCase("firefox")) { //driver setup
            driver = WebDriverManager.firefoxdriver().create();
        } else if(browserName.equalsIgnoreCase("chrome")) {
//            driver = WebDriverManager.chromedriver().create();
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("disable-gpu");
            driver = new ChromeDriver(chromeOptions);

        } else{
            driver = WebDriverManager.edgedriver().create();
        }
        driver.get(baseUrl);
        Report();
    }

    @Before
    public void beforeScenario (Scenario scenario){
        System.out.println("Before Scenario: " + scenario.getName());
    }


    @After
    public void afterScenarioLogs (Scenario scenario) throws Exception{
        Field delegate = scenario.getClass().getDeclaredField("delegate");
        delegate.setAccessible(true);
        TestCaseState state = (TestCaseState) delegate.get(scenario);
        Field testCaseF = state.getClass().getDeclaredField("testCase");
        testCaseF.setAccessible(true);
        TestCase testCase = (TestCase) testCaseF.get(state);
        Field pickle = testCase.getClass().getDeclaredField("pickle");
        pickle.setAccessible(true);
        Pickle pickleState = (Pickle) pickle.get(testCase);
        List<Step> steps = pickleState.getSteps();
        ExtentTest test = extent.createTest(scenario.getName());

        for (Step s : steps)
            test.info(s.getText());

        if(!scenario.isFailed()) {
            test.pass(scenario.getName());
//            test.log(Status.PASS,"This is a logging event for: 👀 " + scenario.getName() + ", and it passed\n" + steps.toString());
        } else{
            test.fail(scenario.getName());

//            extent.createTest(scenario.getName()).log(Status.FAIL,"This is a logging event for: 👀" + scenario.getName() + ", and it failed!\n" + steps.toString());

        }
    }


    public static void Report (){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        extent = new ExtentReports();
        Date date = new Date();
        spark = new ExtentSparkReporter("testOutput/"+timeStamp+"/Spark.html");
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("Automation Exercise");
    }

    @AfterAll
    public static void wrapUp (){
        driver.close();
        driver.quit();
        System.out.println("Closed ... ");
        extent.flush();
    }

}


