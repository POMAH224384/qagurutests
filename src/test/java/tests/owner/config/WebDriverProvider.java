package tests.owner.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfigNew config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfigNew.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
//        RemoteWebDriver remoteWebDriver = createRemoteWebDriver();
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createWebDriver() {
        switch (config.getBrowser()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case EDGE: {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default: {
                throw new RuntimeException("Unsupported browser");
            }
        }
    }

//    public RemoteWebDriver createRemoteWebDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("browserVersion", "125.0");
//        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(config.getRemoteUrl(), options);
//        return remoteWebDriver;
//    }
}
