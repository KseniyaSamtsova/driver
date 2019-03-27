package tests;

import driver.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.MainPage;

public class BaseTest {

    protected final Logger logger = LogManager.getRootLogger();

    WebDriver driver = WebDriverManager.getInstance();

    @Test
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        logger.info("Open mail.ru main page");
    }

}
