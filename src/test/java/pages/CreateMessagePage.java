package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMessagePage extends BasePage {

    public CreateMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@tabindex='4']")
    private WebElement intputRecepient;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//table[@class='mceLayout']/tbody//iframe")
    private WebElement containerForFrameMessageInput;

    @FindBy(id = "tinymce")
    private WebElement textAreaMessage;

    @FindBy(xpath = "//div[@data-name='saveDraft']")
    private WebElement saveAsDraftButton;

    @FindBy(xpath = "//div[@data-name='send']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@data-mnemo='saveStatus']/span[@class='time']")
    private WebElement saveTime;

    public void enterRecipient(String email) {
        logger.info("Input recipient");
        intputRecepient.sendKeys(email);
    }

    public void enterSubject(String subject) {
        logger.info("Input subject");
        inputSubject.sendKeys(subject);
    }

    public void enterTestMessage(String message) {
        logger.info("Input body");
        driver.switchTo().frame(containerForFrameMessageInput);
        textAreaMessage.clear();
        textAreaMessage.sendKeys(message);
        driver.switchTo().defaultContent();
    }

    public void saveEmailAsDraft() {
        logger.info("Save as draft");
        saveAsDraftButton.click();
        waitForVisibility(saveTime);
    }
}
