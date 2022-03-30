package com.platform.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"html:target/cucumber-report.html", "json:target/cucumber-report.json", "rerun:target/rerun.txt"},
    features = "src/test/resources/features",
    glue = "com/platform/step_definitions",
    dryRun = false,
    tags = "@Surgeon"   //"@ or @"
)
public class CukesRunner {

}
