package com.platform.step_definitions;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.CXP_ProOrgDashboard;
import com.platform.pages.DashboardPage;
import com.platform.utilities.ConfigurationReader;
import com.platform.utilities.Driver;
import com.platform.utilities.LogFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ProOrgStepDefinitions {

    CXPLoginPage cxpLoginPage = new CXPLoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    LogFunctions logFunctions = new LogFunctions();
    CXP_ProOrgDashboard proOrgDashboard = new CXP_ProOrgDashboard();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor javascriptExecutor = ((JavascriptExecutor)Driver.getDriver());

    @Given("User go to login page")
    public void userGoToLoginPage() {

        logFunctions.logPage();

        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Sign in to CX-PLATFORM";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Given: User now on login page");
        System.out.println("Login Page Title is " + actualTitle);

        System.out.println();

    }


    @When("Surgeon login to Pro_Org dashboard")
    public void surgeonLoginToPro_OrgDashboard() throws InterruptedException {

        String userName = ConfigurationReader.getProperty("userName_Pro1"); // Username called from Configuration.properties
        String password = ConfigurationReader.getProperty("password_Pro1"); // Password called from Configuration.properties

       logFunctions.logIn(userName,password);


        Thread.sleep(2000);


        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);

        Thread.sleep(2000);


    }


    @Then("Surgeon see My Assessments")
    public void surgeonSeeMyAssessments() throws InterruptedException, AWTException {

        Thread.sleep(2000);


        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = "Vendor Neutral, Enterprise Scale, Digital Surgery Platform to make surgery smarter and safer";

        Assert.assertEquals("Actual title does not match with expected title!", expectedTitle, actualTitle);


        System.out.println("Then: User succesfully ported to CX-P Dashboard");

        System.out.println("Dashboard Title: " + actualTitle);

        System.out.println();


        System.out.println("This is a = " + proOrgDashboard.proorgTitle.getText());
        System.out.println("This user assigned as = " + proOrgDashboard.commentatorTitle.getText());

        System.out.println("User see My Tasks = " + proOrgDashboard.mytasksTitle.isDisplayed());

        System.out.println("User see Create New Case = " + proOrgDashboard.createNewCaseTitle.isDisplayed());



/*
        proOrgDashboard.CXPlogo.click();
        Thread.sleep(2000);

        proOrgDashboard.homeBox.click();
        Thread.sleep(2000);

        proOrgDashboard.patientsBox.click();
        Thread.sleep(2000);

        proOrgDashboard.surgeryBox.click();
        Thread.sleep(2000);

        proOrgDashboard.celearningBox.click();
        Thread.sleep(2000);
 */


        proOrgDashboard.browseFilesBox.click(); //Click browser file(s)

        // Open Robot class to perform actions in Windows

        Robot rb = new Robot();

        rb.delay(2000);

        // Ctrl+C file location
        StringSelection ss = new StringSelection("C:\\Users\\arif.samur\\OneDrive - Caresyntax\\Desktop\\Upload\\doc (4).mp4");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        // CTRL+C
        rb.keyPress(KeyEvent.VK_CONTROL);    // Press on CTRL
        rb.keyPress(KeyEvent.VK_V);          // Press on V
        // CTRL+V
        rb.keyRelease(KeyEvent.VK_CONTROL);  // Release CTRL
        rb.keyRelease(KeyEvent.VK_V);        // Release V
        // Enter
        rb.keyPress(KeyEvent.VK_ENTER);      // Press Enter
        rb.keyRelease(KeyEvent.VK_ENTER);    // Release Enter

        javascriptExecutor.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);

        System.out.println("The name of the file uploading is = " + proOrgDashboard.fileName.getText());

        System.out.println("Case Notes Box Text = " + proOrgDashboard.caseNotes.getText());

        // Logout

        Thread.sleep(3000);
        proOrgDashboard.signoutBox.click();

        Thread.sleep(2000);


        // Log back and resume uploading
        Driver.getDriver().get("https://platform.dev.happysurgeon.com/");

        String userName = ConfigurationReader.getProperty("userName_Pro1"); // Username called from Configuration.properties
        String password = ConfigurationReader.getProperty("password_Pro1"); // Password called from Configuration.properties

        logFunctions.logIn(userName,password);


        Thread.sleep(2000);



        proOrgDashboard.resumeFile.click();

        Thread.sleep(5000);

        // Handle popup




        Thread.sleep(5000);



    }



        /*

        javascriptExecutor.executeScript("arguments[0].value='C:\\Users\\arif.samur\\OneDrive - Caresyntax\\Desktop\\Upload\\QA_M4V.m4v';",cxpLoginPage.userNameBox);
        new Actions(Driver.getDriver()).moveByOffset(860, 34).click().build().perform();
        int getX = proOrgDashboard.signoutBox.getLocation().getX();
        int getY = proOrgDashboard.signoutBox.getLocation().getY();
        System.out.println("X= "+getX+" "+"Y= "+getY);

        int getXA = proOrgDashboard.analyticsBox.getLocation().getX();
        int getYA = proOrgDashboard.analyticsBox.getLocation().getY();
        System.out.println("XA= "+getXA+" "+"YA= "+getYA);

        int getXB = proOrgDashboard.browseFilesBox.getLocation().getX();
        int getYB = proOrgDashboard.browseFilesBox.getLocation().getY();
        System.out.println("XB= "+getXB+" "+"YA= "+getYB);

         */


// End
}
