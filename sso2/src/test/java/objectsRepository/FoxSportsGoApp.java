package objectsRepository;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoxSportsGoApp extends BasePage {

    AndroidDriver<WebElement> driver;

    public FoxSportsGoApp(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@content-desc='FOX Sports GO']")
    WebElement foxSportsGoApp;
    public WebElement foxSportsGoApp(){
        return foxSportsGoApp;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='SETTINGS']")
    WebElement foxSportsSettingsBtn;
    public WebElement foxSportsSettingsBtn(){
        return foxSportsSettingsBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    WebElement foxSportsSignInBtn;
    public WebElement foxSportsSignInBtn(){
        return foxSportsSettingsBtn;
    }
    @FindBy(xpath = "//android.widget.TextView[@text='Sign in on your desktop or mobile device at:']")
    WebElement signInScreen;
    public WebElement signInScreen(){
        return signInScreen;
    }

}