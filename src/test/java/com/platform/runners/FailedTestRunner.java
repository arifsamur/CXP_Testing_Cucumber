package com.platform.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"html:target/cucumber-report.html", "json:target/cucumber-report.json", "rerun:target/rerun.txt"},
        features = "@target/rerun.txt",
        glue     = "com/platform/step_definitions"
)


public class FailedTestRunner {
}
