package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    @Given("User open login page")
    public void user_open_login_page() {

        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Sign in to CX-PLATFORM";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Given: User on login page");
        System.out.println("Login Page Title: " + actualTitle);

        System.out.println();
    }

    @When("User login as Surgeon")
    public void user_login_as_surgeon() {


        String userName = ConfigurationReader.getProperty("userName1");

        String password = ConfigurationReader.getProperty("password1");

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();


        System.out.println("When: User (Surgeon) enter credentials and click Submit button");
        System.out.println();


    }



    @Then("User ported to dashboard")
    public void user_ported_to_dashboard() {

        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Then: User succesfully ported to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();



    }


    @And("User see Cases")
    public void user_See_Cases() {


        String actualText = dashboardPage.cases.getText();

        String expectedText = "Cases";

        Assert.assertEquals("Actual text does not match with expected title!", expectedText, actualText);


        System.out.println("And: User succesfully see Cases");

        System.out.println("Actual Webelement Text: " + actualText);

        System.out.println();


    }
}
