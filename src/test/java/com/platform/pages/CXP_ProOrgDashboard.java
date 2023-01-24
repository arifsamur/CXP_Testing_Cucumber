package com.platform.pages;

import com.platform.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CXP_ProOrgDashboard {

    public CXP_ProOrgDashboard(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id=\"Ebene_1\"]")
    public WebElement CXPlogo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[1]/ul/li[1]/a")
    public WebElement homeBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[1]/ul/li[2]/a")
    public WebElement patientsBox;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[1]/ul/li[3]/a")
    public WebElement surgeryBox;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/ul/li[4]/a")
    public WebElement analyticsBox;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[1]/ul/li[5]/a")
    public WebElement celearningBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/span/svg")
    public WebElement uploadBox;

    @FindBy(xpath = "(//*[@viewBox=\"0 0 24 24\"])[1]")
    public WebElement signoutBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/h5")
    public WebElement mytasksTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/b[1]")
    public WebElement proorgTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/b[2]")
    public WebElement commentatorTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/h5")
    public WebElement createNewCaseTitle;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div[1]/div/label/div/div")
    public WebElement dropBox;

    @FindBy(xpath = "//u[normalize-space()='Browse']")
    public WebElement browseFilesBox;


    @FindBy(xpath = "(//button[@type=\"button\"])[5]")
    public WebElement resumeFile;

    @FindBy(xpath = "(//button[@type=\"button\"])[4]")
    public WebElement dontResumeFile;

    @FindBy(xpath = "(//button[@type=\"button\"])[1]")
    public WebElement deleteFile;

    @FindBy(xpath = "//div[@class=\"CXP-jss39 \"]")
    public WebElement fileName;

    @FindBy(xpath = "//*[contains(text(),'Notes')]")
    public WebElement caseNotes;

    @FindBy(xpath = "//*[contains(text(),'View')]")
    public WebElement nativeDialog;


    @FindBy(xpath = "/html/body/div[2]/div[3]/div")
    public WebElement filesNotfound;





}
