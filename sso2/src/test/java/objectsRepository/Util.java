package objectsRepository;

import com.amazon.qa.sso.android.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public class Util extends BasePage {

    AndroidDriver<WebElement> driver;

    public Util() {
        this.driver = getDriver();
    }


}

