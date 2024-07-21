package tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


    @Test
    void testIssueSearch(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        String allureExample = "eroshenkoam/allure-example";

        open("https://github.com/");

        $(".box-shadow-none").click();
        $("#query-builder-test").setValue(allureExample).pressEnter();

        $(linkText(allureExample)).click();
        $("#issues-tab").click();
        $(withText("#80")).should(exist);
    }
}
