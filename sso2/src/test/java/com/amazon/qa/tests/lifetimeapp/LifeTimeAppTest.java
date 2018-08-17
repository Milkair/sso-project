package com.amazon.qa.tests.lifetimeapp;

import com.amazon.qa.sso.android.pages.lifetimeapp.LifeTimeAppPage;
import com.amazon.qa.tests.BaseTest;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LifeTimeAppTest extends BaseTest {

    LifeTimeAppPage lifetimeAppPage = null;

    @BeforeClass
    public void initLifeTimePage() throws Exception{
        lifetimeAppPage = new LifeTimeAppPage(DEVICE_NAME,PLATFORM_VERSION,PLATFORM_NAME);
    }

    @Test
    public void verifyLifeTimeAppAutoSignedIn_withDownloading() throws InterruptedException {
        Assert.assertTrue(lifetimeAppPage.isLifeTimeAutoSignedIn_withDownloading(),
                "Expected - LifeTime App should be auto Signed In");
    }

    @Test
    public void verifyLifeTimeAppAutoSignedOut() throws InterruptedException {
        Assert.assertTrue(lifetimeAppPage.isLifeTimeAutoSignedOut(),
                "Expected - LifeTime App should be auto Signed In");
    }

    @Test
    public void verifyLifeTimeAppAutoSignedIn() throws InterruptedException {
        Assert.assertTrue(lifetimeAppPage.isLifeTimeAutoSignedIn(),
                "Expected - LifeTime App should be auto Signed In");
    }

    @Test
    public void verifyLifeTimeSignedInAfterDataIsCleared() throws InterruptedException {
        Assert.assertTrue(lifetimeAppPage.isLifeTimeSignedInAfterDataIsCleared(),
                "Expected - LifeTime App should be  Signed In");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        lifetimeAppPage.pressOnHomeBtn(1);
        lifetimeAppPage.getDriver().quit();
    }

    @AfterSuite
    public void closeAppium(){
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.stop();
    }
}
