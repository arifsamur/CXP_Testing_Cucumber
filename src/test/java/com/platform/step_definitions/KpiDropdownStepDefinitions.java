package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class KpiDropdownStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LogFunctions logFunctions = new LogFunctions();


    @Given("User navigate to login page")
    public void userLogin_to_Dashboard() {

        /*
        Driver.getDriver().manage().window().maximize();

        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
        Driver.getDriver().get(cxpUrl);

         */

        logFunctions.logPage();

        String actualTitle = Driver.getDriver().getTitle(); // String actual title

        String expectedTitle = "Sign in to CX-PLATFORM";

        // Assert actual title is equal to expected title
        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        String userName = ConfigurationReader.getProperty("userName1");

        String password = ConfigurationReader.getProperty("password1");

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();

        System.out.println("When: User navigate to login page, and enter credentials and click Submit button");
        System.out.println("Dashboard title is: "+Driver.getDriver().getTitle());


        System.out.println();


    }




    @When("User deselect all KPIs")
    public void userDeselectAllKPIs()  {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));

        dashboardPage.kpiDropdown.click(); //Click KPI Dropdown

        // Create a list of KPIs
        List<WebElement> kpiList = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'1')]//span[2]"));

        System.out.println("# of items in the KPI dropdown is: "+kpiList.size());

        Integer j = 1;

        for (int i=0;i<kpiList.size();i++)
        {

                System.out.println("KPI item no: "+(j++)+" "+"KPI name: "+kpiList.get(i).getText());


        }

        /*

        kpiList.get(0).click();
        System.out.println(kpiList.get(0).getTagName());

        for (int k=0;k<kpiList.size();k++) {

            if (kpiList.get(k).getText().contains("Readmission")){
                kpiList.get(k).click();
            }
        }



         */

    }

    @Then("User see no KPI")
    public void userSeeNoKPI() {

        List<WebElement> kpiBoxLoaded = Driver.getDriver().findElements(By.xpath("//a[@data-testid]"));

        System.out.println("# of items in the KPI dropdown is: "+kpiBoxLoaded.size());


        for (int i=0;i<kpiBoxLoaded.size();i++)
        {

            System.out.println(kpiBoxLoaded.get(i).getText());

        }


        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Step: User succesfully login to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();

        logFunctions.logOut();

    }


// End
}
