package tests.demoqa.config;

import org.aeonbits.owner.Config;

public interface PracticeFormConfig extends Config {

    @Key("remoteUrl")
    @DefaultValue("")
    public String getRemoteUrl();

}
