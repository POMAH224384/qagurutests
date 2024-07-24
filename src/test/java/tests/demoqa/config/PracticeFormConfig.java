package tests.demoqa.config;

import org.aeonbits.owner.Config;

public interface PracticeFormConfig extends Config {

    @Key("remoteUrl")
    @DefaultValue("http://127.0.0.1:4444/wd/hub")
    public String getRemoteUrl();
}
