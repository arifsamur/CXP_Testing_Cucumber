package com.platform.step_definitions;

import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(){

        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
        Driver.getDriver().get(cxpUrl);

        Driver.getDriver().manage().window().maximize();

        System.out.println("Before: Test is starting, webpage opens");


        System.out.println();
    }

    @After
    public void tearDownScenario(){

        System.out.println();
        System.out.println("After: Test is executed. Browser is being closed.");

        Driver.closeDriver();

    }


    @BeforeStep
    public void setUpStep(Scenario scenario){

        System.out.println("---- Before each step -----");


        if (scenario.isFailed()) {
            System.out.println("Before step take SS if test fails");

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println();

    }


    @AfterStep
    public void tearDownStep(Scenario scenario) throws InterruptedException {

        System.out.println("Scenario Name = " + scenario.getName());
        System.out.println("Tag Name(s) = " + scenario.getSourceTagNames());
        System.out.println("Scenario is Failed = " + scenario.isFailed());

        Thread.sleep(5000);

        // Take a screenshot
        byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        // embed it in the report
        scenario.attach(screenshot, "image/png", scenario.getName());


    }

}
