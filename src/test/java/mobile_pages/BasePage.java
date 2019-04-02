package mobile_pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    protected final Logger logger = LogManager.getLogger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
