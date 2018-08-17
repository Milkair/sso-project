package com.amazon.qa.sso.android.pages.historyapp;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HistoryAppPage extends BasePage {

    AndroidDriver<WebElement> driver;

    public HistoryAppPage(String deviceName, String platformVersion, String platformName) throws Exception {
        super(deviceName, platformVersion, platformName);
        this.driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='HISTORY']")
    WebElement historyApp;

    public WebElement getHistoryApp() {
        return historyApp;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign out from Cablevision']")
    WebElement historySignOutBtn;

    public WebElement getHistorySignOutBtn() {
        return historySignOutBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='SETTINGS']")
    WebElement historySettings;

    public WebElement getHistorySettings() {
        return historySettings;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
    WebElement historySignInBtn;

    public WebElement getHistorySignInBtn() {
        return historySignInBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='More TV Providers' or @text='MORE TV PROVIDERS']")
    WebElement historyMoreTvProvidersBtn;

    public WebElement getHistoryMoreTvProvidersBtn() {
        return historyMoreTvProvidersBtn;
    }

    @FindBy(xpath = "//android.widget.EditText[@text='Quick Search']")
    WebElement historyQuickSearchTextField;


    public void postHistoryOptimum() {
        driver.hideKeyboard();
        historyQuickSearchTextField.sendKeys("Optimum");
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Optimum']")
    WebElement historyOptimumBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Sign out from Cablevision']")
    WebElement historySignOutCablevisionBtn;

    public WebElement getHistorySignOutCablevisionBtn() {
        return historySignOutCablevisionBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='DEACTIVATE THIS DEVICE']")
    WebElement historyDeactivateThisDeviceBtn;

    public WebElement getHistoryDeactivateThisDeviceBtn() {
        return historyDeactivateThisDeviceBtn;
    }

    public WebElement getHistoryOptimumBtn() {
        return historyOptimumBtn;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Ask Me Later' or @text='ASK ME LATER']")
    WebElement histortyAskMeLaterBtn;

    public WebElement getHistortyAskMeLaterBtn() {
        return histortyAskMeLaterBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Use']")
    WebElement historyTermsOfUse;

    public WebElement getHistoryTermsOfUse() {
        return historyTermsOfUse;
    }

    @FindBy (xpath = "//android.widget.TextView[@text='HISTORY']")
    WebElement deviceHistoryApp;

    public WebElement getDeviceHistoryApp() {
        return deviceHistoryApp;
    }


    public boolean downloadHistoryApp() throws InterruptedException {
        Reporter.log("-----[HistoryApp] Downloading process is starting...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getHistoryApp());
        Reporter.log("-----[HistoryApp] History app is selected", true);
        elementIsVisibleAndClickable(downloadBtn()).click();
        Reporter.log("-----[HistoryApp] Download button is clicked", true);
        Reporter.log("-----[HistoryApp] History app is installing...", true);
        clickOnPlayBtn(getHistoryApp());
        Reporter.log("-----[HistoryApp] Play button is clicked", true);
        clickOnScreenSizeBtn();
        //waitForScreenDownloaded(5000);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }

        return getHistorySettings().isDisplayed();

    }

    public boolean isHistoryAutoSignedIn_withDownloading() throws InterruptedException {
        if (downloadHistoryApp()) {
            Reporter.log("-----[HistoryApp] isHistoryAutoSignedIn test is running...", true);
            clickAndEnter(elementIsVisibleAndClickable(getHistorySettings()));
            Reporter.log("-----[HistoryApp] Settings button is clicked", true);
            Reporter.log("-----[HistoryApp] History app is successfully auto signedIn", getHistorySignOutBtn().isDisplayed());
            return getHistorySignOutBtn().isDisplayed();
        } else return false;

    }

    public boolean isHistoryAutoSignedOut() throws InterruptedException {
        Reporter.log("-----[HistoryApp] isHistoryAutoSignOut test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getHistoryApp());
        Reporter.log("-----[HistoryApp] History app is selected", true);
        waitForScreenDownloaded(10000);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        try {
            if (getHistoryTermsOfUse().isDisplayed()) {
                scrollLeft(1);
            }
        } catch (NoSuchElementException e) {
            scrollLeft(1);
            waitForScreenDownloaded(5000);
        }
        Reporter.log("-----[HistoryApp] History app is successfully auto signedOut", getHistorySignInBtn().isDisplayed());
        return getHistorySignInBtn().isDisplayed();

    }

    public boolean isHistoryAutoSignedIn() throws InterruptedException {
        Reporter.log("-----[HistoryApp] isHistoryAutoSignedIn test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getHistoryApp());
        Reporter.log("-----[HistoryApp] History app is selected", true);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        try{
            if(getHistorySignOutBtn().isDisplayed()){
                Reporter.log("-----[HistoryApp] History app is successfully auto signedIn", getHistorySignOutBtn().isDisplayed());
                return getHistorySignOutBtn().isDisplayed();
            }
        }catch (NoSuchElementException e) {
            scrollLeft(1);
            clickAndEnter(getHistorySettings());
            Reporter.log("-----[HistoryApp] Settings button is clicked", true);
        }
        Reporter.log("-----[HistoryApp] History app is successfully auto signedIn", getHistorySignOutBtn().isDisplayed());
        return getHistorySignOutBtn().isDisplayed();

    }

    public boolean isHistorySignedIn() throws InterruptedException {
        Reporter.log("-----[HistoryApp] isHistorySingedIn test is running", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getHistoryApp());
        Reporter.log("-----[HistoryApp] History app is selected", true);
        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        waitForScreenDownloaded(15000);
        try {
            if (getHistorySignInBtn().isDisplayed()) {
                scrollDown(3);
                pressSelect();
                Reporter.log("-----[HistoryApp] Sign In button is clicked", true);
                waitForScreenDownloaded(2000);
                clickAndEnter(getHistoryMoreTvProvidersBtn());
                waitForScreenDownloaded(5000);
                Reporter.log("-----[HistoryApp] More TV Providers button is clicked", true);
                postHistoryOptimum();
                //driver.hideKeyboard();
                Reporter.log("-----[HistoryApp] Optimum string is provided into search text field", true);
                click(getHistoryOptimumBtn());
                Reporter.log("-----[HistoryApp] Optimum from search text field is selected", true);
                waitForScreenDownloaded(5000);
                //optimumUserTextField().clear();
                optimumUserTextField().sendKeys(postOptimumUsername());
                Reporter.log("-----[HistoryApp] Optimum username is provided", true);
                //driver.hideKeyboard();
                //optimumPasswordTextField().clear();
                optimumPasswordTextField().sendKeys(postOptimumPassword());
                Reporter.log("-----[HistoryApp] Optimum password is provided", true);
                //driver.hideKeyboard();
                click(optimumSignInBtn());
                waitForScreenDownloaded(3000);
                scrollLeft(1);
                clickAndEnter(getHistorySettings());
                Reporter.log("-----[HistoryApp] Settings button is clicked", true);

                Reporter.log("-----[HistoryApp] History app is successfully signedIn", getHistorySignOutBtn().isDisplayed());
                return getHistorySignOutBtn().isDisplayed();
            }
        } catch (NoSuchElementException e) {
            scrollLeft(2);
            scrollDown(3);
            pressSelect();
            Reporter.log("-----[HistoryApp] Sign In button is clicked", true);
            waitForScreenDownloaded(2000);
            clickAndEnter(getHistoryMoreTvProvidersBtn());
            waitForScreenDownloaded(5000);
            Reporter.log("-----[HistoryApp] More TV Providers button is clicked", true);
            postHistoryOptimum();
            //driver.hideKeyboard();
            Reporter.log("-----[HistoryApp] Optimum string is provided into search text field", true);
            click(getHistoryOptimumBtn());
            Reporter.log("-----[HistoryApp] Optimum from search text field is selected", true);
            waitForScreenDownloaded(5000);
            //optimumUserTextField().clear();
            optimumUserTextField().sendKeys(postOptimumUsername());
            Reporter.log("-----[HistoryApp] Optimum username is provided", true);
            //driver.hideKeyboard();
            //optimumPasswordTextField().clear();
            optimumPasswordTextField().sendKeys(postOptimumPassword());
            Reporter.log("-----[HistoryApp] Optimum password is provided", true);
            //driver.hideKeyboard();
            click(optimumSignInBtn());
            waitForScreenDownloaded(3000);
            scrollLeft(1);
            clickAndEnter(getHistorySettings());
            Reporter.log("-----[HistoryApp] Settings button is clicked", true);

            Reporter.log("-----[HistoryApp] History app is successfully signedIn", getHistorySignOutBtn().isDisplayed());
            return getHistorySignOutBtn().isDisplayed();
        }

        return false;

    }

    public boolean isHistorySignedInAfterForceStop() throws InterruptedException {
        Reporter.log("-----[HistoryApp] isHistoryAutoSignedInAfterForceStop test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getHistoryApp());
        Reporter.log("-----[HistoryApp] History app is selected", true);

        appForceStop(getDeviceManageInstalledApplications(), getDeviceHistoryApp(), getAppForceStopBtn(), getAppLaunchApplications());

        waitForScreenDownloaded(20000);

        try {
            if (getHistortyAskMeLaterBtn().isDisplayed())
                clickAndEnter(getHistortyAskMeLaterBtn());
            Reporter.log("-----[HistoryApp] Ask Me Later button is clicked", true);
        } catch (NoSuchElementException e) {

        }
        try{
            if(getHistorySignOutBtn().isDisplayed()){
                Reporter.log("-----[HistoryApp] History app is successfully auto signedIn", getHistorySignOutBtn().isDisplayed());
                return getHistorySignOutBtn().isDisplayed();
            }
        }catch (NoSuchElementException e) {
            scrollLeft(1);
            clickAndEnter(getHistorySettings());
            Reporter.log("-----[HistoryApp] Settings button is clicked", true);
        }
        Reporter.log("-----[HistoryApp] History app is successfully signedIn after app force stop", getHistorySignOutBtn().isDisplayed());
        return getHistorySignOutBtn().isDisplayed();

    }

}
