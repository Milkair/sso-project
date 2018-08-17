package objectsRepository;


import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hallmark2App extends BasePage {
    Util util;
    AndroidDriver<WebElement> driver;

    public Hallmark2App(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Hallmark2']")
    WebElement hallmark2app;

    public WebElement hallmark2App() {
        return hallmark2app;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    WebElement hallmark2LoginBtn;

    public WebElement hallmark2LoginBtn() {
        return hallmark2LoginBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement hallmark2LogOutBtn;

    public WebElement hallmark2LogOutBtn() {
        return hallmark2LogOutBtn;
    }

    public void postUsername() {
//        util = new Util(driver);
//        util.userNameTextField().sendKeys("AmazonTest");
    }

    public void postPassword() {
//        util = new Util(driver);
//        util.passwordTextField().sendKeys("AmazonTest");
    }

}