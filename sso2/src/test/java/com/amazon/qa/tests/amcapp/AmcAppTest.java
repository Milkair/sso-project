package com.amazon.qa.tests.amcapp;

import com.amazon.qa.sso.android.pages.amcapp.AmcAppPage;
import com.amazon.qa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmcAppTest extends BaseTest {

    AmcAppPage amcAppPage = null;

//    @BeforeSuite
//    public void startAppium(){
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
//    }
    @BeforeClass
    public void initAmcPage() throws Exception {
        amcAppPage = new AmcAppPage(DEVICE_NAME, PLATFORM_VERSION, PLATFORM_NAME);

    }

    @Test
    public void verifyAmcAppSignedIn_withDownloading() throws InterruptedException {
            Assert.assertTrue(amcAppPage.isAmcSignedIn_withDownloading(), "Expected - Amc App should be Signed In");
    }

    @Test
    public void verifyAmcAppSignedOut() throws InterruptedException {
        Assert.assertTrue(amcAppPage.isAmcSignedOut(), "Expected - Amc App should be Signed Out");
    }

    @Test
    public void verifyAmcAppAutoSignedIn() throws InterruptedException {
        Assert.assertTrue(amcAppPage.isAmcAutoSignedIn(), "Expected: - Amc App should be auto Signed In");
    }

    @Test
    public void verifyAmcAppAutoSignedOut() throws InterruptedException {
        Assert.assertTrue(amcAppPage.isAmcAutoSingedOut(), "Expected: - CookingChannel App should be auto Signed Out");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        amcAppPage.pressOnHomeBtn(1);
        amcAppPage.getDriver().quit();
    }
}
