package tests;

import component.EmailFoldersList;
import driver.ConfigWebDriver;
import entity.Email;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateMessagePage;
import pages.DraftsPage;
import pages.EmailMainPage;
import pages.MainPage;

public class SendingEmailTest extends BaseTest {

    Email email = new Email("sami-sami_95@mail.ru", "subject", "text");

    @Test
    public void createEmailAndSaveAsDraft() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        logger.info("Open mail.ru main page");
        mainPage.enterUsername(ConfigWebDriver.getDefaultUser().getUsername());
        mainPage.enterPassword(ConfigWebDriver.getDefaultUser().getPassword());
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();

        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickCreateMessage();

        CreateMessagePage createMessagePage = new CreateMessagePage(driver);
        createMessagePage.enterRecipient(email.getRecipientEmail());
        createMessagePage.enterSubject(email.getSubject());
        createMessagePage.enterTestMessage(email.getTextMessage());
        createMessagePage.saveEmailAsDraft();

        EmailFoldersList emailFoldersList = new EmailFoldersList(driver);
        emailFoldersList.goToDrafts();
        DraftsPage draftPage = new DraftsPage(driver);

        Assert.assertTrue(draftPage.dragAndDropToArchive(email));
    }
}
