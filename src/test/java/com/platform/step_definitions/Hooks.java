package com.platform.step_definitions;

import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import com.platform.utilities.TakeScreenShots;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    LogFunctions logFunctions = new LogFunctions(); //Logfunctions page instance
    TakeScreenShots takeScreenShots = new TakeScreenShots();



    @Before
    public void setUpScenario(){

        System.out.println("-----------------------STARTING------------------------");


        String browser = ConfigurationReader.getProperty("browser"); // Browser is chosen from Configuration.properties

        Driver.getDriver().manage().window().maximize();


        System.out.println("Before all: Test Execution is starting, and "+ browser.toString().toUpperCase() +" browser is being opened");


        System.out.println("-------------------NOW EXECUTION----------------------------");

        System.out.println();
    }

    @After
    public void tearDownScenario(){

        String browser = ConfigurationReader.getProperty("browser"); // Browser is chosen from Configuration.properties
        System.out.println();
        System.out.println("---------------------THE END----------------------------");
        System.out.println("After all: Test(s) executed. Browser "+ browser.toString().toUpperCase() +" is being closed.");

       // logFunctions.logOut();

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

        System.out.println("---- After each step info -----");

        System.out.println("Scenario Name = " + scenario.getName());
        System.out.println("Tag Name(s) = " + scenario.getSourceTagNames());
        System.out.println("Is scenario failed = " + scenario.isFailed());
        System.out.println("------------NOW TAKING A SS----------------");


        Thread.sleep(5000);

        takeScreenShots.takeSS(scenario);


    }




// End
}
