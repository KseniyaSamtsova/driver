package mobile_tests;

import driver.WebDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobile_pages.StartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest1 {

    protected final Logger logger = LogManager.getLogger();
    WebDriver driver;

    @BeforeClass
    void init() {


   driver = WebDriverManager.getInstance();
//    StartPage startPage = new StartPage(driver);
}
    @Test
    public void testOffersSearching() {
        StartPage startPage = new StartPage(driver);

        startPage.continueAsAGuest();

    }
}
