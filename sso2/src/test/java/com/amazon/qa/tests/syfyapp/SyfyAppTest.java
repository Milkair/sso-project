package com.amazon.qa.tests.syfyapp;

import com.amazon.qa.sso.android.pages.syfyapp.SyFyAppPage;
import com.amazon.qa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SyfyAppTest extends BaseTest{


    SyFyAppPage syfyAppPage = null;

//    @BeforeSuite
//    public void startAppium(){
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
//    }

    @BeforeClass
    public void initSyFyPage() throws Exception{
        syfyAppPage = new SyFyAppPage(DEVICE_NAME,PLATFORM_VERSION,PLATFORM_NAME);
    }

    @Test
    public void verifySyFyAppAutoSignedIn_withDownloading() throws InterruptedException {
        Assert.assertTrue(syfyAppPage.isSyFyAutoSignedIn_withDownloading(),
                "Expected - SyFy App should be auto Signed In");
    }

    @Test
    public void verifySyFyAppAutoSignedOut() throws InterruptedException {
        Assert.assertTrue(syfyAppPage.isSyFyAutoSignedOut(),
                "Expected - SyFy App should be autom Signed Out");
    }

    @Test
    public void verifySyFyAppAutoSignedIn() throws InterruptedException {
        Assert.assertTrue(syfyAppPage.isSyFyAutoSignedIn(),
                "Expected - SyFy App should be auto Signed In");
    }

    //not in use
    @Test
    public void verifySyFySignedIn() throws InterruptedException {
        Assert.assertTrue(syfyAppPage.isSyFySignedIn(),
                "Expected - SyFy App should be Signed In");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        syfyAppPage.pressOnHomeBtn(1);
        syfyAppPage.getDriver().quit();
    }

}
