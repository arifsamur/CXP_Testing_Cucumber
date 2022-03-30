package com.platform.step_definitions;

import com.platform.pages.DashboardPage;
import com.platform.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingsStepDefinitions {

    DashboardPage dashboardPage = new DashboardPage();


    @When("User navigate to Settings")
    public void userNavigateToSettings() {

        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);

        System.out.println("Step: User on Dashboard page");
        System.out.println("DashboardPage Title: " + actualTitle);

        dashboardPage.menuLink.click();

        dashboardPage.settingsLink.click();



    }

    @Then("User see Create Organization Button")
    public void userSeeCreateOrganizationButton() {
    }
}
