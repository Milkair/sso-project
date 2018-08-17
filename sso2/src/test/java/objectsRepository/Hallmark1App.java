package objectsRepository;


import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hallmark1App extends BasePage {
    Util util;
    AndroidDriver<WebElement> driver;

    public Hallmark1App(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Hallmark1']")
    WebElement hallmark1app;

    public WebElement hallmark1app() {
        return hallmark1app;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    WebElement hallmark1LogInBtn;

    public WebElement hallmark1LogInBtn() {
        return hallmark1LogInBtn;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement hallmark1LogOutBtn;

    public WebElement hallmark1LogOutBtn() {
        return hallmark1LogOutBtn;
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