package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LogFunctions logFunctions = new LogFunctions();



    @Given("User open login page")
    public void user_open_login_page() {

//        Driver.getDriver().manage().window().maximize();


        /*
        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
        Driver.getDriver().get(cxpUrl);
         */

        logFunctions.logPage();

        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Sign in to CX-PLATFORM";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Given: User now on login page");
        System.out.println("Login Page Title is " + actualTitle);

        System.out.println();

    }


    @When("User login as {string} with credentials {string} and {string}")
    public void userLoginAsWithCredentialsAnd(String persona, String userName, String password) throws InterruptedException {

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();


        Thread.sleep(2000);


        String actualTitle = Driver.getDriver().getTitle(); //Actual title

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);

        Thread.sleep(2000);


        dashboardPage.userProfile.click();
        String actualUserEmail = dashboardPage.userEmail.getAttribute("value") ;

        System.out.println("Actual User's Email = " + actualUserEmail);

        Assert.assertEquals("Wrong user logged in", actualUserEmail, userName);

        Thread.sleep(2000);

        dashboardPage.cancelProfile.click();




        System.out.println("When: User ("+persona+") enter credentials and click Submit button");
        System.out.println();


    }


    @Then("User ported to dashboard")
    public void user_ported_to_dashboard() throws InterruptedException {

        Thread.sleep(2000);
        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Then: User succesfully ported to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();


        // Logout
        logFunctions.logOut();

    }









// End
}
