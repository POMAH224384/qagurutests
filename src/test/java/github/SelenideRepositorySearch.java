package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;

@Tag("remote")
public class SelenideRepositorySearch {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "104.0";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:8080/wd/hub";
    }

    @Test
    void testFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");


        $(".box-shadow-none").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        $$("div.kXssRI div").first().$("a").click();

        $("#repository-container-header").$("a").shouldHave(text("selenide"));


    }
}
