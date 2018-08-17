package com.amazon.qa.sso.android.pages.lifetimeapp;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LifeTimeAppPage extends BasePage {

    AndroidDriver<WebElement> driver;

    public LifeTimeAppPage(String deviceName, String platformVersion, String platformName) throws Exception {
        super(deviceName, platformVersion, platformName);
        this.driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//android.widget.ImageView[@content-desc='Lifetime']")
    WebElement lifeTimeApp;

    public WebElement getLifeTimeApp() {
        return lifeTimeApp;
    }

    @FindBy (xpath = "//android.widget.TextView[@text='Lifetime']")
    WebElement deviceLifeTimeApp;

    public WebElement getDeviceLifeTimeApp() {
        return deviceLifeTimeApp;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Ask Me Later' or @text='ASK ME LATER']")
    WebElement histortyAskMeLaterBtn;

    public WebElement getHistortyAskMeLaterBtn() {
        return histortyAskMeLaterBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='SETTINGS']")
    WebElement lifeTimeSettings;

    public WebElement getLifeTimeSettings() {
        return lifeTimeSettings;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign out from Cablevision']")
    WebElement lifeTimeSignOutBtn;

    public WebElement getLifeTimeSignOutBtn() {
        return lifeTimeSignOutBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Use']")
    WebElement lifeTimeTermsOfUse;

    public WebElement getLifeTimeTermsOfUse() {
        return lifeTimeTermsOfUse;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
    WebElement lifeTimeSignInBtn;

    public WebElement getLifeTimeSignInBtn() {
        return lifeTimeSignInBtn;
    }

    public boolean downloadLifeTimeApp() throws InterruptedException {
        Reporter.log("-----[LifeTimeApp] Downloading process is starting...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getLifeTimeApp());
        Reporter.log("-----[LifeTimeApp] LifeTime app is selected", true);
        elementIsVisibleAndClickable(downloadBtn()).click();
        Reporter.log("-----[LifeTimeApp] Download button is clicked", true);
        Reporter.log("-----[LifeTimeApp] LifeTime app is installing...", true);
        clickOnPlayBtn(getLifeTimeApp());
        Reporter.log("-----[LifeTimeApp] Play button is clicked", true);
        clickOnScreenSizeBtn();
        waitForScreenDownloaded(10000);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[LifeTimeApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }

        return getLifeTimeSettings().isDisplayed();

    }

    public boolean isLifeTimeAutoSignedIn_withDownloading() throws InterruptedException {
        if (downloadLifeTimeApp()) {
            Reporter.log("-----[LifeTimeApp] isLifeTimeAutoSignedIn test is running...", true);
            clickAndEnter(elementIsVisibleAndClickable(getLifeTimeSettings()));
            Reporter.log("-----[LifeTimeApp] Settings button is clicked", true);
            Reporter.log("-----[LifeTimeApp] LifeTime app is successfully auto signedIn", getLifeTimeSignOutBtn().isDisplayed());
            return getLifeTimeSignOutBtn().isDisplayed();
        } else return false;

    }
    public boolean isLifeTimeAutoSignedOut() throws InterruptedException {
        Reporter.log("-----[LifeTimeApp] isLifeTimeAutoSignOut test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getLifeTimeApp());
        Reporter.log("-----[LifeTimeApp] LifeTime app is selected", true);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        waitForScreenDownloaded(10000);
        try {
            if (getLifeTimeTermsOfUse().isDisplayed()) {
                scrollLeft(1);
            }
        } catch (NoSuchElementException e) {
            scrollLeft(1);
            waitForScreenDownloaded(5000);
        }
        Reporter.log("-----[LifeTimeApp] LifeTime app is successfully auto signedOut", getLifeTimeSignInBtn().isDisplayed());
        return getLifeTimeSignInBtn().isDisplayed();

    }

    public boolean isLifeTimeAutoSignedIn() throws InterruptedException {
        Reporter.log("-----[LifeTimeApp] isLifeTimeAutoSignedIn test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getLifeTimeApp());
        Reporter.log("-----[LifeTimeApp] LifeTime app is selected", true);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        try{
            if(getLifeTimeSignOutBtn().isDisplayed()){
                Reporter.log("-----[LifeTimeApp] LifeTime app is successfully auto signedIn", getLifeTimeSignOutBtn().isDisplayed());
                return getLifeTimeSignOutBtn().isDisplayed();
            }
        }catch (NoSuchElementException e) {
            scrollLeft(1);
            clickAndEnter(getLifeTimeSettings());
            Reporter.log("-----[LifeTimeApp] Settings button is clicked", true);
        }
        Reporter.log("-----[LifeTimeApp] LifeTime app is successfully auto signedIn", getLifeTimeSignOutBtn().isDisplayed());
        return getLifeTimeSignOutBtn().isDisplayed();

    }

    public boolean isLifeTimeSignedInAfterDataIsCleared() throws InterruptedException {
        Reporter.log("-----[LifeTimeApp] isLifeTimeSignedInAfterDataIsCleared test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getLifeTimeApp());
        Reporter.log("-----[LifeTimeApp] LifeTime app is selected", true);

        appClearData(getDeviceManageInstalledApplications(), getDeviceLifeTimeApp(), getAppClearDataBtn(), getAppLaunchApplications());

        waitForScreenDownloaded(20000);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        try{
            if(getLifeTimeSignOutBtn().isDisplayed()){
                Reporter.log("-----[LifeTimeApp] LifeTime app is successfully auto signedIn", getLifeTimeSignOutBtn().isDisplayed());
                return getLifeTimeSignOutBtn().isDisplayed();
            }
        }catch (NoSuchElementException e) {
            scrollLeft(1);
            clickAndEnter(getLifeTimeSettings());
            Reporter.log("-----[LifeTimeApp] Settings button is clicked", true);
        }
        Reporter.log("-----[LifeTimeApp] LifeTime app is successfully signedIn after app data is cleared", getLifeTimeSignOutBtn().isDisplayed());
        return getLifeTimeSignOutBtn().isDisplayed();
    }





































}
