package com.platform.pages;

import com.platform.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(className = "CXP-jss6")
    public WebElement menuLink;

    @FindBy(xpath = "//a [@href='/settings']")
    public WebElement settingsLink;


    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div/main/div[4]/h5")
    public WebElement cases;

    @FindBy (xpath = "//*[@data-testid='kpi-dropdown']")
    public WebElement kpiDropdown;



}
