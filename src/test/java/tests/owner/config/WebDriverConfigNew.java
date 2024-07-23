package tests.owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfigNew extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteUrl")
    @DefaultValue("http://127.0.0.1:4444/wd/hub")
    URL getRemoteUrl();
}
