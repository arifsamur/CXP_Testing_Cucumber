package com.platform.utilities;

import com.platform.pages.CXPLoginPage;
import com.platform.pages.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LogFunctions {

    DashboardPage dashboardPage = new DashboardPage();
    CXPLoginPage cxpLoginPage = new CXPLoginPage();


    public void logOut() {
        System.out.println("----------------------------");
        System.out.println("Now logging out...");

    // Logout
        dashboardPage.menuLink.click(); // Click main menu

    // Create a list of menu items
    List<WebElement> menuList = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'-1')]//li"));

   //     System.out.println("# of items in the main menu is: "+menuList.size());

        for (int i=0;i<menuList.size();i++)
    {
     //   System.out.println(menuList.get(i).getAccessibleName());
        if(menuList.get(i).getAccessibleName().contains("LOG")) // Click SETTINGS
        {
            menuList.get(i).click();
            break;
        }
    }

    }



    public void logIn(String userName, String password){
//        Driver.getDriver().manage().window().maximize();

        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
//        Driver.getDriver().get(cxpUrl);
/*
        String userName = ConfigurationReader.getProperty("surgeon"); // Username called from Configuration.properties
        String password = ConfigurationReader.getProperty("sur_pass"); // Password called from Configuration.properties

 */

        cxpLoginPage.userNameBox.sendKeys(userName);
        cxpLoginPage.passwordBox.sendKeys(password);
        cxpLoginPage.loginButton.click();

    }



    public void logPage(){

       // String browser = ConfigurationReader.getProperty("browser"); // Browser is chosen from Configuration.properties

       // Driver.getDriver().manage().window().maximize();

        // Call CXP website link from ConfigurationReader page. URL String name cxpUrl
        String cxpUrl = ConfigurationReader.getProperty("CXP_url");

        // Open CXP URL
        Driver.getDriver().get(cxpUrl);


    }









// End
}

