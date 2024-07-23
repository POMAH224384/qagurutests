package tests.owner.config;

import org.junit.jupiter.api.Tag;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverConfig {

    public String getBaseUrl(){
        String baseUrl = System.getProperty("baseUrl");
        if(baseUrl == null){
            baseUrl = "https://github.com";
        }
        return baseUrl;
    }

    public Browser getBrowser(){
        String browser = System.getProperty("browser");
        if(browser == null){
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
    }

    public URL getRemoteUrl(){
        String remoteUrl = System.getProperty("remoteUrl", "http://localhost:4444");
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
