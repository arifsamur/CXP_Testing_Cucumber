package com.platform.pages;

import com.platform.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CXPLoginPage {

    public CXPLoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement userNameBox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"kc-login\"]")
    public WebElement loginButton;

}
