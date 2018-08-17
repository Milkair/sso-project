package com.amazon.qa.tests.cookingchannelapp;

import com.amazon.qa.sso.android.pages.cookingchannelapp.CookingChannelAppPage;
import com.amazon.qa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CookingChannelAppTest extends BaseTest {

    CookingChannelAppPage cookingChannelAppPage = null;


    @BeforeClass
    public void initCookingChannelPage() throws Exception {
        cookingChannelAppPage = new CookingChannelAppPage(DEVICE_NAME, PLATFORM_VERSION, PLATFORM_NAME);

    }

    @Test
    public void verifyCookingChannelAppAutoSignedIn() throws InterruptedException {
        Assert.assertTrue(cookingChannelAppPage.isCookingChannelAutoSignedIn(), "Expected - CookingChannel App should be Signed In");
    }

    @Test
    public void verifyCookingChannelAppSignedOut() throws InterruptedException {
        Assert.assertTrue(cookingChannelAppPage.isCookingChannelSignedOut(), "Expected - CookingChannel App should be Signed Out");
    }

    @Test
    public void verifyCookingChannelAppAutoSignedIn_withDownloading() throws InterruptedException {
        Assert.assertTrue(cookingChannelAppPage.isCookingChannelAutoSignedIn_withDownloading(),
                "Expected: - CookingChannel App should be auto Signed In");
    }

    @Test
    public void verifyCookingChannelAppAutoSignedOut() throws InterruptedException {
        Assert.assertTrue(cookingChannelAppPage.isCookingChannelAutoSingedOut(),
                "Expected: - CookingChannel App should be auto Signed Out");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        cookingChannelAppPage.pressOnHomeBtn(1);
        cookingChannelAppPage.getDriver().quit();
    }
}
