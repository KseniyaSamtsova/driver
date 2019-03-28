package tests;

import driver.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected final Logger logger = LogManager.getLogger();

    SoftAssert softAssert = new SoftAssert();

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void init() {
        driver = WebDriverManager.getInstance();
        System.err.println(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.closeDriver();
        logger.info("Driver closed");
    }
}
