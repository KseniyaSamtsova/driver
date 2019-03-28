package driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static final String WEBDRIVER_CHROME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_FIREFOX = "webdriver.gecko.driver";

    private static WebDriver driver;

    public enum BrowserType {
        FIREFOX,
        CHROME,
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        switch (ConfigWebDriver.getBrowserType()) {
            case CHROME:
                System.setProperty(WEBDRIVER_CHROME, ConfigWebDriver.getDriverPath());
                driver = new ChromeDriver();
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                break;
            case FIREFOX:
                System.setProperty(WEBDRIVER_FIREFOX, ConfigWebDriver.getDriverPath());
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                break;
        }
        maximize();
        setImplicitlyWait();
        setPageLoadTimeout();
        return driver;
    }

    public static void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } catch (Exception e) {
            System.out.println("Can not quit browser");
        }
    }

    private static void maximize() {
        if (ConfigWebDriver.isWindowMaximaze()) {
            driver.manage().window().maximize();
        }
    }

    private static void setImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(ConfigWebDriver.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    private static void setPageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(ConfigWebDriver.getPageLoadTimeout(), TimeUnit.SECONDS);
    }
}
