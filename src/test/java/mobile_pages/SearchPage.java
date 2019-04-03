package mobile_pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.sixt.reservation:id/fragmentHomeContinueButton")
    private AndroidElement showOffersButton;

    @AndroidFindBy(id = "com.sixt.reservation:id/layoutFeedbackMessageSubtitleTextView")
    private AndroidElement errorMessage;

    public void clickShowOffersButton() {
        logger.info("Click Show Offers Button");
        showOffersButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
