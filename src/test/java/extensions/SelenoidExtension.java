package extensions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.demoqa.config.PracticeFormConfig;

import java.util.HashMap;

public class SelenoidExtension implements BeforeAllCallback {

    private PracticeFormConfig config;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

        // Установка URL для удаленного WebDriver (Selenoid)
        Configuration.remote = getRemoteUrl();
        // Настройка браузера
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "125.0";

        // Установка дополнительных опций для браузера
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("125.0");
        capabilities.setCapability("acceptInsecureCerts", true);

        // Настройка опций Chrome
        HashMap<String, Object> chromeOptions = new HashMap<>();
//        chromeOptions.put("args", Arrays.asList("--proxy-bypass-list=<-loopb...", "--disable-dev-shm-usage", "--window-size=1920,1080"));
//        chromeOptions.put("excludeSwitches", Arrays.asList("enable-automation", "load-extension"));
//        chromeOptions.put("prefs", new HashMap<String, Object>() {{
//            put("credentials_enable_service", false);
//            put("plugins.always_open_pdf_externally", true);
//            put("profile.default_content_setting_values.automatic_downloads", 1);
//            put("profile.password_manager_enabled", false);
//            put("profile.password_manager_leak_detection", false);
//            put("safebrowsing.enabled", true);
//        }});
        capabilities.setCapability("goog:chromeOptions", chromeOptions);

        // Настройки для Selenoid
        HashMap<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);
        capabilities.setCapability("selenoid:options", selenoidOptions);

        Configuration.browserCapabilities = capabilities;

    }

    public String getRemoteUrl(){
        String remoteUrl = System.getProperty("remoteUrl", "http://185.129.51.98:4444/wd/hub");
        return remoteUrl;
    }


}