package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import pages.RegistrationPage;


public class TestBaseExtended {

    protected RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUpBeforeClass() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:8080/wd/hub";
    }
}
