package webdriver;

import base.BaseTest;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Funker on 30.06.14.
 */
public class ChromeLocalProxy extends BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {

        Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.MANUAL);
        proxy.setHttpProxy(proxyIp + ":" + port);
        proxy.setSslProxy(proxyIp + ":" + port);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        //or
        //capabilities.setCapability(CapabilityType.PROXY, server.seleniumProxy());

        driver = new ChromeDriver(capabilities);

    }
}
