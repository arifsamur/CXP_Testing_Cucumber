package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.pages.SettingsPage;
import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class LocaleStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    SettingsPage settingsPage = new SettingsPage();
    LogFunctions logFunctions = new LogFunctions();




    @Given("User login to CXP")
    public void userLoginToCXP() {

        Driver.getDriver().manage().window().maximize();

        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
        Driver.getDriver().get(cxpUrl);


        String actualTitle = Driver.getDriver().getTitle(); // String actual title

        String expectedTitle = "Sign in to CX-PLATFORM";

        // Assert actual title is equal to expected title
        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        String userName = ConfigurationReader.getProperty("userName1");

        String password = ConfigurationReader.getProperty("password1");

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();

        System.out.println("When: User enter credentials and click Submit button");
        System.out.println("Dashboard title is: "+Driver.getDriver().getTitle());


        System.out.println();


    }


    @When("User navigate to Settings")
    public void userNavigateToSettings() {

        dashboardPage.menuLink.click(); // Click main menu
        dashboardPage.settingsLink.click(); // Navigate to Settings


        /*
        // Create a list of menu items
        List<WebElement> menuList = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'-1')]//li"));

        System.out.println("# of items in the main menu is: "+menuList.size());

        for (int i=0;i<menuList.size();i++)
        {
            System.out.println(menuList.get(i).getAccessibleName());
            if(menuList.get(i).getAccessibleName().contains("settings")) // Click SETTINGS
            {
                menuList.get(i).click();
                break;
            }

        }

         */

    }



    @Then("User click General")
    public void userClickGeneral() {

        settingsPage.general.click();
        System.out.println("User ported to General");

    }

    @And("User see Locale")
    public void userSeeLocale() {


        settingsPage.locale.isDisplayed();

        System.out.println("User see Locale dropdown");
        System.out.println("Text of Locale is "+settingsPage.locale.getText());

        settingsPage.locale.click();




        List<WebElement> localeDropdown = Driver.getDriver().findElements(By.xpath("//*[@class=\" css-1hwfws3\"]"));

        System.out.println("Number of Locale elements is "+localeDropdown.size());


        for (int i=0;i<localeDropdown.size();i++)
        {
            System.out.println(localeDropdown.get(i).getText()+" (index "+i+")");


            if(localeDropdown.get(i).getText().toLowerCase(Locale.ROOT).contains("us")) // Select Locale
            {
                localeDropdown.get(i).click();

               // break;
            }

        }




        System.out.println("----------------------------");

        System.out.println("Dropdown: "+localeDropdown.get(0).getText());


        logFunctions.logOut();

// End
    }



// End
}
