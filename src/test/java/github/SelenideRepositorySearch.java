package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;

public class SelenideRepositorySearch {

    @Test
    void testFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");


        $(".box-shadow-none").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        $$("div.kXssRI div").first().$("a").click();

        $("#repository-container-header").$("a").shouldHave(text("selenide"));


    }
}
