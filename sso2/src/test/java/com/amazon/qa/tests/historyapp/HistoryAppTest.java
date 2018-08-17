package com.amazon.qa.tests.historyapp;

import com.amazon.qa.sso.android.pages.historyapp.HistoryAppPage;
import com.amazon.qa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HistoryAppTest extends BaseTest {


    HistoryAppPage historyAppPage = null;

    @BeforeClass
    public void initHistoryPage() throws Exception{
        historyAppPage = new HistoryAppPage(DEVICE_NAME,PLATFORM_VERSION,PLATFORM_NAME);
    }

    @Test
    public void verifyHistoryAppAutoSignedIn_withDownloading() throws InterruptedException {
        Assert.assertTrue(historyAppPage.isHistoryAutoSignedIn_withDownloading(),
                "Expected - History App should be auto Signed In");
    }

    @Test
    public void verifyHistoryAppAutoSignOut() throws InterruptedException {
        Assert.assertTrue(historyAppPage.isHistoryAutoSignedOut(),
                "Expected - History App should be auto Signed Out");
    }

    @Test
    public void verifyHistoryAppAutoSignedIn() throws InterruptedException {
        Assert.assertTrue(historyAppPage.isHistoryAutoSignedIn(),
                "Expected - History App should be auto Signed In");
    }

    @Test
    public void verifyHistoryAppSignedIn() throws InterruptedException {
        Assert.assertTrue(historyAppPage.isHistorySignedIn(),
                "Expected - History App should be Signed In");
    }

    @Test
    public void verifyHistorySignedInAfterForceStop() throws InterruptedException {
        Assert.assertTrue(historyAppPage.isHistorySignedInAfterForceStop(),
                "Expected - History App should be Signed In");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        historyAppPage.pressOnHomeBtn(1);
        historyAppPage.getDriver().quit();
    }
}
