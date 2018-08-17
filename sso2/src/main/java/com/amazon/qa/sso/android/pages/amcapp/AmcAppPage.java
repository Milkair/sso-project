package com.amazon.qa.sso.android.pages.amcapp;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AmcAppPage extends BasePage {


    AndroidDriver<WebElement> driver;

    public AmcAppPage(String deviceName, String platformVersion, String platformName) throws Exception {
        super(deviceName, platformVersion, platformName);
        this.driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }






    @FindBy(xpath = "//android.widget.ImageView[@content-desc='AMC']")
    WebElement amcApp;

    public WebElement getAmcApp() {
        return amcApp;
    }








    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    WebElement amcSettingsBtn;

    public WebElement getAmcSettingsBtn() {
        return amcSettingsBtn;
    }







    @FindBy(xpath = "//android.widget.TextView[@text='Choose your TV Provider' or @text='CHOOSE YOUR TV PROVIDER']")
    WebElement amcChooseYourProviderByn;

    public WebElement getAmcChooseYourProviderBtn() {
        return amcChooseYourProviderByn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign In' or @text='SIGN IN']")
    WebElement amcSignInIcon;

    public WebElement getAmcSignInIcon() {
        return amcSignInIcon;
    }

    @FindBy(xpath = "//android.widget.FrameLayout[@index='4']")
    WebElement optimumIndex1;

    public WebElement getOptimumIndex1() {
        return optimumIndex1;
    }

    @FindBy (xpath = "//android.widget.TextView[@text='Sign Out' or @text='SIGN OUT']")
    WebElement amcSignOutBtn;

    public WebElement getAmcSignOutBtn() {
        return amcSignOutBtn;
    }

    public boolean downloadAmcApp() throws InterruptedException {
        Reporter.log("-----[AmcApp] Downloading process is starting...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getAmcApp());
        Reporter.log("-----[AmcApp] Amc app is selected", true);

        elementIsVisibleAndClickable(downloadBtn()).click();

        Reporter.log("-----[AmcApp] Download button is clicked", true);
        Reporter.log("-----[AmcApp] Amc app is installing...", true);
        clickOnPlayBtn(getAmcApp());
        Reporter.log("-----[AmcApp] Play button is clicked", true);
        clickOnScreenSizeBtn();
        waitForScreenDownloaded(5000);
        try{
            if(playBtn().isDisplayed()){
                clickAndEnter(playBtn());
            }
        }catch (NoSuchElementException e){

        }
        waitForScreenDownloaded(5000);
        try{
            if(getAmcSettingsBtn().isDisplayed()){
                Reporter.log("-----[AmcApp] Settings button is displayed");
            }

        }catch (NoSuchElementException e){
            scrollUp(1);
        }

        return getAmcSettingsBtn().isDisplayed();

    }



    public boolean isAmcSignedIn_withDownloading() throws InterruptedException {
        if (downloadAmcApp()) {
            Reporter.log("-----[AmcApp] isAmcSignedIn test is running...", true);
            try {
                if (elementIsVisibleAndClickable(getAmcSettingsBtn()).isDisplayed()) {
                    clickAndEnter(getAmcSettingsBtn());
                    Reporter.log("-----[AmcApp] Settings button is clicked", true);
                }
            } catch (NoSuchElementException e) {

            }
            try {
                if (elementIsVisibleAndClickable(getAmcChooseYourProviderBtn()).isDisplayed()) {
                    clickAndEnter(getAmcChooseYourProviderBtn());
                    Reporter.log("-----[AmcApp] Choose Your Provider button is clicked", true);
                }
            } catch (NoSuchElementException e) {

            }
            try {
                if (elementIsVisibleAndClickable(getOptimumIndex1()).isDisplayed()) {
                    clickAndEnter(getOptimumIndex1());
                    Reporter.log("-----[AmcApp] Optimum MVPD is selected", true);
                }
            } catch (NoSuchElementException e) {

            }
            waitForScreenDownloaded(1000);
            optimumUserTextField().sendKeys(postOptimumUsername());
            Reporter.log("-----[AmclApp] Optimum username is provided", true);
            //driver.hideKeyboard();
            optimumPasswordTextField().sendKeys(postOptimumPassword());
            Reporter.log("-----[AmcApp] Optimum password is provided", true);
            //driver.hideKeyboard();
            click(optimumSignInBtn());
            Reporter.log("-----[AmcApp] Optimum Sign-In button is clicked", true);
            waitForScreenDownloaded(3000);
            Reporter.log("-----[AmcApp] Amc app is successfully singedIn", (getAmcSignOutBtn().isDisplayed()));

        }
        return getAmcSignOutBtn().isDisplayed();
    }

    public boolean isAmcSignedOut() throws InterruptedException {
        Reporter.log("-----[AmcApp] isAmcSignOut test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getAmcApp());
        Reporter.log("-----[AmcApp] Amc app is selected", true);

        try{
            if(getAmcSignOutBtn().isDisplayed()){
                clickAndEnter(getAmcSignOutBtn());
                Reporter.log("-----[AmcApp] SignedOut button is clicked", true);
                Reporter.log("-----[AmcApp] Amc app is successfully signedOut", getAmcSignInIcon().isDisplayed());
            }
            return getAmcSignInIcon().isDisplayed();
        }catch (NoSuchElementException e){
            if(getAmcSettingsBtn().isDisplayed()){
                clickAndEnter(getAmcSettingsBtn());
                clickAndEnter(getAmcSignOutBtn());
                Reporter.log("-----[AmcApp] SignedOut button is clicked", true);
                Reporter.log("-----[AmcApp] Amc app is successfully signedOut", getAmcSignInIcon().isDisplayed());
            }
            return getAmcSignInIcon().isDisplayed();
        }

    }
    public boolean isAmcAutoSignedIn() throws InterruptedException {
        Reporter.log("-----[AmcApp] isAmcAutoSignIn test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getAmcApp());
        Reporter.log("-----[AmcApp] Amc app is selected", true);
        waitForScreenDownloaded(3000);
        try{
            if(getAmcSignOutBtn().isDisplayed()){
                Reporter.log("-----[AmcApp] Amc app is successfully signedIn", getAmcSignOutBtn().isDisplayed());
            }
            return getAmcSignOutBtn().isDisplayed();
        }catch (NoSuchElementException e){
            if(getAmcSettingsBtn().isDisplayed()){
                clickAndEnter(getAmcSettingsBtn());
                Reporter.log("-----[AmcApp] Amc app is successfully signedIn", getAmcSignOutBtn().isDisplayed());
            }
            return getAmcSignOutBtn().isDisplayed();
        }
    }

    public boolean isAmcAutoSingedOut() throws InterruptedException {
        Reporter.log("-----[AmcApp] isAmcAutoSignedOut test is running", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getAmcApp());
        Reporter.log("-----[AmcApp] Amc app is selected", true);
        waitForScreenDownloaded(3000);
        try{
            if(getAmcSignInIcon().isDisplayed()){
                Reporter.log("-----[AmcApp] Amc app is successfully signedOut", getAmcSignInIcon().isDisplayed());

            }
            return getAmcSignInIcon().isDisplayed();
        }catch (NoSuchElementException e){
            if(getAmcSettingsBtn().isDisplayed()){
                clickAndEnter(getAmcSettingsBtn());
                Reporter.log("-----[AmcApp] Amc app is successfully signedOut", getAmcSignInIcon().isDisplayed());

            }
            return getAmcSignInIcon().isDisplayed();
        }






    }























































}
