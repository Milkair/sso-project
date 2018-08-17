package com.amazon.qa.sso.android.pages.hallmarkapp;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HallmarkAppPage extends BasePage {

    AndroidDriver<WebElement> driver;

    public HallmarkAppPage(String deviceName, String platformVersion, String platformName) throws Exception {
        super(deviceName, platformVersion, platformName);
        this.driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Hallmark Channel Everywhere for Fire TV']")
    WebElement hallmarkApp;

    public WebElement getHallmarkApp() {
        return hallmarkApp;
    }

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.hallmarkchannel.tv:id/main_logo']")
    WebElement hallmarkLogo;

    public WebElement getHhallmarkLogo() {
        return hallmarkLogo;
    }


    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    WebElement hallmarkLogInBtn;

    public WebElement getHallmarkLogInBtn() {
        return hallmarkLogInBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement hallmarkLogOutBtn;

    public WebElement getHallmarkLogOutBtn() {
        return hallmarkLogOutBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='SEARCH' or @text='Search']")
    WebElement hallmarkSearchMVPD;

    public WebElement getHallmarkSearchMVPD() {
        return hallmarkSearchMVPD;
    }

    @FindBy(xpath = "//android.widget.EditText[contains(@text, 'looking')]")
    WebElement hallmarkSearchField;

    public void postOptimum() {
        driver.hideKeyboard();
        hallmarkSearchField.sendKeys("Optimum");
    }


    @FindBy(xpath = "//android.widget.TextView[@text='Optimum' or @text='OPTIMUM']")
    WebElement searchedOptimum;

    public WebElement searchedOptimum() {
        return searchedOptimum;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Next' or @text='NEXT']")
    WebElement hallmarkSearchNext;

    public WebElement hallmarkSearchNext() {
        return hallmarkSearchNext;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Yes'] or @text='YES'")
    WebElement hallmarkLogOutYesBtn;

    public WebElement getHallmarkLogOutYesBtn() {
        return hallmarkLogOutYesBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Hallmark']")
    WebElement deviceHallmarkApp;

    public WebElement getDeviceHallmarkApp() {
        return deviceHallmarkApp;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Watch\n" + "Now' or @text='WATCH\n" + "NOW']")
    WebElement hallmarkWatchNowBtn;

    public WebElement getHallmarkWatchNowBtn() {
        return hallmarkWatchNowBtn;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Resume\n" + "Playback' or @text='RESUME\n" + "PLAYBACK']")
    WebElement hallmarkResumePlayBackBtn;

    public WebElement getHallmarkResumePlayBackBtn() {
        return hallmarkResumePlayBackBtn;
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Play']")
    WebElement hallmarkPlayBtn;

    public WebElement getHallmarkPlayBtn() {
        return hallmarkPlayBtn;
    }


    public boolean downloadHallmarkApp() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] Downloading process is starting...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);
        //waitForScreenDownloaded(10000);
        elementIsVisibleAndClickable(downloadBtn()).click();
        Reporter.log("-----[HallmarkApp] Download button is clicked", true);
        Reporter.log("-----[HallmarkApp] Hallmark app is installing...", true);
        clickOnPlayBtn(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Play button is clicked", true);
        clickOnScreenSizeBtn();
        waitForScreenDownloaded(10000);

        return getHhallmarkLogo().isDisplayed();

    }

    public boolean isHallmarkSignedIn() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkSignedIn test is starting...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);
        waitForScreenDownloaded(20000);
        scrollDownToElementAndClick(getHallmarkLogInBtn());
        Reporter.log("-----[HallmarkApp] LogIn button is clicked", true);
        waitForScreenDownloaded(5000);
        clickAndEnter(getHallmarkSearchMVPD());
        Reporter.log("-----[HallmarkApp] Search button is clicked", true);
        postOptimum();
        Reporter.log("-----[HallmarkApp] Hallmark app Search for Optimum provider", true);
        clickAndEnter(searchedOptimum());
        pressSelect();
        pressSelect();
        Reporter.log("-----[HallmarkApp] Optimum provider selected from  the list", true);
        Reporter.log("-----[HallmarkApp] Hallmark app Search Next button is clicked", true);
        waitForScreenDownloaded(5000);
        //optimumUserTextField().clear();
        //driver.hideKeyboard();
        optimumUserTextField().sendKeys(postOptimumUsername());
        Reporter.log("-----[HallmarkApp] Optimum username is provided", true);
        //driver.hideKeyboard();
        //optimumPasswordTextField().clear();
        optimumPasswordTextField().sendKeys(postOptimumPassword());
        Reporter.log("-----[HallmarkApp] Optimum password is provided", true);
        //driver.hideKeyboard();
        click(optimumSignInBtn());
        Reporter.log("-----[HallmarkApp] Optimum Sign-In button is clicked", true);
        waitForScreenDownloaded(5000);

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully signedIn", getHallmarkLogOutBtn().isDisplayed());
        return getHallmarkLogOutBtn().isDisplayed();

    }

    public boolean isHallmarkAutoSignedIn_withDownloading() throws InterruptedException {
        if (downloadHallmarkApp()) {
            Reporter.log("-----[HallmarkApp] isHallmarkAutoSignedIn_withDownloading test is running...", true);
            waitForScreenDownloaded(10000);
            scrollDownToElementIsPresented(getHallmarkLogOutBtn());

            Reporter.log("-----[HallmarkApp] Hallmark app is successfully auto signedIn", getHallmarkLogOutBtn().isDisplayed());
            return getHallmarkLogOutBtn().isDisplayed();
        } else return false;

    }

    public boolean isHallmarkAutoSignedOut() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkAutoSignOut test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);
        waitForScreenDownloaded(20000);
        scrollDownToElementIsPresented(getHallmarkLogInBtn());

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully auto signedOut", getHallmarkLogInBtn().isDisplayed());
        return getHallmarkLogInBtn().isDisplayed();

    }

    public boolean isHallmarkSignedOutAfterContentWatched() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkSignedOutAfterContentWatched test is running", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);
        waitForScreenDownloaded(20000);

        try {
            if (getHallmarkResumePlayBackBtn().isDisplayed()) {
                pressOnBackBtn(1);
                Reporter.log("-----[HallmarkApp] Back button is pressed", true);
            }
        } catch (NoSuchElementException e) {
            if (getHallmarkWatchNowBtn().isDisplayed()) {
                pressOnBackBtn(1);
                Reporter.log("-----[HallmarkApp] Back button is pressed", true);
            } else {
                pressOnBackBtn(1);
                Reporter.log("-----[HallmarkApp] Back button is selected", true);
            }
        }
        scrollDownToElementAndClick(getHallmarkLogOutBtn());
        //waitForScreenDownloaded(2000);
        try {
            if (getHallmarkLogOutYesBtn().isDisplayed()) {
                click(getHallmarkLogOutYesBtn());
            }
        } catch (NoSuchElementException e) {
            pressSelect();
        }

        waitForScreenDownloaded(2000);

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully signedOut", getHallmarkLogInBtn().isDisplayed());
        return getHallmarkLogInBtn().isDisplayed();
    }

    public boolean isHallmarkSignedOut() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkSignedOutAfterContentWatched test is running", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);
        waitForScreenDownloaded(20000);
        scrollDownToElementAndClick(getHallmarkLogOutBtn());
        //waitForScreenDownloaded(2000);
        try {
            if (getHallmarkLogOutYesBtn().isDisplayed()) {
                click(getHallmarkLogOutYesBtn());
            }
        } catch (NoSuchElementException e) {
            pressSelect();
        }

        waitForScreenDownloaded(2000);

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully signedOut", getHallmarkLogInBtn().isDisplayed());
        return getHallmarkLogInBtn().isDisplayed();
    }

    public boolean isHallmarkAutoSignedIn() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkAutoSignedIn test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);
        waitForScreenDownloaded(20000);
        scrollDownToElementIsPresented(getHallmarkLogOutBtn());

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully auto signedIn", getHallmarkLogOutBtn().isDisplayed());
        return getHallmarkLogOutBtn().isDisplayed();
    }

    public boolean isHallmarkSignedInAfterCacheIsCleared() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkAutoSignedInAfterCacheIsCleared test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);

        appClearCache(getDeviceManageInstalledApplications(), getDeviceHallmarkApp(), getAppClearCacheBtn(), getAppLaunchApplications());

        waitForScreenDownloaded(20000);
        scrollDownToElementIsPresented(getHallmarkLogOutBtn());

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully signedIn after app cache is cleared", getHallmarkLogOutBtn().isDisplayed());
        return getHallmarkLogOutBtn().isDisplayed();
    }

    public boolean isHallmarkSignedInAfterUninstallInstallAgain_PreTest() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkAutoSignedIn test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);

        appUninstall(getDeviceManageInstalledApplications(), getDeviceHallmarkApp(), getAppUninstallBtn(), getAppLaunchApplications());

        waitForScreenDownloaded(5000);

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully uninstalled", getDeviceApplications().isDisplayed());
        return getDeviceApplications().isDisplayed();

    }

    public boolean isHallmarkVideoContentPlays() throws InterruptedException {
        Reporter.log("-----[HallmarkApp] isHallmarkVideoContentPlays test is running...", true);
        waitForScreenDownloaded(40000);
        scrollDownToElementAndClick(getHallmarkApp());
        Reporter.log("-----[HallmarkApp] Hallmark app is selected", true);

        waitForScreenDownloaded(20000);

        pressSelect();

        try {
            if (getHallmarkWatchNowBtn().isDisplayed()) {
                getHallmarkWatchNowBtn().click();
                Reporter.log("-----[HallmarkApp] Watch Now button is clicked", true);
                waitForScreenDownloaded(30000);
            }
        } catch (NoSuchElementException e) {
        }
        try {
            if (getHallmarkResumePlayBackBtn().isDisplayed()) {
                getHallmarkResumePlayBackBtn().click();
                Reporter.log("-----[HallmarkApp] Resume button is clicked", true);
            }
        } catch (NoSuchElementException e) {
        }

        waitForScreenDownloaded(40000);
        pressOnPlayBtn(1);

        Reporter.log("-----[HallmarkApp] Hallmark app is successfully playing content", getHallmarkPlayBtn().isDisplayed());
        return getHallmarkPlayBtn().isDisplayed();

    }
}
