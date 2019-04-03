package mobile_pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    @AndroidFindBy(id = "com.sixt.reservation:id/fragmentSplashScreenContinueAsGuestButton")
    private AndroidElement continueAsAGuestButton;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void continueAsAGuest() {
        logger.info("Click continue as a guest Button");
        continueAsAGuestButton.click();
    }
}
