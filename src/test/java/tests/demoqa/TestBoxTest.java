package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void testBox() {
        open("/text-box");

        $("#userName").setValue("TEStTest dde");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("current Address 2");
        $("#permanentAddress").setValue("permanent Address 1");
        $("#submit").click();

        $("#output").shouldHave(
                text("TEStTest dde"),
                text("test@test.com"),
                text("current Address 2"),
                text("permanent Address 1"));
    }
}
