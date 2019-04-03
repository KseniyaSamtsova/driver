package mobile_tests;

import driver.WebDriverManager;
import mobile_pages.SearchPage;
import mobile_pages.StartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTestMobile {

    private final Logger logger = LogManager.getLogger();
    private String errorMessageExpected = "Please select both pickup and return station.";
    WebDriver driver;

    @BeforeClass
    void init() {
        driver = WebDriverManager.getInstance();
    }

    @Test
    public void testOffersSearchingWithEmptyLocations() {
        StartPage startPage = new StartPage(driver);
        startPage.continueAsAGuest();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickShowOffersButton();
        logger.info("Validate error message");
        Assert.assertEquals(searchPage.getErrorMessage(), errorMessageExpected);
    }

    @AfterClass
    void cleanUp() {
        WebDriverManager.closeDriver();
    }
}
