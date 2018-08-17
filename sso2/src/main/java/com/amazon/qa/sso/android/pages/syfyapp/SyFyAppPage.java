package com.amazon.qa.sso.android.pages.syfyapp;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SyFyAppPage extends BasePage {

    AndroidDriver<WebElement> driver;

    public SyFyAppPage(String deviceName, String platformVersion, String platformName) throws Exception {
        super(deviceName, platformVersion, platformName);
        this.driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='SYFY']")
    WebElement syfyApp;

    public WebElement getSyfyApp() {
        return syfyApp;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Sign In/Out']")
    WebElement syfySignOutSettings;

    public WebElement getSyfySignOutSettings() {
        return syfySignOutSettings;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Sign out']")
    WebElement syfySignOutBtn;

    public WebElement getSyfySignOutBtn() {
        return syfySignOutBtn;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Sign In']")
    WebElement syfySignInBtn;

    public WebElement getSyfySignInBtn() {
        return syfySignInBtn;
    }

    @FindBy(xpath = "//android.widget.Button[@text='Sign In']")
    WebElement syFySignInBtn;

    public WebElement getSyFySignInBtn() {
        return syFySignInBtn;
    }

    @FindBy(xpath = "//android.widget.RelativeLayout[@index='6']")
    WebElement syFyOptimumMvpd;

    public WebElement getSyFyOptimumMvpd() {
        return syFyOptimumMvpd;
    }
    @FindBy(xpath = "//android.widget.ImageView[@index='1']")
    WebElement syFyLogo;

    public WebElement getSyFyLogo() {
        return syFyLogo;
    }

    public boolean downloadSyfyApp() throws InterruptedException {
        Reporter.log("-----[SyFyApp] Downloading process is starting...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getSyfyApp());
        Reporter.log("-----[SyFyApp] SyFy app is selected", true);
        //waitForScreenDownloaded(10000);
        clickAndEnter(elementIsVisibleAndClickable(downloadBtn()));
        Reporter.log("-----[SyFyApp] Download button is clicked", true);
        Reporter.log("-----[SyFyApp] SyFy app is installing...", true);
        clickOnPlayBtn(getSyfyApp());
        Reporter.log("-----[SyFyApp] Play button is clicked", true);
        waitForScreenDownloaded(15000);
        scrollUp(1);
        if (getSyfySignOutSettings().isDisplayed() == false) {
            pressOnBackBtn(1);
        }

        return getSyfySignOutSettings().isDisplayed();

    }

    public boolean isSyFyAutoSignedIn_withDownloading() throws InterruptedException {
        if (downloadSyfyApp()) {
            Reporter.log("-----[SyFyApp] isSyFyAutoSignedIn_withDownloading test is running...", true);
            try {
                if (elementIsVisibleAndClickable(getSyFyLogo()).isDisplayed()) {
                    System.out.println("1");
                    waitForScreenDownloaded(2000);
                    scrollUp(2);
                    scrollRight(4);
                }
            }catch (NoSuchElementException e){
                System.out.println("2");
                waitForScreenDownloaded(2000);
                scrollUp(2);
                scrollRight(4);
            }

            Reporter.log("-----[SyFyApp] SyFy app is successfully auto signedIn", getSyfySignOutBtn().isDisplayed());
            return getSyfySignOutBtn().isDisplayed();
        } else return false;

    }

    public boolean isSyFyAutoSignedOut() throws InterruptedException {
        Reporter.log("-----[SyFyApp] isSyFyAutoSignOut test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getSyfyApp());
        Reporter.log("-----[SyFyApp] SyFy app is selected", true);
        //waitForScreenDownloaded(20000);
        System.out.println(getSyFyLogo().isDisplayed());
        try {
            if (elementIsVisibleAndClickable(getSyFyLogo()).isDisplayed()) {
                System.out.println("1");
                waitForScreenDownloaded(2000);
                scrollUp(2);
                scrollRight(4);
            }
        }catch (NoSuchElementException e){
            System.out.println("2");
            waitForScreenDownloaded(2000);
            scrollUp(2);
            scrollRight(4);
        }

        Reporter.log("-----[SyFyApp] SyFy app is successfully auto signedOut", getSyfySignInBtn().isDisplayed());
        return getSyfySignInBtn().isDisplayed();

    }

    public boolean isSyFyAutoSignedIn() throws InterruptedException {
        Reporter.log("-----[SyFyApp] isSyFyAutoSignedIn test is running...", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getSyfyApp());
        Reporter.log("-----[SyFyApp] SyFy app is selected", true);
        waitForScreenDownloaded(3000);
        try {
            if (getSyfyApp().isDisplayed()) {
                clickAndEnter(getSyfyApp());
                Reporter.log("-----[SyFyApp] SyFy app is selected", true);
            }
        } catch (NoSuchElementException e) {
            waitForScreenDownloaded(5000);
            pressOnBackBtn(1);
            scrollRight(4);
        }
        Reporter.log("-----[SyFyApp] SyFy app is successfully auto signedIn", getSyfySignOutBtn().isDisplayed());
        return getSyfySignOutBtn().isDisplayed();
    }

    // not in use
    public boolean isSyFySignedIn() throws InterruptedException {
        Reporter.log("-----[SyFyApp] isSyFySegnedIn test is running", true);
        waitForScreenDownloaded(40000);

        scrollDownToElementAndClick(getSyfyApp());
        Reporter.log("-----[SyFyApp] SyFy app is selected", true);
        waitForScreenDownloaded(3000);
        try {
            if (getSyfyApp().isDisplayed()) {
                clickAndEnter(getSyfyApp());
                Reporter.log("-----[SyFyApp] SyFy app is selected", true);
            }
        } catch (NoSuchElementException e) {

        }
        waitForScreenDownloaded(5000);
        pressOnBackBtn(1);
        scrollRight(4);
        clickAndEnter(getSyfySignInBtn());
        Reporter.log("-----[SyFyApp] Sign In button is clicked");
        System.out.println(getSyFyOptimumMvpd().isDisplayed());
        clickAndEnter(getSyFyOptimumMvpd());




        return getSyfySignOutBtn().isDisplayed();
    }
}
