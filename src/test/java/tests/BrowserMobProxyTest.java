//package tests;
//
//import io.netty.handler.codec.http.HttpResponse;
//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.har.Har;
//import net.lightbody.bmp.filters.ResponseFilter;
//import net.lightbody.bmp.proxy.CaptureType;
//import net.lightbody.bmp.util.HttpMessageContents;
//import net.lightbody.bmp.util.HttpMessageInfo;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Proxy;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.testng.annotations.Test;
//
//import java.io.File;
//
//import static util.HarAnalyzer.getRequests;
//mvn cle
//public class BrowserMobProxyTest extends BaseTest {
//
//    String pattern = "mail.ru";
//
//    @Test
//    public void bmpTest() throws Exception {
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.start(0);
//        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//        proxy.newHar();
//
////        proxy.addResponseFilter((response, contents, messageInfo) -> contents
////                .setTextContents("This message body will appear in all responses!"));
//
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setCapability(CapabilityType.PROXY, seleniumProxy);
//        driver = new FirefoxDriver(firefoxOptions);
//
//        driver.get("http://yahoo.com");
//        driver.get("https://mail.ru/");
//
//        Har har = proxy.getHar();
//
//        getRequests(har, pattern);
//
//        File harFile = new File("target/harfile.har");
//        har.writeTo(harFile);
//
//        driver.quit();
//        proxy.stop();
//    }
//}
