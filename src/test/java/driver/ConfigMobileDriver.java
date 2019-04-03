package driver;

import driver.WebDriverManager.BrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigMobileDriver {

    private static final ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static URL getAppiumUrl() {
        try {
            return new URL(bundle.getString("url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BrowserType getBrowserType() {
        return BrowserType.valueOf(bundle.getString("browser").toUpperCase());
    }

    public static String getPlatformName() {
        return bundle.getString("platform.name");
    }

    public static String getPlatformVersion() {
        return bundle.getString("platform.version");
    }

    public static String getDeviceName() {
        return bundle.getString("device.name");
    }

    public static String getAppPackage() {
        return bundle.getString("app.package");
    }

    public static String getAppActivity() {
        return bundle.getString("app.activity");
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getPlatformName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceName());
        capabilities.setCapability("appPackage", getAppPackage());
        capabilities.setCapability("appActivity", getAppActivity());
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        return capabilities;
    }
}
