package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TrialStepdefinitions {
    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LogFunctions logFunctions = new LogFunctions();
   // SettingsPage settingsPage = new SettingsPage();

    @Given("User login to dashboard")
    public void user_Login_to_Dashboard() throws InterruptedException {


        logFunctions.logPage();

        String actualTitle = Driver.getDriver().getTitle(); // String actual title

        String expectedTitle = "Sign in to CX-PLATFORM";

        // Assert actual title is equal to expected title
        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        String userName = ConfigurationReader.getProperty("userName1");

        String password = ConfigurationReader.getProperty("password1");

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);

        Thread.sleep(2000);

        cxpLoginPage.loginButton.click();

        Thread.sleep(2000);

        System.out.println("When: User navigate to login page, and enter credentials and click Submit button");
        System.out.println("Dashboard title is: "+Driver.getDriver().getTitle());


        System.out.println();


    }



    @Then("User see dashboard")
    public void user_see_dashboard() throws InterruptedException {

       Thread.sleep(2000);
        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Step: User successfully login to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();


        dashboardPage.userProfile.click();
        String actualUserEmail = dashboardPage.userEmail.getAttribute("value") ;

        System.out.println("Actual User Email = " + actualUserEmail);

        Assert.assertEquals("Wrong user logged in", actualUserEmail, ConfigurationReader.getProperty("userName1"));

        Thread.sleep(2000);


        String profileFirst = dashboardPage.profileFirstName.getAttribute("value"); // First Name

        String profileLast = dashboardPage.profileLastName.getAttribute("value"); // Last Name

        System.out.println("Profile's Name = " + profileFirst + " " + profileLast);

        String profileHeader = dashboardPage.profileNameHeader.getText();

        System.out.println("Profile Header Name = " + profileHeader);

        Thread.sleep(2000);


        dashboardPage.cancelProfile.click();

        logFunctions.logOut();

    }





// End
}
