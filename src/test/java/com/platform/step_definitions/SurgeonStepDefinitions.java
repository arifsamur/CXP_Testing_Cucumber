package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import com.platform.pages.SettingsPage;
import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Set;

public class SurgeonStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage(); // Login page instance
    DashboardPage dashboardPage = new DashboardPage(); // Dashboard page instance
    SettingsPage settingsPage = new SettingsPage(); // Settings page instance
    LogFunctions logFunctions = new LogFunctions(); //Logfunctions page instance

    @Given("Surgeon open login page")
    public void surgeon_open_login_page() {

        Driver.getDriver().manage().window().maximize();

        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
        Driver.getDriver().get(cxpUrl);


        String actualTitle = Driver.getDriver().getTitle(); // String actual title

        String expectedTitle = "Sign in to CX-PLATFORM";

        // Assert actual title is equal to expected title
        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Given: User now on login page");
        System.out.println("Login Page Title is " + actualTitle);

        System.out.println();
    }




    @When("Surgeon login to dashboard")
    public void surgeonLoginToDashboard() {

        Driver.getDriver().manage().window().maximize();

        logFunctions.logIn(); // Surgeon persona logs in

        /*
        String userName = ConfigurationReader.getProperty("surgeon"); // Username called from Configuration.properties
        String password = ConfigurationReader.getProperty("sur_pass"); // Password called from Configuration.properties

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();


         */

        System.out.println("When: Surgeon enter credentials and click Submit button");
        System.out.println();


    }



    @Then("Surgeon see main menu")
    public void surgeonSeeMainMenu(Scenario scenario) throws InterruptedException {

        Driver.getDriver().manage().window().maximize();

        String actualTitle = Driver.getDriver().getTitle(); // Actual title

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        // Assert title
        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);



        System.out.println("Then: User succesfully ported to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();

        String mainHandle= Driver.getDriver().getWindowHandle();

        dashboardPage.menuCXI();

        String cxiHandle= Driver.getDriver().getWindowHandle();

        Driver.getDriver().switchTo().window(mainHandle); // Back to dashboard


        // Navigating to CXA


        dashboardPage.menuCXA();

        String cxaHandle= Driver.getDriver().getWindowHandle();

        // Take a screenshot
        byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        // embed it in the report
        scenario.attach(screenshot, "image/png", scenario.getName());



        Driver.getDriver().switchTo().window(mainHandle); // Back to dashboard


        System.out.println("----------");
        System.out.println("Main handle: "+mainHandle+" CXI handle: "+cxiHandle+" CXA handle: "+cxaHandle);
        System.out.println("----------");

        Set<String> tabs = Driver.getDriver().getWindowHandles();

        System.out.println("Windowhandles Loop Order:");
        for(String each : tabs){
            Driver.getDriver().switchTo().window(each);
            System.out.println(Driver.getDriver().getTitle());
            System.out.println(Driver.getDriver().getWindowHandle());

        }
        String[] tabList = tabs.toArray(new String[tabs.size()]);
        String cxiHandle2 = Driver.getDriver().switchTo().window(tabList[1]).getWindowHandle();
        String cxaHandle2 = Driver.getDriver().switchTo().window(tabList[2]).getWindowHandle();



        Driver.getDriver().switchTo().window(cxaHandle2);
        System.out.println(Driver.getDriver().getTitle());

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");

        Driver.getDriver().switchTo().window(cxiHandle2);
        System.out.println(Driver.getDriver().getTitle());

        Assert.assertEquals(Driver.getDriver().getTitle(),"CX-INSIGHT");


        Driver.getDriver().switchTo().window(mainHandle);

        dashboardPage.menuSettings();

        // Click General

        settingsPage.general.click();
        System.out.println("User ported to General");

        // User see Locale
        settingsPage.locale.isDisplayed();

        System.out.println("User see Locale dropdown");
        System.out.println(settingsPage.locale.getAccessibleName());




    }




    @And("Surgeon see cases")
    public void surgeonSeeCases() {

        Driver.getDriver().manage().window().maximize();

        dashboardPage.menuHome();

        /*
        settingsPage.menuLink2.click(); // Click main menu

        // Create a list of menu items
        List<WebElement> menuList = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'-1')]//li"));

        // Navigating to Dashboard

        for (int i=0;i<menuList.size();i++)
        {
            System.out.println(menuList.get(i).getAccessibleName());
            if(menuList.get(i).getAccessibleName().contains("HOME"))
            {
                menuList.get(i).click(); // Click Home
                break;
            }

        }

         */



        //System.out.println("dashboardPage.cases.getLocation().toString() = " + dashboardPage.cases.getLocation().toString());

        String actualText = dashboardPage.cases.getText();

        String expectedText = "Cases";

        Assert.assertEquals("Actual text does not match with expected title!", expectedText, actualText);

        System.out.println("And: User succesfully see Cases");

        System.out.println("Actual Webelement Text: " + actualText);

        dashboardPage.menuLink.click(); // Click main menu


        System.out.println();

    }


// End
}
