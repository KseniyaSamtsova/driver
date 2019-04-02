package mobile_pages;

import driver.WebDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage{

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sixt.reservation:id/fragmentSplashScreenContinueAsGuestButton\")")
    private AndroidElement continueAsAGuestButton;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continueAsAGuest() {
        continueAsAGuestButton.click();
    }
}
