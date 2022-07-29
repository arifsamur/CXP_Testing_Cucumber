package com.platform.utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {


    public void takeSS1() {

        File screen = ((TakesScreenshot)Driver.getDriver() ).getScreenshotAs(OutputType.FILE);
        String path =System.getProperty("user.dir");

        try {
            FileUtils.copyFile(screen, new File(path + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void takeSS(Scenario scenario) throws InterruptedException {

        // Take a screenshot
        byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        // embed it in the report
        scenario.attach(screenshot, "image/png", scenario.getName());
    }



// End
}
