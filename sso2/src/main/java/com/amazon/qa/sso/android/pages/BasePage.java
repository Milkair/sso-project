package com.amazon.qa.sso.android.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private AndroidDriver<WebElement> driver;
    private WebDriverWait wait;

    public BasePage() {

    }

    public BasePage(String deviceName, String platformVersion, String platformName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        //capabilities.setCapability(MobileCapabilityType.APP, "com.amazon.venezia");
        capabilities.setCapability("appPackage", "com.amazon.venezia");
        capabilities.setCapability("appActivity", ".grid.AppsGridActivity");

        this.driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.wait = new WebDriverWait(driver, 10000);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Download You own it']")
    WebElement downloadBtn;

    public WebElement downloadBtn() {
        return downloadBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Got it']")
    WebElement gotItBtn;

    public WebElement gotItBtn() {
        return gotItBtn;
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
    WebElement playBtn;

    public WebElement playBtn() {
        return playBtn;
    }

    @FindBy(xpath = "//android.widget.EditText[@text='Optimum ID']")
    WebElement optimumUserTextField;

    public WebElement optimumUserTextField() {
        return optimumUserTextField;
    }

    @FindBy(xpath = "//android.widget.EditText[@text='Password']")
    WebElement optimumPasswordTextField;

    public WebElement optimumPasswordTextField() {
        return optimumPasswordTextField;
    }

    @FindBy(xpath = "//android.widget.Image[@resource-id='signin_button']")
    WebElement optimumkSignInBtn;

    public WebElement optimumSignInBtn() {
        return optimumkSignInBtn;
    }

    @FindBy(xpath = "//")
    WebElement appUpdateBtn;

    public WebElement getAppUpdateBtn() {
        return appUpdateBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    WebElement deviceSettings;

    public WebElement getDeviceSettings() {
        return deviceSettings;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Applications']")
    WebElement deviceApplications;

    public WebElement getDeviceApplications() {
        return deviceApplications;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Manage Installed Applications']")
    WebElement deviceManageInstalledApplications;

    public WebElement getDeviceManageInstalledApplications() {
        return deviceManageInstalledApplications;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Clear data']")
    WebElement appClearDataBtn;

    public WebElement getAppClearDataBtn() {
        return appClearDataBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Clear cache']")
    WebElement appClearCache;

    public WebElement getAppClearCacheBtn() {
        return appClearCache;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Force stop']")
    WebElement appForceStop;

    public WebElement getAppForceStopBtn() {
        return appForceStop;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Uninstall']")
    WebElement appUninstall;

    public WebElement getAppUninstallBtn() {
        return appUninstall;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Launch application']")
    WebElement appLaunchApplications;

    public WebElement getAppLaunchApplications() {
        return appLaunchApplications;
    }

    @FindBy (xpath = "//android.widget.Button[@text='Accept']")
    WebElement acceptScreenSizeBtn;

    public WebElement getAcceptScreenSizeBtn() {
        return acceptScreenSizeBtn;
    }

    public void clickOnScreenSizeBtn() throws InterruptedException {
        try{
            if(getAcceptScreenSizeBtn().isDisplayed()){
                getAcceptScreenSizeBtn().click();
                Reporter.log("-----[ScreenSizeButton] Screen Size button is clicked");
            }
        }catch (NoSuchElementException e){

        }
    }

    public void clickAndEnter(WebElement element) throws InterruptedException {
        element.click();
        Thread.sleep(1000);

        driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_CENTER);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollDown(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++)
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN);
    }

    public void scrollUp(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++) {
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP);
        }
    }

    public void scrollRight(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++) {
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_RIGHT);
        }
    }

    public void scrollLeft(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++)
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_LEFT);
    }

    public void pressOnHomeBtn(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++)
            driver.pressKeyCode(AndroidKeyCode.HOME);
    }

    public void pressOnMenuBtn(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++)
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_MENU);
    }

    public void pressOnBackBtn(int times) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < times; i++)
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
    }

    public void pressOnPlayBtn(int times) throws InterruptedException {
        Thread.sleep(1000);
        for(int i = 0; i < times; i++)
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_MEDIA_PLAY_PAUSE);
    }

    public void scrollDownToElementAndClick(WebElement element) throws InterruptedException {
        int timesScroll = 100;
        for (int i = 0; i <= timesScroll; i++) {
            try {
                if (element.isDisplayed() == true) clickAndEnter(element);
                break;
            } catch (NoSuchElementException e) {
                scrollDown(2);
            }
        }
    }

    public void scrollDownToElementIsPresented(WebElement element) throws InterruptedException {
        int timeScroll = 100;
        for (int i = 0; i <= timeScroll; i++) {
            try {
                if (element.isDisplayed() == true);
                break;
            } catch (NoSuchElementException e) {
                scrollDown(2);
            }
        }

    }

    public void scrollUpToElementIsPresented(WebElement element) throws InterruptedException {
        int timeScroll = 20;
        for (int i = 0; i <= timeScroll; i++) {
            try {
                if (element.isDisplayed() == true) System.out.println(element.getText() + " is presented");
                break;
            } catch (NoSuchElementException e) {
                scrollUp(2);
            }
        }

    }

    public void scrollUpToElementAndClick(WebElement element) throws InterruptedException {
        int timeScroll = 20;
        for (int i = 0; i <= timeScroll; i++) {
            try {
                if (element.isDisplayed() == true) clickAndEnter(element);
                break;
            } catch (NoSuchElementException e) {
                scrollUp(2);
            }
        }
    }

    public void waitForScreenDownloaded(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void pressSelect() {
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_CENTER);
    }

    public void clickOnPlayBtn(WebElement element) throws InterruptedException {
        try {
            if (elementIsVisibleAndClickable(gotItBtn()).isDisplayed() == true) {
                gotItBtn().click();
                Reporter.log("-----[GotItButton] Got it button is clicked", true);
            }
        } catch (NoSuchElementException e) {
        }
        waitForScreenDownloaded(5000);
        try {
            if (element.isDisplayed()) {
                pressOnBackBtn(1);
                Reporter.log("-----[BackButton] Back button to downloading screen is clicked", true);
            }
        } catch (NoSuchElementException e) {
        }
        waitForScreenDownloaded(40000);
        clickAndEnter(elementIsVisibleAndClickable(playBtn()));
    }

    public String postOptimumUsername() {
        return "research38";
    }

    public String postOptimumPassword() {
        return "support38";
    }


    public void startServer() {

        CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
        command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
        command.addArgument("--address", false);
        command.addArgument("127.0.0.1");
        command.addArgument("--port", false);
        command.addArgument("4723");
        command.addArgument("--full-reset", false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(command, resultHandler);
            Thread.sleep(5000);
            System.out.println("Appium server started.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        String[] command = {"/usr/bin/killall", "-KILL", "node"};
        try {
            Runtime.getRuntime().exec(command);
            System.out.println("Appium server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement elementIsVisibleAndClickable(WebElement element) throws InterruptedException {
        //System.out.println("elementIsVisibleAndClickable method");
        int y = 25;
        for (int i = 0; i <= y; i++) {
            try {
                if (element.isDisplayed() == true) return element;
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Element is not presented yet");
                Thread.sleep(1000);
            }
        }
        return null;
    }

    public void appUpdateException() throws InterruptedException {
        waitForScreenDownloaded(10000);
        Reporter.log("-----[AppUpdateException] App Update Exception is selected", true);
        try {
            if (getAppUpdateBtn().isDisplayed()) {
                clickAndEnter(getAppUpdateBtn());
                Reporter.log("-----[AppUpdateException] AppUpdateBtn is clicked", true);
                clickAndEnter(elementIsVisibleAndClickable(playBtn()));
                Reporter.log("-----[AppUpdateException] PlayBtn is clicked", true);
            }
        } catch (NoSuchElementException e) {
            Reporter.log("-----[AppUpdateException] App doesn't need to update", true);
            clickAndEnter(playBtn());
            Reporter.log("-----[AppUpdateException] PlayBtn is clicked", true);
        }
    }


//    @FindBy (xpath = "//*[@text='%s']")
//    WebElement bogdan;

    public boolean isScrollableElementFocused_scrollDown(WebElement element) throws InterruptedException {
        //AndroidElement hello = (AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+str+"\"))");
        for (int i = 0; i <= 20; i++) {
            try {
                while (element.isDisplayed() && !element.isSelected()) {
                    scrollDown(1);
                }
            } catch (NoSuchElementException e) {
                scrollDown(1);
            }
        }

        return element.isSelected();
    }

    public boolean isScrollableElementFocused_scrollUp(WebElement element) throws InterruptedException {
        //AndroidElement hello = (AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+str+"\"))");
        for(int i = 0; i <= 20; i++) {
            try {
                while (element.isDisplayed() && !element.isSelected()) {
                    scrollUp(1);
                }
            } catch (NoSuchElementException e) {
                scrollUp(1);
            }
        }

        return element.isSelected();
    }

    public void appClearData(WebElement manageInstalledApplications, WebElement deviceApp, WebElement clearData, WebElement launchApp) throws InterruptedException {
        Reporter.log("-----[AppClearData] App Clear Data test is running...", true);
        waitForScreenDownloaded(10000);
        pressOnHomeBtn(1);
        Reporter.log("-----[AppClearData] Home button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceSettings()));
        Reporter.log("-----[AppClearData] Settings button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceApplications()));
        Reporter.log("-----[AppClearData] Applications button is clicked", true);
        waitForScreenDownloaded(5000);

        if(isScrollableElementFocused_scrollDown(manageInstalledApplications)){
            pressSelect();
        }
        Reporter.log("-----[AppClearData] Managed Installed Applications button is clicked", true);
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(deviceApp)){
            pressSelect();
            Reporter.log("-----[AppClearData] Tested App is selected", true);
        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(clearData)){
            pressSelect();
            Reporter.log("-----[AppClearData] Clear data button is clicked", true);
            waitForScreenDownloaded(3000);
            pressSelect();
            Reporter.log("-----[AppClearData] Clear data confirmation button is clicked", true);
        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollUp(launchApp)){
            pressSelect();
            Reporter.log("-----[AppClearData] Launch App button is clicked", true);
        }
    }

    public void appClearCache(WebElement manageInstalledApplications, WebElement deviceApp, WebElement clearCache, WebElement launchApp) throws InterruptedException {
        Reporter.log("-----[AppClearCache] App Clear Cache test is running...", true);
        waitForScreenDownloaded(10000);
        pressOnHomeBtn(1);
        Reporter.log("-----[AppClearCache] Home button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceSettings()));
        Reporter.log("-----[AppClearCache] Settings button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceApplications()));
        Reporter.log("-----[AppClearCache] Applications button is clicked", true);
        waitForScreenDownloaded(5000);

        if(isScrollableElementFocused_scrollDown(manageInstalledApplications)){
            pressSelect();
        }
        Reporter.log("-----[AppClearCache] Managed Installed Applications button is clicked", true);
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(deviceApp)){
            pressSelect();
            Reporter.log("-----[AppClearCache] Tested App is selected", true);
        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(clearCache)){
            pressSelect();
            Reporter.log("-----[AppClearCache] Clear cache button is clicked", true);

        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollUp(launchApp)){
            pressSelect();
            Reporter.log("-----[AppClearCache] Launch App button is clicked", true);
        }
    }

    public void appForceStop(WebElement manageInstalledApplications, WebElement deviceApp, WebElement forceStop, WebElement launchApp) throws InterruptedException {
        Reporter.log("-----[AppForceStop] App Clear Cache test is running...", true);
        waitForScreenDownloaded(10000);
        pressOnHomeBtn(1);
        Reporter.log("-----[AppForceStop] Home button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceSettings()));
        Reporter.log("-----[AppForceStop] Settings button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceApplications()));
        Reporter.log("-----[AppForceStop] Applications button is clicked", true);
        waitForScreenDownloaded(5000);

        if(isScrollableElementFocused_scrollDown(manageInstalledApplications)){
            pressSelect();
        }
        Reporter.log("-----[AppForceStop] Managed Installed Applications button is clicked", true);
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(deviceApp)){
            pressSelect();
            Reporter.log("-----[AppForceStop] Tested App is selected", true);
        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(forceStop)){
            pressSelect();
            Reporter.log("-----[AppForceStop] Force Stop button is clicked", true);

        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollUp(launchApp)){
            pressSelect();
            Reporter.log("-----[AppForceStop] Launch App button is clicked", true);
        }
    }

    public void appUninstall(WebElement manageInstalledApplications, WebElement deviceApp, WebElement appUninstall, WebElement launchApp) throws InterruptedException {
        Reporter.log("-----[AppUninstall] App Uninstall test is running...", true);
        waitForScreenDownloaded(10000);
        pressOnHomeBtn(1);
        Reporter.log("-----[AppUninstall] Home button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceSettings()));
        Reporter.log("-----[AppUninstall] Settings button is clicked", true);
        clickAndEnter(elementIsVisibleAndClickable(getDeviceApplications()));
        Reporter.log("-----[AppUninstall] Applications button is clicked", true);
        waitForScreenDownloaded(5000);

        if(isScrollableElementFocused_scrollDown(manageInstalledApplications)){
            pressSelect();
        }
        Reporter.log("-----[AppUninstall] Managed Installed Applications button is clicked", true);
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(deviceApp)){
            pressSelect();
            Reporter.log("-----[AppUninstall] Tested App is selected", true);
        }
        waitForScreenDownloaded(3000);
        if(isScrollableElementFocused_scrollDown(appUninstall)){
            pressSelect();
            Reporter.log("-----[AppUninstall] Uninstall button is clicked", true);
            waitForScreenDownloaded(3000);
            pressSelect();
            Reporter.log("-----[AppUninstall] Uninstall button is clicked", true);

        }
    }
}
