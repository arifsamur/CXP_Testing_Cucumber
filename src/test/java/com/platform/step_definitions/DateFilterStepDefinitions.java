package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import com.platform.utilities.TakeScreenShots;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DateFilterStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LogFunctions logFunctions = new LogFunctions();
    TakeScreenShots takeScreenShots = new TakeScreenShots();



    @Given("User login to CXP Dashboard")
    public void user_login_to_cxp_dashboard() throws InterruptedException {

        logFunctions.logPage(); //Navigate to CXP Login page

        cxpLoginPage.userNameBox.sendKeys("arif_friend@cxi.com");  // Enter username
        cxpLoginPage.passwordBox.sendKeys("Welcome1!"); // Enter password
        cxpLoginPage.loginButton.click();


        System.out.println("Given: User now on login page");

    }


    @When("User click dateFilter")
    public void user_click_date_filter() throws InterruptedException {


        Thread.sleep(2000);

        dashboardPage.dateFilter.click();

        System.out.println("Date Filter: " + dashboardPage.dateFilter.getText());

        dashboardPage.periodContainer.click();

        Thread.sleep(2000);

        List<WebElement> periodList = Driver.getDriver().findElements(By.xpath("(//div[contains(@class, 'menu')])//div[contains (@id, 'react-select-3-option')]"));


      //  Driver.getDriver().findElement(By.xpath("(//div[contains(@class, 'menu')])//*[contains (text(), 'Last Quarter')]")).click();


        System.out.println("periodList.size() = " + periodList.size());


        for (int i=0;i<periodList.size();i++)
        {
            System.out.println(periodList.get(i).getText());

            if(periodList.get(i).getText().toLowerCase().contains("one year ago")){
                periodList.get(i).click();
            }
        }



        System.out.println("---------------------");

        Thread.sleep(2000);

        dashboardPage.primeTime.click();

        System.out.println("Prime Time selected");

        Thread.sleep(2000);

        dashboardPage.weekDays.click();

        System.out.println("Week Days Selected");

        Thread.sleep(5000);

        dashboardPage.applyShow.click();  // Click to Show results



    }



    @Then("User see filter")
    public void user_see_filter() throws InterruptedException {

        System.out.println("When Filter is now used!");

        Thread.sleep(2000);


        logFunctions.logOut();
    }



// End
}
