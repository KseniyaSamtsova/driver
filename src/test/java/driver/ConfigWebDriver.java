package driver;

import driver.WebDriverManager.BrowserType;

import java.util.ResourceBundle;

public class ConfigWebDriver {

    private static final ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static BrowserType getBrowserType() {
        return BrowserType.valueOf(bundle.getString("browser").toUpperCase());
    }

    public static String getDriverPath() {
        return bundle.getString("pathToDriver");
    }

    public static boolean isWindowMaximaze() {
        return Boolean.parseBoolean(bundle.getString("windowMaximize"));
    }

    public static Long getImplicitlyWait() {
        return Long.parseLong(bundle.getString("implicitlyWait"));
    }

    public static Long getPageLoadTimeout() {
        return Long.parseLong(bundle.getString("pageLoadTimeout"));
    }
}
