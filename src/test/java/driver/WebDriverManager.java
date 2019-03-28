package driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static com.sun.corba.se.impl.activation.ServerMain.logError;

public class WebDriverManager {

    private static final String WEBDRIVER_CHROME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_FIREFOX = "webdriver.gecko.driver";

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public enum BrowserType {
        FIREFOX,
        CHROME,
    }

    public static WebDriver getInstance() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;
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
        maximize(driver);
        setImplicitlyWait(driver);
        setPageLoadTimeout(driver);
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        } catch (Exception e) {
            logError("Can not quit browser");
        }
    }

    private static void maximize(WebDriver driver) {
        if (ConfigWebDriver.isWindowMaximaze()) {
            driver.manage().window().maximize();
        }
    }

    private static void setImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(ConfigWebDriver.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    private static void setPageLoadTimeout(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(ConfigWebDriver.getPageLoadTimeout(), TimeUnit.SECONDS);
    }
}
