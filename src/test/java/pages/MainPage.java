package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private static final String BASE_URL = "https://mail.ru/";

    @FindBy(id = "mailbox:login")
    private WebElement loginInput;

    @FindBy(id = "mailbox:password")
    private WebElement passwordInput;

    @FindBy(id = "mailbox:saveauth")
    private WebElement doNotRememberCheckbox;

    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement submitButton;

    @FindBy(id = "mailbox:error")
    private WebElement errorMessage;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void enterUsername(String username) {
        highlightElement(loginInput);
        loginInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void selectDoNotRemember() {
        doNotRememberCheckbox.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean checkLogOut() {
        return loginInput.isDisplayed();
    }
}
