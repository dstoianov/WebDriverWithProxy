package base;

import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Funker on 30.06.14.
 */
public class BaseTest {

    public WebDriver driver;
    public ProxyServer server;
    public String proxyIp = "localhost";
    public int port = 3128;

    @BeforeTest
    public void startProxy() throws Exception {
        server = new ProxyServer(port);
        server.start();
        server.setCaptureHeaders(true);
        server.setCaptureContent(true);
        server.newHar("test proxy");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterTest
    public void stopProxy() throws Exception {
        server.stop();
    }
}
