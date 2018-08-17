package com.amazon.qa.sso.android.pages.cookingchannelapp;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CookingChannelAppPage extends BasePage {

    AndroidDriver<WebElement> driver;

    public CookingChannelAppPage(String deviceName, String platformVersion, String platformName) throws Exception {
        super(deviceName, platformVersion, platformName);
        this.driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Cooking Channel']")
    WebElement cookingChannel;

    public WebElement getCookingChannelApp() {
        return cookingChannel;
    }


    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    WebElement cookingChannelSettings;

    public WebElement getCookingChannelSettings() {
        return cookingChannelSettings;
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Optimum']")
    WebElement optimumMVPD;

    public WebElement getOptimumMVPD() {
        return optimumMVPD;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign Out']")
    WebElement cookingChannelSignOutBtn;

    public WebElement getCookingChannelSignOutBtn() {
        return cookingChannelSignOutBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    WebElement cookingChannelSignInBtn;

    public WebElement getCookingChannelSignInBtn() {
        return cookingChannelSignInBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Live TV']")
    WebElement cookingChannelLiveTv;

    public WebElement getCookingChannelLiveTv() {
        return cookingChannelLiveTv;
    }
    @FindBy (xpath = "//android.widget.TextView[@text='Home']")
    WebElement cookingChannelHomeTab;

    public WebElement getCookingChannelHomeTab() {
        return cookingChannelHomeTab;
    }

    public boolean downloadCookingChannelApp() throws InterruptedException {
        Reporter.log("-----[CookingChannelApp] Downloading process is starting...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getCookingChannelApp());
        Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
        try {
            if (getCookingChannelApp().isDisplayed()) {
                clickAndEnter(getCookingChannelApp());
                Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
            }
        } catch (NoSuchElementException e) {

        }
        elementIsVisibleAndClickable(downloadBtn()).click();
        Reporter.log("-----[CookingChannelApp] Download button is clicked", true);
        Reporter.log("-----[CookingChannelApp] CookingChannel app is installing...", true);
        clickOnPlayBtn(getCookingChannelApp());
        Reporter.log("-----[CookingChannelApp] Play button is clicked", true);
        if(getCookingChannelHomeTab().isDisplayed() == true){
            scrollUp(1);
        }
        return getCookingChannelSettings().isDisplayed();
    }

    public boolean isCookingChannelSignedIn() throws InterruptedException {
        if (downloadCookingChannelApp()) {
            Reporter.log("-----[CookingChannelApp] isCookingChannelSignedIn test is running...", true);
            scrollRight(4);
            waitForScreenDownloaded(2000);
            try {
                if (getOptimumMVPD().isDisplayed()) {
                    clickAndEnter(getOptimumMVPD());
                }
            } catch (NoSuchElementException e) {
                if(elementIsVisibleAndClickable(getCookingChannelHomeTab()).isDisplayed() == true){
                    scrollUp(1);
                    scrollRight(4);
                }
                clickAndEnter(getOptimumMVPD());
            }
            Reporter.log("-----[CookingChannelApp] Optimum MVPD is selected", true);
            waitForScreenDownloaded(1000);
            //optimumUserTextField().clear();
            optimumUserTextField().sendKeys(postOptimumUsername());
            Reporter.log("-----[CookingChannelApp] Optimum username is provided", true);
            driver.hideKeyboard();
            //optimumPasswordTextField().clear();
            optimumPasswordTextField().sendKeys(postOptimumPassword());
            Reporter.log("-----[CookingChannelApp] Optimum password is provided", true);
            driver.hideKeyboard();
            click(optimumSignInBtn());
            Reporter.log("-----[CookingChannelApp] Optimum Sign-In button is clicked", true);
            waitForScreenDownloaded(3000);
            Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully singedIn", (getCookingChannelSignOutBtn().isDisplayed()));
            return getCookingChannelSignOutBtn().isDisplayed();

        } else return false;

    }

    public boolean isCookingChannelSignedOut() throws InterruptedException {
        Reporter.log("-----[CookingChannelApp] isCookingChannelSignOut test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getCookingChannelApp());
        Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
        try {
            if (getCookingChannelApp().isDisplayed()) {
                clickAndEnter(getCookingChannelApp());
                Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
            }
        } catch (NoSuchElementException e) {

        }
        try{
            if(getCookingChannelSignOutBtn().isDisplayed()){
                clickAndEnter(getCookingChannelSignOutBtn());
                Reporter.log("-----[CookingChannelApp] SignedOut button is clicked", true);
                Reporter.log("-----[CookingChannel App] CookingChannel app is successfully signedOut", getCookingChannelSignInBtn().isDisplayed());
            }
            return getCookingChannelSignInBtn().isDisplayed();
        }catch (NoSuchElementException e){
            if(elementIsVisibleAndClickable(getCookingChannelHomeTab()).isDisplayed()){
                scrollUp(1);
                scrollRight(4);
                clickAndEnter(getCookingChannelSignOutBtn());
                Reporter.log("-----[CookingChannelApp] SignedOut button is clicked", true);
                Reporter.log("-----[CookingChannel App] CookingChannel app is successfully signedOut", getCookingChannelSignInBtn().isDisplayed());
            }
            return getCookingChannelSignInBtn().isDisplayed();
        }
    }

    public boolean isCookingChannelAutoSignedIn_withDownloading() throws InterruptedException {
        Reporter.log("-----[CookingChannelApp] isCookingChannelSignedIn_withDownloading test is running...", true);
        if (downloadCookingChannelApp()) {
            try {
                if (getCookingChannelHomeTab().isDisplayed()) {
                    scrollUp(1);
                    scrollRight(4);
                    Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully auto signedIn", getCookingChannelSignOutBtn().isDisplayed());
                }else {
                    scrollUp(1);
                    scrollRight(4);
                }
                return getCookingChannelSignOutBtn().isDisplayed();
            } catch (NoSuchElementException e) {
                if (getCookingChannelSignOutBtn().isDisplayed()) {
                    Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully auto signedIn", getCookingChannelSignOutBtn().isDisplayed());
                }
                return getCookingChannelSignOutBtn().isDisplayed();
            }

        }
        return true;

    }

    public boolean isCookingChannelAutoSingedOut() throws InterruptedException {
        Reporter.log("-----[CookingChannelApp] isCookingChannelAutoSignedOut test is running", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getCookingChannelApp());
        waitForScreenDownloaded(3000);
        try {
            if (getCookingChannelApp().isDisplayed()) {
                clickAndEnter(getCookingChannelApp());
                Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
            }
        } catch (NoSuchElementException e) {
        }
        try{
            if(elementIsVisibleAndClickable(getCookingChannelHomeTab()).isDisplayed()){
                scrollUp(1);
                scrollRight(4);
                Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully auto signedOut", getCookingChannelSignInBtn().isDisplayed());
            }
            return getCookingChannelSignInBtn().isDisplayed();
        }catch (NoSuchElementException e){
            if(getCookingChannelSignInBtn().isDisplayed()){
                Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully auto signedOut", getCookingChannelSignInBtn().isDisplayed());
            }
            return getCookingChannelSignInBtn().isDisplayed();
        }
    }

    public boolean isCookingChannelAutoSignedIn() throws InterruptedException {
        Reporter.log("-----[CookingChannelApp] isCookingChannelAutoSignedIn test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getCookingChannelApp());
        Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
        try {
            if (getCookingChannelApp().isDisplayed()) {
                clickAndEnter(getCookingChannelApp());
                Reporter.log("-----[CookingChannelApp] CookingChannel app is selected", true);
            }
        } catch (NoSuchElementException e) {

        }
            try {
            waitForScreenDownloaded(5000);
                if (getCookingChannelHomeTab().isDisplayed()) {
                    scrollUp(1);
                    scrollRight(4);
                    Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully auto signedIn", getCookingChannelSignOutBtn().isDisplayed());
                }
                return getCookingChannelSignOutBtn().isDisplayed();
            } catch (NoSuchElementException e) {
                if (getCookingChannelSignOutBtn().isDisplayed()) {
                    Reporter.log("-----[CookingChannelApp] CookingChannel app is successfully auto signedIn", getCookingChannelSignOutBtn().isDisplayed());
                }
                return getCookingChannelSignOutBtn().isDisplayed();
            }
    }
}

