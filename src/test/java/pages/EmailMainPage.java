package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailMainPage extends BasePage {

    public EmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "PH_user-email")
    private WebElement userEmailActual;

    @FindBy(id = "PH_logoutLink")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@data-name='compose']")
    private WebElement createMessageButton;

    public void clickLogOut() {
        logger.info("Click logout button");
        waitForClickableAndClick(logOutButton);
    }

    public String getCurrentUserEmail() {
        waitForVisibility(userEmailActual);
        return userEmailActual.getText();
    }

    public void clickCreateMessage() {
        logger.info("Click create message button");
        waitForClickableAndClick(createMessageButton);
    }
}
