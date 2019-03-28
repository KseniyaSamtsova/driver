package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailFoldersList extends AbstractComponent {

    @FindBy(xpath = "//div[@data-id='500000']/a")
    private WebElement sentEmailsPageButton;

    @FindBy(xpath = "//div[@data-id='500001']/a")
    private WebElement draftsPageButton;

    @FindBy(xpath = "//div[@data-id='500002']/a")
    private WebElement archivePageButton;

    public EmailFoldersList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToDrafts() {
        logger.info("open draft page");
        safeClick(draftsPageButton);
    }

    public void goToSentEmailsPage() {
        logger.info("open sent emails page");
        safeClick(sentEmailsPageButton);
    }

    public void goToArchivePage() {
        logger.info("open archieve page");
        safeClick(archivePageButton);
    }
}
