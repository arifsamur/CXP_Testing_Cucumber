package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class KpiDropdownStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
/*

    @Given("User open login page")
    public void user_login_to_Dashboard() {

        String userName = ConfigurationReader.getProperty("userName1");

        String password = ConfigurationReader.getProperty("password1");

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();


        System.out.println("Step: User (Surgeon) enter credentials and click Submit button");
        System.out.println();

    }


 */

    @When("User deselect all KPIs")
    public void userDeselectAllKPIs() {

        Select select = new Select(dashboardPage.kpiDropdown);

        select.deselectAll();

        System.out.println();

    }

    @Then("User see no KPI")
    public void userSeeNoKPI() {
        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Step: User succesfully login to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();

    }


// End
}
