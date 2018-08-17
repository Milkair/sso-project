package com.amazon.qa.tests.hallmarkapp;

import com.amazon.qa.sso.android.pages.hallmarkapp.HallmarkAppPage;
import com.amazon.qa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HallmarkAppTest extends BaseTest {

    HallmarkAppPage hallmarkAppPage = null;

    @BeforeClass
    public void initHallmarkPage() throws Exception{
        hallmarkAppPage = new HallmarkAppPage(DEVICE_NAME,PLATFORM_VERSION,PLATFORM_NAME);
    }

    @Test
    public void verifyHallmarkAppAutoSignedIn_withDownloading() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkAutoSignedIn_withDownloading(),
                "Expected - Hallmark App should be auto Signed In");
    }

    @Test
    public void verifyHallmarkAppAutoSignedOut() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkAutoSignedOut(),
                "Expected - Hallmark App should be auto Signed Out");
    }

    @Test
    public void verifyHallmarkAppSignedIn() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkSignedIn(),
                "Expected - Hallmark App should be Signed In");
    }

    @Test
    public void verifyHallmarkAppSignedOutAfterContentWatched() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkSignedOutAfterContentWatched(),
                "Expected - Hallmark App should be Signed Out");
    }

    @Test
    public void verifyHallmarkAppSignedOut() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkSignedOut(),
                "Expected - Hallmark App should be Signed Out");
    }
    @Test
    public void verifyHallmarkAppAutoSignedIn() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkAutoSignedIn(),
                "Expected - Hallmark App should be auto Signed Out");
    }

    @Test
    public void verifyHallmarkSignedInAfterCacheIsCleared() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkSignedInAfterCacheIsCleared(),
                "Expected - Hallmark App should be  Signed In");
    }

    @Test
    public void verifyHallmarkSignedInAfterUninstalledInstalled_preTest() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkSignedInAfterUninstallInstallAgain_PreTest(),
                "Expected - Hallmark App should be uninstalled");
    }

    @Test
    public void verifyHallmarkVideoContentPlays() throws InterruptedException {
        Assert.assertTrue(hallmarkAppPage.isHallmarkVideoContentPlays(),
                "Expected - Hallmark App should play content");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        hallmarkAppPage.pressOnHomeBtn(1);
        hallmarkAppPage.getDriver().quit();
    }

}
