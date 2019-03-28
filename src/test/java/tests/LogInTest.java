package tests;

import driver.ConfigWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailMainPage;
import pages.MainPage;

public class LogInTest extends BaseTest {

    String errorMessage = "Введите пароль";

    @Test
    public void logInAndLogOut() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        logger.info("Open mail.ru main page");
        mainPage.enterUsername(ConfigWebDriver.getDefaultUser().getUsername());
        mainPage.enterPassword(ConfigWebDriver.getDefaultUser().getPassword());
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();
        EmailMainPage emailMainPage = new EmailMainPage(driver);

        softAssert.assertEquals(emailMainPage.getCurrentUserEmail(), ConfigWebDriver.getDefaultUser().getUsername());

        emailMainPage.clickLogOut();
        softAssert.assertTrue(mainPage.checkLogOut());
        softAssert.assertAll();
    }

    @Test
    public void logInWithEmptyData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        logger.info("Open mail.ru main page");
        mainPage.enterUsername(ConfigWebDriver.getDefaultUser().getUsername());
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();

        Assert.assertEquals(mainPage.getErrorMessage(), errorMessage);
    }
}
