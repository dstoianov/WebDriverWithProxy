package remotewebdriver;

import base.BaseTest;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Funker on 30.06.14.
 */
public class ChromeRemote extends BaseTest {

    @Test
    public void testName() throws Exception {
        Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.MANUAL);
        proxy.setHttpProxy(proxyIp + ":" + port);
        proxy.setSslProxy(proxyIp + ":" + port);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        //or
        //capabilities.setCapability(CapabilityType.PROXY, server.seleniumProxy());

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
