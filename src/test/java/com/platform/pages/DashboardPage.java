package com.platform.pages;

import com.platform.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {


    SettingsPage settingsPage = new SettingsPage(); // Settings page instance


    public DashboardPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


    // Menu items

    public void menuHome(){

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

    }




    public void menuCXI(){

        menuLink.click(); // Click main menu

        // Create a list of menu items
        List<WebElement> menuList = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'-1')]//li"));

        System.out.println("# of items in the main menu"+menuList.size());

        // Navigating to CXI

        String mainHandle= Driver.getDriver().getWindowHandle();

        for (int i=0;i<menuList.size();i++)
        {
            System.out.println(menuList.get(i).getAccessibleName());
            if(menuList.get(i).getAccessibleName().contains("Insight"))
            {
                menuList.get(i).click(); // Click CXI
                break;
            }

        }



    }





    public void menuCXA(){

        menuLink.click(); // Click main menu

        // Create a list of menu items
        List<WebElement> menuList = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'-1')]//li"));

        System.out.println("# of items in the main menu"+menuList.size());

        // Navigating to CXA


        for (int i=0;i<menuList.size();i++)
        {
            System.out.println(menuList.get(i).getAccessibleName());
            if(menuList.get(i).getAccessibleName().contains("cxAdvance"))
            {
                menuList.get(i).click(); // Click CXA
                break;
            }

        }



    }





    public void menuSettings(){

        // Navigate to Settings

        menuLink.click(); // Click main menu
        List<WebElement> menuList2 = Driver.getDriver().findElements(By.xpath("//ul[contains(@tabindex,'-1')]//li"));


        for (int i=0;i<menuList2.size();i++)
        {
            System.out.println(menuList2.get(i).getAccessibleName());
            if(menuList2.get(i).getAccessibleName().contains("SET"))
            {
                menuList2.get(i).click(); // Click Settings
                break;
            }

        }


    }







    @FindBy(className = "CXP-jss6")
    public WebElement menuLink;

    @FindBy(xpath = "//*[@id=\"menu-list-grow\"]/a[5]/li")
    public WebElement settingsLink;

    @FindBy(xpath = "//*[@id=\"menu-list-grow\"]/a[2]/li")
    public WebElement cxaLink;

    @FindBy(xpath = "//*[@id=\"menu-list-grow\"]/a[3]/li")
    public WebElement cxcLink;

    @FindBy(xpath = "//*[@id=\"menu-list-grow\"]/a[4]/li")
    public WebElement cxiLink;

    @FindBy(xpath = "//*[@id=\"menu-list-grow\"]/li")
    public WebElement logoutLink;


    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[4]/h5")
    public WebElement cases;

    /*
    @FindBy (xpath = "//*[@data-testid='kpi-dropdown']")
    public WebElement kpiDropdown;

    @FindBy(xpath = "//ul[contains(@tabindex,'1')]//span[2]")
    public WebElement kpiDropdown;

     */


    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[1]/button[2]/span")
    public WebElement kpiDropdown;


    @FindBy(xpath = "//button [@data-testid='calendar-icon-button']")
    public WebElement dateFilter;

    @FindBy(xpath = "//*[@data-testid='periodSelect']")
    public WebElement periodContainer;

    @FindBy (xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[1]/div/div/div[2]/div[3]/div/div/button/span")
    public WebElement applyShow;


    @FindBy (xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[1]/div/div/div[2]/div[2]/div[2]/div/div[3]/button/span")
    public WebElement primeTime;

    @FindBy (xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[1]/div/div/div[2]/div[2]/div[3]/div/div[3]/button/span")
    public WebElement hours;

    @FindBy (xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[1]/div/div/div[2]/div[2]/div[4]/div/div[3]/div[1]/button/span")
    public WebElement weekDays;

    @FindBy (xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[1]/div/div/div[2]/div[2]/div[4]/div/div[3]/div[1]/button/span")
    public WebElement allDays;

    @FindBy (xpath = "//img [@alt='profile']")
    public WebElement userProfile;

    @FindBy (xpath = "//input [@name='email']")
    public WebElement userEmail;

    @FindBy (xpath = "//*[contains(text(),'Cancel')]")
    public WebElement cancelProfile;


    @FindBy (xpath = "//input [@data-testid=\"firstName\"]")
    public WebElement profileFirstName;

    @FindBy (xpath = "//input [@data-testid=\"lastName\"]")
    public WebElement profileLastName;

    @FindBy (xpath = "(//div//p)[2]")
    public WebElement profileNameHeader;




// End
}
