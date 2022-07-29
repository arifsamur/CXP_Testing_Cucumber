package com.platform.pages;

import com.platform.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {


    public SettingsPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement userNameBox;


    @FindBy(className = "CXP-jss6")
    public WebElement menuLink2;


    @FindBy(xpath = "//li[2]")
    public WebElement userManagement;


    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div/div/ul/li[2]")
    public WebElement general;

    @FindBy(xpath = "//*[@id=\"locale\"]/div")    //  //*[text() = 'Locale']
    public WebElement locale;








// End
}
