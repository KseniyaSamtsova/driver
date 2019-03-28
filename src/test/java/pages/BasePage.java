package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    WebDriver driver;

    protected final Logger logger = LogManager.getLogger();

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void waitForClickableAndClick(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", element);
    }

    protected void unHighlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
    }
    protected void safeClick(WebElement element) {
        //method tries to click until the link to the element is updated
        for (int i = 0; i <= 2; i++) {
            try {
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
