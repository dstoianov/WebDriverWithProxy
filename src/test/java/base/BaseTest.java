package base;

import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.InetAddress;

/**
 * Created by Funker on 30.06.14.
 */
public class BaseTest {

    public WebDriver driver;
    public ProxyServer server;
    public String proxyIp = "172.31.29.21";
    public int port = 8085;
    public String url = "http://automated-testing.info/";

    @BeforeTest
    public void startProxy() throws Exception {
        server = new ProxyServer(port);
        server.start();
        server.setCaptureHeaders(true);
        server.setCaptureContent(true);
        server.setLocalHost(InetAddress.getByName(proxyIp));
        server.newHar("test_proxy");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterTest
    public void stopProxy() throws Exception {
        server.stop();
    }

    public void doTest() throws InterruptedException {
        driver.get(url);
        driver.get(url);

        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='search-dropdown']/input"));
        element.sendKeys("proxy");
        Thread.sleep(2000);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
    }

}
