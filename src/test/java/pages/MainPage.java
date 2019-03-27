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

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get(BASE_URL);
        return this;
    }


}
